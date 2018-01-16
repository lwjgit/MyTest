package com.iitheima.b_download;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *  从服务器下载文件
 * 
 */
public class DownLoadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		 固定套路:设置两个头和一个流
//			response.setContentType(MIME类型);
//			response.setHeader("content-disposition", "attachment;filename"+文件名称);
		// 1. 获取需要下载文件的名称  
		String fileName = request.getParameter("name");
		// 2. 设置响应正文类型(MIME类型)
		ServletContext context = getServletContext();
		String mimeType = context.getMimeType(fileName);
		response.setContentType(mimeType);
	
		// 3. 设置文件下载的头
		response.setHeader("content-Disposition", "attachment;filename="+fileName);
		// 4. 设置输出流(字节流)
	    //  4.1 获取文件输入流对象
		InputStream in = context.getResourceAsStream("/download/"+fileName);
		//  4.2 获取输出流
		ServletOutputStream out = response.getOutputStream();
		//  4.3 IO流拷贝
		byte[] bytes = new byte[1024];
		int len = 0;
		while((len=in.read(bytes)) != -1){
			out.write(bytes, 0, len);
		}
			//  4.4 释放资源
		out.close();
		in.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}