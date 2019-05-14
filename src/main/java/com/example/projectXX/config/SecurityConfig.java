package com.example.projectXX.config;//package com.example.Project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
   protected void configure (AuthenticationManagerBuilder auth) throws  Exception{
        auth.inMemoryAuthentication().withUser("admin")
                .password("{noop}admin123").roles("ADMIN")
                .and()
                .withUser("user")
                .password("{noop}user123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/category/add").hasRole("ADMIN")
                .antMatchers("/user/add").hasRole("ADMIN")
                .antMatchers("/user/getAll").hasRole("ADMIN")
                .antMatchers("/user/getById/{id}").hasRole("ADMIN")
                .antMatchers("/user/update").hasAnyRole("ADMIN","USER")
                .antMatchers("/user/deleteById/{id}").hasRole("ADMIN")
                .antMatchers("/user/deleteAll").hasRole("ADMIN")
                .antMatchers("/user/putMarkOnTheComment/{userId}/{questionId}/{commentId}/{mark}").permitAll()
                .antMatchers("/user/putMarkOnTheQuestion/{userId}/{questionId}/{mark}").permitAll()
                .antMatchers("/user/addCommentToQuestion/{userId}/{questionId}").permitAll()
                .antMatchers("/user/addQuestion/{userId}/{categoryId}").permitAll()

                .antMatchers("/category/getAll").permitAll()
                .antMatchers("/category/getById/{id}").permitAll()
                .antMatchers("/category/add").hasRole("ADMIN")
                .antMatchers("/category/update").hasRole("ADMIN")
                .antMatchers("/category/deleteById/{id}").hasRole("ADMIN")
                .antMatchers("/category/deleteAll").hasRole("ADMIN")

                .antMatchers("/comment/getQuestionCommentsByLikes/{questionId}").permitAll()
                .antMatchers("/comment/statistics").permitAll()
                .antMatchers("/comment/add").permitAll()
                .antMatchers("/comment/getAll").permitAll()
                .antMatchers("/comment/deleteAll").hasRole("ADMIN")
                .antMatchers("/comment/get/{id}").permitAll()
                .antMatchers("/comment/update").hasRole("ADMIN")
                .antMatchers("/comment/deleteById/{id}").hasRole("ADMIN")
                .antMatchers("/comment/getByTag/{tag}").hasAnyRole()

                .antMatchers("/question/getAll").permitAll()
                .antMatchers("/question/statistics").permitAll()
                .antMatchers("/question/top3").permitAll()
                .antMatchers("/question/getById/{id}").permitAll()
                .antMatchers("/question/add").permitAll()
                .antMatchers("/question/update").hasRole("ADMIN")
                .antMatchers("/question/deleteById/{id}").hasRole("ADMIN")
                .antMatchers("/question/deleteAll").hasRole("ADMIN")
                .and()
                .httpBasic()
                .and()
                .logout();
    }
}
