package com.gbf.testcontainer.controller;

import com.gbf.testcontainer.TestContainer;
import com.gbf.testcontainer.TestContainerApplication;
import com.gbf.testcontainer.model.User;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = TestContainer.getInstance();
    
    @Autowired 
    private JdbcTemplate jdbcTemplate;
    
    @Test
    public void getUsers() {
        User user1 = new User( "log1", "pass1");
        User user2 = new User( "log2", "pass2");
        jdbcTemplate.update("Insert into users( username, password) values(?,?)",  user1.getUsername(), user1.getPassword());
        jdbcTemplate.update("Insert into users(username, password) values(?,?)",  user2.getUsername(), user2.getPassword());
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from users");
        System.out.println(maps);
        assertThat(maps.size()==2);
    }
}
