package ru.vesnina.spring_boot.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vesnina.spring_boot.SpringBoot.model.User;
import ru.vesnina.spring_boot.SpringBoot.service.UserService;


@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());

        return "getUsers";
    }

    @GetMapping("/{id}/show")
    public String showUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.showUserById(id));

        return "showUserById";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

        @GetMapping("/{id}/updateUser")
    public String updateUserById(@PathVariable("id") Long id, Model model) {
            model.addAttribute("user", userService.showUserById(id));
        return "updateUserById";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUserById(id, user);
        return "redirect:/";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
