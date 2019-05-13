package com.example.projectXX.service;

import com.example.projectXX.model.Comment;
import com.example.projectXX.model.Question;
import com.example.projectXX.model.User;
import com.example.projectXX.model.UserCheck;
import com.example.projectXX.reposiroty.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements CrudService<User>, UserService {
    @Autowired
    private UserRep userRep;
    @Autowired
    private QuestionRep questionRep;
    @Autowired
    private CategoryRep categoryRep;
    @Autowired
    private CommentRep commentRep;
    @Autowired
    private UserCheckRep userCheckRep;

    @Override
    public Question addQuestion(Long userId, Long categoryId, Question question) {
        Question q = questionRep.save(question);
        q.setCategory(categoryRep.findById(categoryId).get());
        q.setDislikes(0);
        q.setLikes(0);
        q.setUser(userRep.findById(userId).get());
        List<Comment> comments = new ArrayList<>();
        q.setComments(comments);
        List<User> users = new ArrayList<>();
        q.setUsers(users);
        List<UserCheck> userChecks = new ArrayList<>();
        q.setUserChecks(userChecks);
        questionRep.save(q);
        return q;
    }

    @Override
    public Question addCommentToQuestion(Long userId, Long questionId, Comment comment) {
        Comment c = commentRep.save(comment);
        Question q = getQuestion(questionId, c);
        c.setUser(userRep.findById(userId).get());
        c.setDislikes(0);
        c.setLikes(0);
        commentRep.save(c);
        return q;
    }

    public Question getQuestion(Long questionId, Comment comment) {
        Question q = questionRep.findById(questionId).get();
        List<Comment> comments = q.getComments();
        comments.add(comment);
        questionRep.save(q);
        return q;
    }

    @Override
    public Question putMarkOnTheQuestion(Long userId, Long questionId, Character mark) {
        Question question = questionRep.findById(questionId).get();
        User user1 = userRep.findById(userId).get();
        List<UserCheck> userBln = question.getUserChecks();
        List<User> userIds = question.getUsers();
        boolean checkUserId = true;
        for (User user : userIds) {
            if (user.getId().equals(userId)) {
                checkUserId = false;
                break;
            }
        }
        if (checkUserId) {
            if (mark.equals('+')) {
                question.setLikes(question.getLikes() + 1);
                UserCheck userCheck = new UserCheck('+');
                userCheck.setUserId(userId);
                userCheckRep.save(userCheck);
                userBln.add(userCheck);
                userIds.add(user1);
            } else {
                question.setDislikes(question.getDislikes() + 1);
                UserCheck userCheck = new UserCheck('-');
                userCheck.setUserId(userId);
                userCheckRep.save(userCheck);
                userBln.add(userCheck);
                userIds.add(user1);
            }
        } else {
            for (UserCheck userCheck : userBln) {
                if (userCheck.getUserId().equals(userId)) {
                    if (userCheck.getCharacter().equals('+')) {
                        if (mark.equals('-')) {
                            userCheck.setCharacter('-');
                            question.setDislikes(question.getDislikes() + 1);
                            question.setLikes(question.getLikes() - 1);
                            userCheckRep.save(userCheck);
                        }
                    } else {
                        if (mark.equals('+')) {
                            userCheck.setCharacter('+');
                            question.setDislikes(question.getDislikes() - 1);
                            question.setLikes(question.getLikes() + 1);
                            userCheckRep.save(userCheck);
                        }
                    }
                }
            }
        }
        question.setUsers(userIds);
        question.setUserChecks(userBln);
        questionRep.save(question);
        return question;    }

    @Override
    public Comment putMarkOnTheComment(Long userId, Long questionId, Long commentId, Character mark) {
        User user1 = userRep.findById(userId).get();
        Question question = questionRep.findById(questionId).get();
        Comment c = commentRep.findById(commentId).get();
        List<UserCheck> userBln = c.getUserChecks();
        List<User> userIds = c.getUsers();
        List<Comment> comments = question.getComments();
        boolean checkUserIds = true;
        for (Comment comment : comments) {
            if (comment.getId().equals(commentId)) {
                for (User user : userIds) {
                    if (user.getId().equals(userId)) {
                        checkUserIds = false;
                        break;
                    }
                }
            }
        }
        if (checkUserIds) {
            if (mark.equals('+')) {
                c.setLikes(c.getLikes() + 1);
                UserCheck userCheck = new UserCheck('+');
                userCheck.setUserId(userId);
                userBln.add(userCheck);
                userCheckRep.save(userCheck);
                c.getUsers().add(user1);
            } else {
                c.setDislikes(c.getDislikes() + 1);
                UserCheck userCheck = new UserCheck('-');
                userBln.add(userCheck);
                userCheck.setUserId(userId);
                userCheckRep.save(userCheck);
                c.getUsers().add(user1);
            }
        } else {
            for (UserCheck userCheck : userBln) {
                if (userCheck.getUserId().equals(userId)) {
                    if (userCheck.getCharacter().equals('+')) {
                        if (mark.equals('-')) {
                            userCheck.setCharacter('-');
                            c.setDislikes(c.getDislikes() + 1);
                            c.setLikes(c.getLikes() - 1);
                            userCheckRep.save(userCheck);
                        }
                    } else {
                        if (mark.equals('+')) {
                            c.setDislikes(c.getDislikes() - 1);
                            c.setLikes(c.getLikes() + 1);
                            userCheck.setCharacter('+');
                            userCheckRep.save(userCheck);
                        }
                    }
                }
            }
        }
        c.setUsers(userIds);
        c.setUserChecks(userBln);
        commentRep.save(c);
        return c;
    }

    @Override
    public List<User> getAll() {
        return userRep.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRep.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userRep.save(user);
    }

    @Override
    public User update(User user) {
        return userRep.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRep.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userRep.deleteAll();
    }
}
