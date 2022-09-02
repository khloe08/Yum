package com.recipe.Yum.controller;


import com.recipe.Yum.Service.UserService;
import com.recipe.Yum.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/new")
    public String createForm(Model model){
        model.addAttribute("userForm",new UserForm());
        return "users/createUserForm";
    }

    @PostMapping("/users/new")
    public String create(@Valid UserForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "users/createUserForm";
        }
        User user = new User();
        user.setName(form.getName());

        userService.join(user);
        return "redirect:users/userList";
    }

    @GetMapping("/users")
    public String list(Model model){
        model.addAttribute("users", userService.findMembers());
        return "users/userList";
    }
}
