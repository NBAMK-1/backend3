package com.example.backend3.Controller;

import com.example.backend3.Entity.transaction;
import com.example.backend3.Repository.transactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class DashboardController {
    @Autowired
    transactionRepository tr;

    @GetMapping("/Dashboard")
    public String at(Model model){
        List<transaction> r = tr.findAll();
        model.addAttribute("transactionHistory1",r);
        return "DashBoard";
    }

}
