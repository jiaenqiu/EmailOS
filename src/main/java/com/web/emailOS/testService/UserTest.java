package com.web.emailOS.testService;

import com.web.emailOS.bean.User;
import com.web.emailOS.service.impl.UserServiceImpl;

import java.util.List;

public class UserTest {

	public static void main(String[] args) {
		UserServiceImpl us = new UserServiceImpl();
		User user = new User();
		user.setUser_name("jiaeq");
		user.setUser_phone("18332537474");
		user.setUser_id_card("130533199009293213");
		user.setUser_content("省通知……");
//		us.addUser(user);
		//List<User> users = us.queryAllUsers();
		//System.out.println(users);
	}

}
