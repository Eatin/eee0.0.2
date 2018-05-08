package com.eee.mybatis.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eee.mybatis.entity.User;
import com.eee.mybatis.impl.UserServiceImpl;
import com.eee.mybatis.service.UserService;
import com.eee.mybatis.utils.JsonUtil;
/**
 * Servlet implementation class DefaultUserListHandler
 */
public class DefaultUserListHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DefaultUserListHandler() {    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		UserService userService=new UserServiceImpl();
	    PrintWriter out = response.getWriter();
	    String method=request.getParameter("method");
	    String returnString="";
	    //方法入口
	    if(method.equals("users")){
	    	returnString=new  JsonUtil<User>().getJsonByListObj(userService.getUsers());
	    }else if(method.equals("user")){
	    	String id=request.getParameter("id");
	    	returnString=new  JsonUtil<User>().getJsonByEntity(userService.getUser(id));
	    }else if(method.equals("delete")){
	    	String id=request.getParameter("id");
	    	Map<String,Object> map=new HashMap<String, Object>();
	    	map.put("event", method);
	    	map.put("param", id);
	    	returnString=new  JsonUtil<User>().getJsonByObject(map);
	    }else if(method.equals("update")){
	    	String id=request.getParameter("id");
	    	String username=request.getParameter("username");
	    	String password=request.getParameter("password");
	    	Map<String,Object> map=new HashMap<String, Object>();
	    	int count=userService.update(username, password,id);
	    	map.put("status",count==0?false:true);
	    	map.put("event", method);
	    	map.put("param", id);
	    	returnString=new  JsonUtil<User>().getJsonByObject(map);
	    }else if(method.equals("paginate")){
	    	int limit=Integer.valueOf(request.getParameter("pageSize"));
	    	int offset=Integer.valueOf(request.getParameter("offset"));
	    	returnString=new  JsonUtil<User>().getJsonByListObj(userService.getUsersByPage(offset, limit));
	    }
	   //输出JSON数据
	    out.print(returnString);
	    out.flush();
		out.close();
	}

}
