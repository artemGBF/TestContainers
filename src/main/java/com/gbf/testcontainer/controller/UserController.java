package com.gbf.testcontainer.controller;

import com.gbf.testcontainer.model.User;
import com.gbf.testcontainer.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Repo repo;

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        //return jdbcTemplate.queryForList("select * from users");
        return repo.findAll();
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
          //return jdbcTemplate.update(
               // "INSERT INTO users VALUES (?, ?, ?)", user.getId(), user.getUsername(), user.getPassword());
        return repo.save(user);
    }

}
