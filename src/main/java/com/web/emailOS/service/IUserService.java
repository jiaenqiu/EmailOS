/**   
* @Title: UserService.java 
* @Package com.xaxb.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author enqiu.jia  
* @date 2017年9月21日 下午5:59:02 
* @version V1.0   
*/
package com.web.emailOS.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.web.emailOS.bean.User;

/** 
* @ClassName: UserService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiaenqiu 
* @date 2017年9月21日 下午5:59:02 
*  
*/
public interface IUserService {
	
	int addUser(User user);

	JSONArray queryAllUsers();

	User selectUserById(int user_id);

	int updateUser(User user);

	int delUserById(int user_id);
}
