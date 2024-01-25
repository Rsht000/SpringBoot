package com.example.springboot.Controller;

import com.example.springboot.Model.User;
import com.example.springboot.Service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    private final UserServiceImpl userService;

    public UserController( UserServiceImpl userService) {
        this.userService = userService;

    }

    @GetMapping(value = "/user", produces = "text/html; charset=UTF-8")
    public String carList(Model model) {
        List<User> users = userService.displayAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/addNewUser", produces = "text/html; charset=UTF-8")
    public String newCar(Model model) {
        model.addAttribute("user", new User());
        return "addNewUser";
    }

    @PostMapping(value = "/addNewUser", produces = "text/html; charset=UTF-8")
    public String create(User user) {
        userService.addNewUser(user);
        return "redirect:/user";
    }
    @GetMapping(value = "/Update-User" ,produces = "text/html; charset=UTF-8")
    public String userUpdateForm(@RequestParam Long id , Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "/Update-User";
    }
    @PatchMapping(value = "/Update-User",produces = "text/html; charset=UTF-8")
    public String  userUpdate(User user){
        userService.addNewUser(user);
        return "redirect:/user";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id , Model model) {
        userService.deleteUser(id);
        return "redirect:user";

    }
}
