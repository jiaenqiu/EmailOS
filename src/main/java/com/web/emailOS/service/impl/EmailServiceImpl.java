/**   
* @Title: UserServiceImpl.java 
* @Package com.xaxb.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author enqiu.jia  
* @date 2017年9月21日 下午5:59:20 
* @version V1.0   
*/
package com.web.emailOS.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.web.emailOS.bean.Email;
import com.web.emailOS.bean.User;
import com.web.emailOS.dao.IEmailDao;
import com.web.emailOS.dao.IUserDao;
import com.web.emailOS.service.IEmailService;
import com.web.emailOS.service.IUserService;
import com.web.emailOS.util.MailUtil;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

/** 
* @ClassName: EmailServiceImpl
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiaenqiu 
* @date 2017年9月21日 下午5:59:20 
*  
*/
@Transactional
@Service("emailService")
public class EmailServiceImpl implements IEmailService {
	
	@Resource
	private IEmailDao emailDao;

	public JSONArray queryAllEmails() {
		JSONArray es = new JSONArray();
		List<Email> emailsList = emailDao.queryAllEmails();
		for(Email e:emailsList) {
			JSONObject a = new JSONObject();
			a.put("email_id", e.getEmail_id());
			a.put("email_rank", e.getEmail_rank());
			a.put("email_name", e.getEmail_name());
			a.put("email_phone", e.getEmail_phone());
			a.put("email_str", e.getEmail_str());
			es.add(a);
		}
		return es;
	}

	public Email selectEmailById(int email_id) {
		return emailDao.selectEmailById(email_id);
	}

	public int sendEmail(Email email) {
		MailUtil.createMailSender();
		try {
			MailUtil.sendHtmlMail(email.getEmail_str(),"紧急通知","恭喜您注册成功，您的用户名：" + email.getEmail_name() + ",您的联系方式：" + email.getEmail_phone() + "，请妥善保管，如有问题请联系网站客服!");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
