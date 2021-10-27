package com.controllers;

import com.models.Post;
import com.models.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/admin/user/all")
    public String userById(Model model) {
        List<User> users = userService.getAllUser();
//        for (User user : users) {
//            for(Post post : user.getPosts()){
//                System.out.println(post);
//            }
//        }
        model.addAttribute("users", users);
        return "admin.user.all";
    }

    @RequestMapping("/user/{id}")
    public String userById(Model model, @PathVariable("id") String id) {
        User user = userService.getUserById(Integer.parseInt(id));
        System.out.println(user);
        return "";
    }

    @RequestMapping("/user/delete/{id}")
    public String deleteUser(Model model, @PathVariable("id") String id) {
        userService.deleteUserById(Integer.parseInt(id));
        return "";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
