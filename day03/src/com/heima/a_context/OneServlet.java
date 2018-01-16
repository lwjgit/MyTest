package com.heima.a_context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  共享数据是基于servletContext对象而言的通过调用setAttribute()和getAttribute()方法
 *  进行设置和获取
 * 
 */
public class OneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			ServletContext context = getServletContext();
			context.setAttribute("name","李白");
			System.out.println("这是共享数据-----------");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}