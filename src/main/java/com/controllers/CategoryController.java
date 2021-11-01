package com.controllers;

import com.models.Category;
import com.models.Post;
import com.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/admin/cat/all")
    public String catAll(Model model) {
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "admin.cat.all";
    }

    @RequestMapping("/admin/cat/create")
    public String showCatCreatePage(Model model) {
        model.addAttribute("category", new Category());
        return "admin.cat.create";
    }

    @RequestMapping(value = "/admin/cat/create", method = RequestMethod.POST)
    public String catCreate(Model model, @ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/cat/all";
    }

    @RequestMapping("/admin/cat/edit/{id}")
    public String showCatEditPage(Model model, @PathVariable("id") String id) {
        Category category = categoryService.getCategoryById(Integer.parseInt(id));
        model.addAttribute("category", category);
        return "admin.cat.edit";
    }

    @RequestMapping(value = "/admin/cat/edit", method = RequestMethod.POST)
    public String catEdit(Model model, @ModelAttribute("category") Category category) {
        categoryService.updateCategory(category);
        return "redirect:/admin/cat/all";
    }

    @RequestMapping("/admin/cat/delete/{id}")
    public String showCatDeletePage(Model model, @PathVariable("id") String id) {
        categoryService.deleteCategory(Integer.parseInt(id));
        return "redirect:/admin/cat/all";
    }

    @RequestMapping("/cat/{id}")
    public String showCategoryPage(Model model, @PathVariable("id") String id) {
        Category category = categoryService.getCategoryById(Integer.parseInt(id));
        List<Post> posts = category.getPosts();
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("posts", posts);
        model.addAttribute("categories", categories);
        return "catpage";
    }


}
