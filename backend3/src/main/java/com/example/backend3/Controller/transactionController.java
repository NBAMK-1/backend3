package com.example.backend3.Controller;

import com.example.backend3.Entity.transaction;
import com.example.backend3.Repository.transactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class transactionController {

    @Autowired
    transactionRepository transRepo;

    @GetMapping("/makePayment")
    public String makPay(){
        return "transaction";
    }

    @GetMapping("/transactionHistory")
    public String transHis(@RequestParam String sender, @RequestParam String receiver,@RequestParam String date,@RequestParam String amount){
       save(sender,receiver,date,amount);
        return "PaymentConfirmation";
    }

    private void save(String sender, String receiver, String date, String amount) {
        transaction t = new transaction();
        t.setSender(sender);
        t.setReceiver(receiver);
        t.setDate(date);
        t.setAmount(amount);
        transRepo.save(t);
    }

    @GetMapping("/makePayment/history")
    public String his(Model model){

        List<transaction> tr = transRepo.findAll();
        model.addAttribute("transactionHistory",tr);
        return"history";
    }



}
