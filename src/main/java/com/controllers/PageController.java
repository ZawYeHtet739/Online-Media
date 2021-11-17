package com.controllers;

import com.models.Category;
import com.models.Post;
import com.models.User;
import com.services.CategoryService;
import com.services.PostService;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private PostService postService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(HttpSession session,Model model) {
        List<Post> posts = postService.getAllPost();
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("posts", posts);
        session.setAttribute("categories", categories);
        return "home";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/admin/home")
    public String admin(Model model) {
        List<Post> posts = postService.getAllPost();
        model.addAttribute("posts", posts);
        return "admin.home";
    }

    @RequestMapping("/author/home")
    public String author(Model model) {

        // Get UserName
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
//        if (principal instanceof UserDetails) {
//            String username = ((UserDetails) principal).getUsername();
//            System.out.println(username);
//        } else {
//            String username = principal.toString();
//            System.out.println(username);
//        }

        User user = userService.getUserByName(username);
        List<Post> posts = user.getPosts();
        model.addAttribute("posts",posts);

        return "author.home";
    }

    @RequestMapping("/user/home")
    public String userHome(Model model) {

        // Check Admin or Author
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // if ROLE_ADMIN exist bol is true
        boolean bol = authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));

        if (bol) {
            return "redirect:/admin/home";
        } else {
            return "redirect:/author/home";
        }
    }

}
