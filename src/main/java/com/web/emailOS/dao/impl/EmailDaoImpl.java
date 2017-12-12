/**   
* @Title: UserDaoImpl.java 
* @Package com.dao.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author enqiu.jia  
* @date 2017年9月21日 下午5:56:58 
* @version V1.0   
*/
package com.web.emailOS.dao.impl;

import com.web.emailOS.bean.Email;
import com.web.emailOS.dao.IEmailDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 
* @ClassName: EmailDaoImpl
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiaenqiu 
* @date 2017年9月21日 下午5:56:58 
*  
*/
@Repository
public class EmailDaoImpl extends SqlSessionDaoSupport implements IEmailDao {

	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}


//	public int addUser(User user) {
////		return userMapper.addUser(user);
//		System.out.println("UserDaoImpl.addUser......参数："+user.getUser_name());
//		return this.getSqlSession().insert("com.web.emailOS.mapper.UserMapper.addUser", user);
//	}

	public List<Email> queryAllEmails() {
		System.out.println("EmailDaoImpl.queryAllEmails......");
		return this.getSqlSession().selectList("com.web.emailOS.mapper.EmailMapper.queryAllEmails");
	}

    public Email selectEmailById(int email_id) {
        return this.getSqlSession().selectOne("com.web.emailOS.mapper.EmailMapper.selectEmailById", email_id);
    }

//	public User selectUserById(int user_id) {
//		return this.getSqlSession().selectOne("com.web.emailOS.mapper.UserMapper.selectUserById", user_id);
//	}
//
//	public int updateUser(User user) {
//		return this.getSqlSession().update("com.web.emailOS.mapper.UserMapper.updateUser",user);
//	}
//
//	public int delUserById(int user_id) {
//		return this.getSqlSession().delete("com.web.emailOS.mapper.UserMapper.delUserById",user_id);
//	}

}
