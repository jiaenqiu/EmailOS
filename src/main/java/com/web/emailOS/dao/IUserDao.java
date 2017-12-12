/**   
* @Title: UserDao.java 
* @Package com.xaxb.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author enqiu.jia  
* @date 2017年9月21日 下午5:52:05 
* @version V1.0   
*/
package com.web.emailOS.dao;

import java.util.List;
import com.web.emailOS.bean.User;

/** 
* @ClassName: UserDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiaenqiu 
* @date 2017年9月21日 下午5:52:05 
*  
*/
public interface IUserDao {
	int addUser(User user);
	
	List<User> queryAllUsers();

	User selectUserById(int user_id);

	int updateUser(User user);

	int delUserById(int user_id);
}
