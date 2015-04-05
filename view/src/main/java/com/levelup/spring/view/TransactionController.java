package com.levelup.spring.view;

import com.levelup.spring.model.Transaction;
import com.levelup.spring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/edit/{id}")
    public String getEditPopup(Model model, @PathVariable Long id){
        model.addAttribute("transaction", transactionService.getById(id));
        return "edit.popup";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> editTransaction(@ModelAttribute Transaction transaction){
        Transaction forUpdate = transactionService.getById(transaction.getId());
        forUpdate.setAccountNumber(transaction.getAccountNumber());
        forUpdate.setAmount(transaction.getAmount());
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
