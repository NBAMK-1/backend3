package com.example.backend3.Controller;

import com.example.backend3.Entity.transaction;
import com.example.backend3.Repository.transactionRepository;
import com.example.backend3.Service.transactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class pagingController {

    @Autowired
    private transactionService transService;

    @Autowired
    transactionRepository trp;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<transaction> r = trp.findAll();
        model.addAttribute("transactionHistory1",r);
        return findPaginated(1, "sender", "asc", model);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 6;

       Page<transaction> page = transService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<transaction> listEmployees = page.getContent();

        List<transaction> r = trp.findAll();
        model.addAttribute("transactionHistory1",r);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listEmployees", listEmployees);
        return "DashBoard";
    }
}
