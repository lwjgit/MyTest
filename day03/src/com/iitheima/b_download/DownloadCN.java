package com.iitheima.b_download;

import java.io.IOException;
import java.io.InputStream;

import javax.activation.MimeType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *  
 * 
 */
public class DownloadCN extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = request.getParameter("name");
		ServletContext context = getServletContext();
		String mineType = context.getMimeType(fileName);
		response.setContentType(mineType);
		String agent = request.getHeader("user-Agent");
		String fn = "大海.jpg";
		
		System.out.println(fn);
		response.setHeader("content-Disposition", "attachment;filename="+fn);
		InputStream in = context.getResourceAsStream("/download/"+fileName);
		ServletOutputStream out = response.getOutputStream();
		byte[] bytes = new byte[1024];
		int len = 0;
		while((len=in.read(bytes)) != -1){
			out.write(bytes, 0, len);
		}
		out.close();
		in.close();
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}