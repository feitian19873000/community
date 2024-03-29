package com.util.web;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 读取资源文件
 * @author Wymann
 * 2013-9-24 上午11:29:54
 */
public class ResourceContext {
	
	//private static final Log log=LogFactory.getLog(ResourceContext.class);
	
	private Map<String,String> globalMap=new HashMap<String, String>();
	
	private static ResourceContext resourceContext=null;
	
	private static boolean reload=false;
	
	public ResourceContext(){
		//if(log.isErrorEnabled()) log.info("正在加载properties配置文件...");
		List<String> propList=new ArrayList<String>();
		//文件路径
		propList.add("cfg/resource.properties");
		//if(log.isErrorEnabled()) log.info("加载的配置文件有"+propList);
		
		for(String one: propList){
			loadByStream(one);
		}
	}
	
	/**
	 * 初始化
	 * @return
	 */
	public static ResourceContext getInstance(){
		if(resourceContext!=null){
			if(reload){
				//if(log.isErrorEnabled()) log.info("重新加载properties配置文件...");
				resourceContext=new ResourceContext();
			}
		}
		if(resourceContext==null){
			//if(log.isErrorEnabled()) log.info("第一次加载properties配置文件...");
			resourceContext=new ResourceContext();
		}
		return resourceContext;
	}
	
	public String getValue(String key){
		if(StringUtils.isNotEmpty(key)){
			if(globalMap.containsKey(key)){
				return globalMap.get(key);
			}
			return null;
		}
		return null;
	}
	/**
	 * 加载指定文件，通过ResourceBundle方法实现
	 * 以键值对方式存储到globalMap中
	 * @param file
	 */
	@SuppressWarnings("unused")
	private void load(String file) {
		ResourceBundle rb = ResourceBundle.getBundle(file);
		String key;
		Enumeration<String> e = rb.getKeys();
		while(e.hasMoreElements()){
			key = (String) e.nextElement();
			globalMap.put(key, rb.getObject(key).toString());
		}
	}
	
	/**
	 * 加载指定的文件，通过Properties方法实现
	 * 以键值对方式存储到globalMap中
	 * @param one
	 */
	private void loadByStream(String fileName) {
		Properties p=new Properties();
		String key="";
		
		try {
			InputStreamReader in=new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fileName),"UTF-8");
			p.load(in);
			Enumeration<Object> e=p.keys();
			while(e.hasMoreElements()){
				key=(String)e.nextElement();
				globalMap.put(key, p.getProperty(key));
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void printAll(){
		System.out.println(globalMap);
	}
	
	public static void main(String[] args){
		
		ResourceContext.getInstance().printAll();
		
	}
}
