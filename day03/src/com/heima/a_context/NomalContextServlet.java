package com.heima.a_context;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  
 * 
 */
public class NomalContextServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//创建servletContext对象
		ServletContext context = getServletContext();
		//1.获取文件在服务器的真实路径
		String real = context.getRealPath("1.txt");
		System.out.println(real);
		//2.以流的方式获取文件
		InputStream stream = context.getResourceAsStream("1.txt");
		System.out.println(stream);
		//3.获取全局初始化参数
		String value = context.getInitParameter("encoding");
		System.out.println(value);
		
		
		//4.获取文件的类型(MIME类型)
		String type = context.getMimeType("index.html");
		System.out.println(type);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response); 
	}

}