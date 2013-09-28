package com.util.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

/**
 * 系统初始化
 * @author Wymann
 * 2013-9-23 下午04:26:02
 */
public class StartupInitialization extends HttpServlet{

	private static final long serialVersionUID = 8536066575746733421L;
	
	private static final Logger log=Logger.getLogger(StartupInitialization.class);
	
	public void init() throws ServletException{
		if(log.isInfoEnabled()) log.info("正在初始化系统数据");
		
		// 1、加载配置文件数据
		if (log.isInfoEnabled()) log.info("...............1、加载配置文件数据............................. ");
		//ResourceContext.getInstance();
		
		// 2、加载字典表数据
		if (log.isInfoEnabled()) log.info("...............2、加载字典表数据............................... ");
		//DictionaryTranslate.getInstance();
		
		// 3、加载参数表数据
		if (log.isInfoEnabled()) log.info("...............3、加载参数表数据............................... ");
		//DictionaryTranslate.getInstance();
		
	}
	
	public void destroy(){
		
	}
	
}
