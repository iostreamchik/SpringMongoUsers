package com.springapp.console;

import com.springapp.entitys.User;
import com.springapp.repo.UserRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.UnknownHostException;
import java.util.List;

public class Console {
    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext context = new ClassPathXmlApplicationContext("../webapp/WEB-INF/mvc-dispatcher-servlet.xml");
        context.getBean("mongoTemplate");

        UserRepo userRepo = new UserRepo();

        List<User> list = userRepo.getCollection();
        for (User user : list) {
            System.out.println(user.getName());
        }


    }
}
