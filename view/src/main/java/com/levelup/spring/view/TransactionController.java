package com.levelup.spring.view;

import com.levelup.spring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by denis_zavadsky on 4/4/15.
 */
@Controller
@RequestMapping("/trans")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/index")
    public String getIndexPage(Model model){
        model.addAttribute("transactions",transactionService.getAll());
        return "index.page";
    }
}
