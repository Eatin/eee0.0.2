package com.eee.mybatis.service;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.eee.mybatis.entity.User;

public interface UserService {
	//注解
	@Insert(" insert into users (id,username,password) values (#{id},#{username},#{password})")
	void add(@Param("id") String id, @Param("username") String username, @Param("password") String password);
	
	@Delete(" delete  from users where id=#{id}")
	void delete(String id);
	
	@Update(" update users set username=#{username},password=#{password} where id=#{id}")
	int update(@Param("username") String username, @Param("password") String password, @Param("id") String id);
	
	@Select(" select * from users where id=#{id}")
	User getUser(String id);
	
	@Select(" select * from users order by id asc ")
	List<User> getUsers();
	
	@Select(" select * from users order by id asc limit #{pageSize} offset #{offset} ")
	List<User> getUsersByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);//offset=pageSize*(page-1)

}
