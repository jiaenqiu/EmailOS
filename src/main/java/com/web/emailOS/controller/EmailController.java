package com.web.emailOS.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.web.emailOS.bean.Email;
import com.web.emailOS.bean.ResponseBean;
import com.web.emailOS.bean.User;
import com.web.emailOS.service.IEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Resource
    private IEmailService emailService;

    @RequestMapping(value="/queryAllEmails", method= RequestMethod.GET)
    @ResponseBody
    public ResponseBean queryAllEmails() {
        ResponseBean rb = new ResponseBean();
        JSONArray emails = emailService.queryAllEmails();
        System.out.println("****queryAllEmails********"+emails);
        rb.setMsg("查询所有用户");
        rb.setResult(emails.toString());
        rb.setFlag(true);
        return rb;
    }

    @RequestMapping(value="/sendEmail", method=RequestMethod.POST)
    @ResponseBody
    public ResponseBean sendEmail(@RequestParam int email_id) {
        ResponseBean rb = new ResponseBean();
        Email e = emailService.selectEmailById(email_id);
        int flag = emailService.sendEmail(e);
        if(flag == 0) {
            rb.setMsg("向ID为："+e.getEmail_name()+"的用户"+e.getEmail_str()+",成功发送邮件！");
            rb.setResult("0");
            rb.setFlag(true);
        }
        return rb;
    }
}
