package com.swayne.comments.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.swayne.comments.models.Comment;
import com.swayne.comments.models.Cp;
import com.swayne.comments.repositories.CommentRepo;
import com.swayne.comments.services.CommentService;
import com.swayne.comments.services.CpService;
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

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private CpService cpService;

    private long num=0;

    @GetMapping("/create_comment/{id}")
    public String create_comment(@PathVariable("id") Long id,HttpSession session, Model model, @ModelAttribute("comment") Comment comment, @ModelAttribute("cp") Cp cp){
        if(session.getAttribute("userId") == null)
            return "redirect:/";
        this.num++;
        model.addAttribute("num", this.num);

        model.addAttribute("user", userService.getOne((Long)session.getAttribute("userId")));
        model.addAttribute("post", postService.getOne(id));
        return "/comment/create_comment.jsp";
    }

    @PostMapping("/comment_form/{id}")
    public String comment_form(@Valid @ModelAttribute("comment") Comment comment, BindingResult result, @PathVariable("id") Long id){
        if(result.hasErrors()){
            return "/comment/create_comment.jsp";
        }

        Comment newCom= commentService.create(comment);

        Cp cp=new Cp(postService.getOne(id), commentService.getOne(newCom.getId()));
        cpService.create(cp);

        String s_id=String.valueOf(id);

        return "redirect:/all_comment/"+s_id;

    }

    @GetMapping("/all_comment/{id}")
    public String all_comment(@PathVariable("id") Long id, Model model, HttpSession session){
        if(session.getAttribute("userId") == null)
            return "redirect:/";
        model.addAttribute("user", userService.getOne((Long)session.getAttribute("userId")));
        model.addAttribute("comments", commentService.getAll());
        model.addAttribute("post", postService.getOne(id));
        return "/comment/all_comment.jsp";
    }
}
