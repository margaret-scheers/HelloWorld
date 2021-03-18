package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    public static List<User> users = new ArrayList<User>();

    private static int usersCount = 3;

    static {
        User user1 = new User(101, "name1" , new Date());
        User user2 = new User(102, "name2" , new Date());
        User user3 = new User(103, "name3" , new Date());

        users.add(user1);
        users.add(user2);
        users.add(user3);

    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user){
        if (user.getId() == null) {
            user.setId(++usersCount);

        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
