package com.durco.baeldungtestapp.controller;

import com.durco.baeldungtestapp.model.User;
import com.durco.baeldungtestapp.repository.UserRepository;
import com.durco.baeldungtestapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class ControllerBealdungTest {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String registrationPage() {
        return "registrationPage";
    }

    @GetMapping("/getUser/{name}")
    public User getUser(@PathVariable(value = "name") String name) {
        return userService.findByName(name);
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable(value = "id") String id) {
        return userService.findUserById(id);
    }

    @PostMapping("/saveUser")
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "home";
    }

    //    @PostMapping("/saveUser")
//    public ModelAndView saveNewUser(@ModelAttribute("user") User user ) {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("home");
//        mav.addObject(user);
//        return mav;
//    }
    @ResponseBody
    @GetMapping("/getUsers")
    public Collection<User> getAllUsers() {
        User user= new User();
        return userService.getAllUsers();
    }

    @GetMapping("/deleteUser")
    public void deleteByUserName(@RequestParam String name) {
        userService.deleteUserByName(name);
    }

    @GetMapping("/deleteAllUsers")
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }

//    @GetMapping("/")
//    public ModelAndView homePage(ModelMap map, @PathVariable(name = "variable") String variable) {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("home");
//        model.addObject("appName", appName);
//        map.addAttribute("message",variable);
//        return model;
//    }


}
