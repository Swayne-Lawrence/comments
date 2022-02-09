package com.swayne.comments.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.swayne.comments.models.Post;
import com.swayne.comments.repositories.PostRepo;
import com.swayne.comments.services.PostService;
import com.swayne.comments.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/create_post")
    public String create_post(@ModelAttribute("post") Post post, HttpSession session,Model model){
        if(session.getAttribute("userId") == null)
            return "redirect:/";
        model.addAttribute("user", userService.getOne((Long)session.getAttribute("userId")));

        return "/post/create_post.jsp";
    }

    @PostMapping("/post_form")
    public String post_form(@Valid @ModelAttribute("post") Post post, BindingResult result){
        if(result.hasErrors()){
            return "/post/create_post.jsp";
        }
        Post newPost=postService.create(post);
        String id= String.valueOf(newPost.getId());
        return "redirect:/user_post/"+id;
        
    }
    @GetMapping("/user_post/{id}")
    public String user_post(@PathVariable("id") Long id, Model model, HttpSession session){
        if(session.getAttribute("userId") == null)
            return "redirect:/";
        model.addAttribute("user", userService.getOne((Long)session.getAttribute("userId")));

        model.addAttribute("post", postService.getOne(id));

        return "/post/user_post.jsp";
    }
    @GetMapping("/edit_post/{id}")
    public String edit_post(@PathVariable("id") Long id,Model model, HttpSession session, @ModelAttribute("post") Post post){
        if(session.getAttribute("userId") == null)
            return "redirect:/";
        model.addAttribute("user", userService.getOne((Long)session.getAttribute("userId")));
        model.addAttribute("post", postService.getOne(id));
        return "/post/edit_post.jsp";
    }

    @PutMapping("/edit_post_form/{id}")
    public String edit_post_form(@Valid @ModelAttribute("post") Post post, BindingResult result, @PathVariable("id") Long id,Model model){
        if(result.hasErrors()){
            model.addAttribute("post", post);
            return "/post/edit_post.jsp";
        }
        postService.create(post);
        return "redirect:/user_post/{id}";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        postService.delete(id);
        return "redirect:/homepage";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
