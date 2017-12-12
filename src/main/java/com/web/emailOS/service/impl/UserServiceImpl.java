/**   
* @Title: UserServiceImpl.java 
* @Package com.xaxb.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author enqiu.jia  
* @date 2017年9月21日 下午5:59:20 
* @version V1.0   
*/
package com.web.emailOS.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.web.emailOS.dao.IUserDao;
import com.web.emailOS.bean.User;
import com.web.emailOS.service.IUserService;

/** 
* @ClassName: UserServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiaenqiu 
* @date 2017年9月21日 下午5:59:20 
*  
*/
@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private IUserDao userDao;

	public int addUser(User user) {
		if (user.getUser_pwd() == "" || user.getUser_pwd() == null) {
			user.setUser_pwd(DigestUtils.md5DigestAsHex("123123".getBytes()));//md5加密
		}
		return userDao.addUser(user);
	}


	public JSONArray queryAllUsers() {
		JSONArray us = new JSONArray();
		List<User> userList = userDao.queryAllUsers();
		for(User u:userList) {
			JSONObject a = new JSONObject();
			a.put("user_id", u.getUser_id());
			a.put("user_name", u.getUser_name());
			a.put("user_phone", u.getUser_phone());
			a.put("user_id_card", u.getUser_id_card());
			a.put("user_content", u.getUser_content());
			us.add(a);
		}
		return us;
	}

	public User selectUserById(int user_id) {
		return userDao.selectUserById(user_id);
	}

	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	public int delUserById(int user_id) {
		return userDao.delUserById(user_id);
	}

}
