package cn.itcast.Dao;

import cn.itcast.domain.User;

public interface UserDao {

	void add(User user);

	User find(String account, String password);

	//����ע����û��Ƿ������ݿ��д���
	boolean find(String account);
}