package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
/*

    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account){
        //ModelAndView mv = new ModelAndView();
        accountService.save(account);
        //mv.setViewName("/account/findAll");
        return "保存成功";
    }
*/

    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public ModelAndView save(Account account){
        ModelAndView mv = new ModelAndView();
        accountService.save(account);
        mv.setViewName("forward:/account/findAll");
        return mv;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(String name){
        List<Account> accountList = accountService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("accountList",accountList);
        mv.setViewName("accountList");
        return mv;
    }

}
