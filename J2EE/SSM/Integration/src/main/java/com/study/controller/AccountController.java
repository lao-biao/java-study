package com.study.controller;

import com.study.domain.Account;
import com.study.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 周
 * @title AccountController
 * @date 2020/6/30 10:28
 * @description
 */
@Controller("accountController")
@RequestMapping("/account")
public class AccountController {

    @Autowired
    @Qualifier("accountService")
    private AccountService as;

    /**
     * 保存
     *
     * @param account
     * @return
     */
    @PostMapping(value = "/save", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account) {
        as.save(account);
        return "保存账户信息成功";
    }

    /**
     * 查询
     *
     * @return
     */
    @GetMapping(value = "/findAll", produces = "text/html;charset=UTF-8")
    public ModelAndView findAll() {
        List<Account> accountList = as.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account");
        modelAndView.addObject("accountList", accountList);
        return modelAndView;
    }


}
