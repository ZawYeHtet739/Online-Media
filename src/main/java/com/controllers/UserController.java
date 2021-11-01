package com.controllers;

import com.models.Authority;
import com.models.Post;
import com.models.User;
import com.services.AuthorityService;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/login")
    public String login(
            @RequestParam(name = "error", required = false) String error,
            @RequestParam(name = "logout", required = false) String logout,
            Model model
    ) {
        if (error != null) {
            model.addAttribute("error","Login Error,Please try again!!!!");
        }

        if (logout != null) {
            model.addAttribute("logout","Logout Successful!!!");
        }
        return "login";
    }

    @RequestMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @Valid @ModelAttribute("user") User user, BindingResult result) {
//        System.out.println(user);
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error.getDefaultMessage());
            }
            return "register";
        } else {
            userService.addUser(user);
            authorityService.addAuthority(new Authority(user.getUsername(), "ROLE_AUTHOR"));
            model.addAttribute("register_success","Register Successful! Please Login");
            return "login";
        }

    }

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


    @RequestMapping("/admin/user/delete/{id}")
    public String deleteUser(Model model, @PathVariable("id") String id) {
        userService.deleteUserById(Integer.parseInt(id));
        return "";
    }

    @RequestMapping("/admin/user/toggle/{id}")
    public String userToggle(Model model, @PathVariable("id") String id) {
        User user = userService.getUserById(Integer.parseInt(id));
        if (user.isEnabled()) {
            user.setEnabled(false);
        } else {
            user.setEnabled(true);
        }
        userService.updateUser(user);
        return "redirect:/admin/user/all";
    }


}
