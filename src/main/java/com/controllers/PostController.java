package com.controllers;

import com.models.Category;
import com.models.Post;
import com.models.User;
import com.services.CategoryService;
import com.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/post/all")
    public String postAll(Model model) {
        List<Post> posts = postService.getAllPost();
//        for (Post post : posts) {
//            User user = post.getUser();
//            System.out.println(user);
//        }
////        for (Post post : posts) {
////            Category category = post.getCategory();
////            System.out.println(category);
////        }
        model.addAttribute("posts", posts);
        return "author.post.all";
    }

    @RequestMapping("/post/create")
    public String showPostCreatePage(Model model) {
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        model.addAttribute("post", new Post());
        return "author.post.create";
    }

    @RequestMapping(value = "/post/create", method = RequestMethod.POST)
    public String postCreate(Model model, @ModelAttribute("post") Post post, HttpServletRequest request) {
        MultipartFile file = post.getFile();

        if (file != null && !file.isEmpty()) {
            String imageName = saveImage(file, request);
            post.setImage(imageName);
        }
        //Get Session User and set to Post User

        post.setUser_id(1);
        postService.addPost(post);

        return "redirect:/post/all";
    }

    public String saveImage(MultipartFile file, HttpServletRequest request) {
        String imageName = System.currentTimeMillis() + ".png";

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(rootDirectory + "WEB-INF/assets/imgs/" + imageName);

        if (file != null && !file.isEmpty()) {
            try {
                file.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Image Can't be upload!");
            }
        }
        return imageName;
    }

    @RequestMapping("/post/edit/{id}")
    public String showPostEditPage(Model model, @PathVariable("id") String id) {
        Post post = postService.getPostById(Integer.parseInt(id));
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        model.addAttribute("post", post);
        return "author.post.edit";
    }

    @RequestMapping(value = "/post/edit", method = RequestMethod.POST)
    public String postEdit(Model model, @ModelAttribute("post") Post post, HttpServletRequest request) {
        MultipartFile file = post.getFile();

        if (file != null && !file.isEmpty()) {
            String imageName = saveImage(file, request);
            post.setImage(imageName);
        }

        postService.updatePost(post);
        return "redirect:/post/all";
    }

    @RequestMapping("/post/delete/{id}")
    public String postDelete(Model model, @PathVariable("id") String id) {
        postService.deletePost(Integer.parseInt(id));
        return "redirect:/post/all";
    }

    @RequestMapping("/post/{id}")
    public String showSinglePostPage(Model model, @PathVariable("id") String id) {
        Post post = postService.getPostById(Integer.parseInt(id));
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        model.addAttribute("post", post);
        return "post";
    }

}
