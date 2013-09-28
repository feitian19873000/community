package com.util.handler;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.frame.FrameConst;
import com.frame.core.UserSession;
import com.util.annotation.Login;

/**
 * pring MVV拦截用户登录
 * @author WyMann
 *
 */
public class LoginAnnotationInterceptor extends HandlerInterceptorAdapter  {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse respone,Object obj) throws Exception {
		HandlerMethod handle=(HandlerMethod)obj;
		Login login=handle.getMethodAnnotation(Login.class);
		//没有声明登录，放行
		if(null==login){
			return true;
		}
		HttpSession session=request.getSession();
		UserSession userSession=(UserSession)session.getAttribute(FrameConst.SESSION_KEY);
		//需要登录
		if(null==userSession || null==userSession.getUser()){
			//传统页面登录
			if(login.value()==ResultTypeEnum.page){
				request.setAttribute("globalMsg", "请先登录!");
				request.getRequestDispatcher("/base/goLogin").forward(request, respone);
			}
			//ajax页面登录
			else if(login.value()==ResultTypeEnum.json){
	            respone.setCharacterEncoding("utf-8");
	            respone.setContentType("text/html;charset=UTF-8");
	            OutputStream out = respone.getOutputStream();
	            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out,"utf-8"));
	            //返回json格式的提示
	            pw.println("{\"result\":false,\"code\":11,\"globalMsg\":\"您未登录,请先登录\"}");
	            pw.flush();
	            pw.close();
			}
			return false;
		}
		return true;
	}

}
