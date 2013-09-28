package com.util.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse respone, Object handle, Exception ex) {
		// 根据不同错误转向不同页面
		if(ex instanceof NumberFormatException){
			//doSomething
		}
		if(ex instanceof NullPointerException){
			//doSomething
		}
		else if(ex instanceof RuntimeException){
			//doSomething
		}
		else if(ex instanceof Exception){
			//doSomething
		}
		else{
			//doSomething
		}
		request.setAttribute("exception", ex.getMessage());
		//返回error错误页面
		return new ModelAndView("error");
	}

}