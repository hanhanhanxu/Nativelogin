package cn.itcast.Dao;

import cn.itcast.domain.User;

public interface UserDao {

	void add(User user);

	User find(String account, String password);

	//查找注册的用户是否在数据库中存在
	boolean find(String account);
}