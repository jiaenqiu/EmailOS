package com.web.emailOS.mapper;

import com.web.emailOS.bean.Email;

import java.util.List;

public interface EmailMapper {
//	@Insert("insert into c_clusters values(#{cluster_id}, #{name}, #{zabbix_group_id}, #{deleted})")
//	int insert(User user);
	
	List<Email> queryAllEmails();

//	User selectUserById(int user_id);

//	int updateUser(User user);
}
