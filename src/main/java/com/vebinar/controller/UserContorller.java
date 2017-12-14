package com.vebinar.controller;

import com.vebinar.dao.UserDao;
import com.vebinar.entity.User;
import com.vebinar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.management.MemoryUsage;


@Controller
@RequestMapping("/")
public class UserContorller {

    public final UserService userService;

    @Autowired
    public UserContorller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
    
    @GetMapping("/hello")
    public String hello() {

        return "hello";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }

    @GetMapping("/user/{id}")
    public String getById (@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getById(id));

        return "showUser";
    }

    @GetMapping("/addUser")
    public String createUserPage(){
        return "createUser";
    }
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }
    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/user/" + user.getId();
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }
}
