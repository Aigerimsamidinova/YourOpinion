package com.example.projectXX.service;

import com.example.projectXX.model.UserCheck;
import com.example.projectXX.reposiroty.UserCheckRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserCheckServicelmpl implements CrudService<UserCheck> {
    @Autowired
    private UserCheckRep userCheckRep;

    @Override
    public List<UserCheck> getAll() {
        return null;
    }

    @Override
    public UserCheck findById(Long id) {
        return userCheckRep.findById(id).get();
    }

    @Override
    public UserCheck save(UserCheck userCheck) {
        return userCheckRep.save(userCheck);
    }

    @Override
    public UserCheck update(UserCheck userCheck) {
        return userCheckRep.save(userCheck);
    }

    @Override
    public void deleteById(Long id) {
        this.userCheckRep.deleteById(id);
    }

    @Override
    public void deleteAll() {

    }
}
