package com.bank.controller;

import com.bank.data.AccountData;
import com.bank.data.BankDatabase;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.net.http.HttpRequest;

@RequestMapping("operations")
@RestController
public class BankController {
    BankDatabase bd = new BankDatabase();

    @PostMapping("create/{iban}")
    public String createAccount(@PathVariable("iban") String iban, @RequestBody AccountData newAccount) {
        String response = bd.addAccount(iban, newAccount);
        return response;
    }

    @GetMapping("addfunds")
    public String addFunds(@RequestParam("iban") String iban, @RequestParam("sum") BigDecimal sum) {
        return bd.deposit(iban, sum);
    }

    @GetMapping("withdraw/{iban}/{sum}")
    public String withdraw(@PathVariable("iban") String iban, @PathVariable("sum") BigDecimal sum) {
        return bd.withdraw(iban, sum);
    }

    @GetMapping("balance/{iban}")
    public String balance(@PathVariable("iban") String iban) {
        return bd.balance(iban);
    }

    @GetMapping("transfer")
    public String transfer(@RequestParam("acc1") String acc1, @RequestParam("acc2") String acc2, @RequestParam("sum") BigDecimal sum) {


        return bd.transfer(acc1, acc2, sum);
    }


}

