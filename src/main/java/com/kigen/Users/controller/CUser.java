package com.kigen.Users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kigen.Users.model.EUser;
import com.kigen.Users.repository.UserDAO;

import jakarta.validation.Valid;

@Controller
public class CUser {
    
    @Autowired
    private UserDAO userDAO;

    @PostMapping(path = "/createuser")
    public String createUser(@Valid EUser user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create-user";
        }

        userDAO.save(user);
        return "redirect:/index";
    }

    @GetMapping(path = "/signup")
    public String showCreateUserForm(EUser user, Model model) {
        model.addAttribute("user", user);
        return "create-user";
    }

    @GetMapping(path = "/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userDAO.findAll());
        return "index";
    }

    @GetMapping(path = "/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        EUser user = userDAO.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        model.addAttribute("user", user);

        return "update-user";
    }

    @PostMapping(path = "/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid EUser user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-user";
        }

        userDAO.save(user);

        return "redirect:/index";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        EUser user = userDAO.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        userDAO.delete(user);

        return "redirect:/index";
    }
}
