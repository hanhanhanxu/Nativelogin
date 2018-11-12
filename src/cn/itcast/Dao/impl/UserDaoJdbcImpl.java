package cn.itcast.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.itcast.Dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.exception.DaoException;
import cn.itcast.utils.JdbcUtils;

public class UserDaoJdbcImpl implements UserDao {

	@Override
	public void add(User user) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into users(account,password,name,age,email) values(?,?,?,?,?)";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setString(1, user.getAccount());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getAge());
			ps.setString(5, user.getEmail());
			
			int num = ps.executeUpdate();
			if(num<1){
				throw new RuntimeException("×¢²áÓÃ»§Ê§°Ü");
			}
			
		}catch (Exception e) {
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
	}

	@Override
	public User find(String account, String password) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from users where account=? and password=?";
			//select * from users where account= 123 and password= 123;
			PreparedStatement ps = conn.prepareStatement(sql);   //Ô¤±àÒëÕâÌõsql
			ps.setString(1, account);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getString("age"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			return null;
		}catch (Exception e) {
			throw new DaoException(e); 
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}

	@Override
	public boolean find(String account) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from users where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
			return false;
		}catch (Exception e) {
			throw new DaoException(e); 
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}

}
