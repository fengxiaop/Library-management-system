package com.javaclimb.book;

import com.javaclimb.book.entity.User;
import com.javaclimb.book.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DrugApplicationTests {

    @Autowired
    private IUserService userService;
    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("admin");
        User user1 = userService.queryUserByUsername(user);
        if(user1!=null){
            System.out.println(user1.getPassword());
        }
    }

    @Test
    void insertUserList() {
        for (int i = 0; i < 1000; i++) {
            User user = new User();
            user.setUsername("admin"+i);
            user.setPassword("adminidx"+i);
            userService.addUser(user);
        }
    }

}
