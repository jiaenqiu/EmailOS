package com.web.emailOS.mapper;

import java.util.List;

import com.web.emailOS.bean.User;

public interface UserMapper {
//	@Insert("insert into c_clusters values(#{cluster_id}, #{name}, #{zabbix_group_id}, #{deleted})")
	int insert(User user);
	
	List<User> queryAllUsers();

	User selectUserById(int user_id);

	int updateUser(User user);
}
