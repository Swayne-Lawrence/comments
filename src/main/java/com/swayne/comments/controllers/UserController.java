package com.swayne.comments.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.swayne.comments.models.User;
import com.swayne.comments.services.CommentService;
import com.swayne.comments.services.PostService;
import com.swayne.comments.services.UserService;
import com.swayne.comments.validators.UserValid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValid userValid;

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String index(@ModelAttribute("user") User user, HttpSession session){
        if(session.getAttribute("userId") != null)
            return "redirect:/homepage";
        return "/user/index.jsp";
    }

    @PostMapping("/form")
    public String form(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session){
        userValid.validate(user, result);
        if(result.hasErrors()){
            return "/user/index.jsp";
        }
        User newUser= userService.create(user);
        session.setAttribute("userId", newUser.getId());

        return "redirect:/homepage";

    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirect){
        if(!(userService.auth(email, password))){
            redirect.addFlashAttribute("error","Invalid email/password");
            return "redirect:/";
        }
        User user=userService.findByEmail(email);
        session.setAttribute("userId", user.getId());
        return "redirect:/homepage";
    }

    @GetMapping("/homepage")
    public String homepage(Model model, HttpSession session){
        if(session.getAttribute("userId") == null)
            return "redirect:/";
        model.addAttribute("user", userService.getOne((Long)session.getAttribute("userId")) );
        model.addAttribute("posts", postService.getAll());
        return "/user/homepage.jsp";
    }
}
