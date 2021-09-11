package com.example.backend3.Controller;


import com.example.backend3.Entity.Group;
import com.example.backend3.Entity.User;
import com.example.backend3.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class login_signUpController {
    @Autowired
    userRepository uRep;

    @GetMapping("/register")
    public String signUpPage( Model model){
        return "signUp";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam String name , @RequestParam String phone_no ,@RequestParam String password , Model model){
        save(name,phone_no,password);
        return "login";
    }

    private void save(String name, String phone_no, String password) {
        User u = new User();
        u.setName(name);
        u.setNumber(phone_no);
        u.setPassword(password);
        uRep.save(u);
    }

    @GetMapping("/addGroup")
        public String addGroup(Model model){
        Group g = new Group();
         List<User> u = uRep.findAll();
         model.addAttribute("group",g);
         model.addAttribute("allUser",u);
            return "addGroup";
    }
}
