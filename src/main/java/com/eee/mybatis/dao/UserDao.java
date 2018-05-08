package com.eee.mybatis.dao;

import java.util.ArrayList;
import java.util.List;

import com.eee.mybatis.service.UserService;
import org.apache.ibatis.session.SqlSession;
import com.eee.mybatis.entity.User;

public class UserDao {
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@SuppressWarnings("static-access")
	public void add(String id,String username,String password) {
		SqlSession session =GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.getMapper(UserService.class).add(id,username,password);
			session.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@SuppressWarnings("static-access")
	public void delete(String id) {
		SqlSession session=GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.getMapper(UserService.class).delete(id);
			session.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	/**
	 * 修改用户名和密码
	 * @param user
	 * @param id
	 * @return
	 */
	@SuppressWarnings("static-access")
	public int update(String username,String password,String id) {
		int count=0;
		SqlSession session=GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
//			Map<String, Object> map=new HashMap<String, Object>();  
//			map.put("username", user.getUsername());  
//			map.put("password", user.getPassword()); 
//			session.update("updateUser", map);
			count=session.getMapper(UserService.class).update(username,password,id);
			session.commit();//提交事务
		} catch (Exception e) {
			count=0;
			e.printStackTrace();
		}finally{
			session.close();
		}
		return count;
	}

	/**
	 * 查看用户信息
	 * @param id
	 * @return
	 */
	@SuppressWarnings("static-access")
	public User getUser(String id) {
		SqlSession session =GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		User user=null;
		try {
			//xml方式查询
			//user=session.selectOne("user");
			//注解方式查询
			user=session.getMapper(UserService.class).getUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return user;
	}
	/**
	 * 获取用户列表==默认
	 * @return
	 */
	@SuppressWarnings("static-access")
	public List<User> getUsers() {
		List<User> users=new ArrayList<User>();
		SqlSession session =GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			//xml方式查询
			//users=session.selectList("users");
			//注解方式查询
			users=session.getMapper(UserService.class).getUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return users;
	}

	/**
	 * 获取用户列表==分页
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("static-access")
	public List<User> getUsers(int offset, int pageSize) {
		List<User> users=new ArrayList<User>();
		SqlSession session =GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			//users=session.selectList("user_list_page", new User(),new  RowBounds(offset,pageSize));//未测试过
			//注解方式查询
			users=session.getMapper(UserService.class).getUsersByPage(offset, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return users;
	}

}
