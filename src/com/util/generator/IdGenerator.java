package com.util.generator;

import java.util.Date;

import com.util.datetime.DateTimeUtils;

/**
 * 主键生成器
 * @author Wymann
 * 2013-9-23 下午04:27:50
 */
public class IdGenerator {
	
	private static IdGenerator idGenerator;
	private static final String DEFAULT_PK_VALUE = "9999999999999999999999";
	private static final String PK_FILL_CHARACTER = "0";
	
	private static Integer increaseValue = 1;
	
	private IdGenerator(){}
	
	public static IdGenerator getInstance(){
		
		if(idGenerator == null){
			idGenerator = new IdGenerator();
			System.out.println("正在初始化主键生成器。");
		}
		
		
		return idGenerator;
	}
	
	/**
	 * 生成主键
	 * @return
	 */
	public synchronized String getId(){
		String res = DEFAULT_PK_VALUE;
		
		String curDateTime = DateTimeUtils.formatDate(new Date(), DateTimeUtils.PATTERN_DATETIME_COMPACT);
		
		if(increaseValue >= Integer.MAX_VALUE){
			increaseValue = 1;
		}
		
		String fullC = fillCharacter(String.valueOf(increaseValue), PK_FILL_CHARACTER, 5);
		res = curDateTime + fullC;
		increaseValue++;
		System.out.println("当前生成的主键是："+res);
		return res;
	}
	
	/**
	 * 填充字符
	 * @param oriC  原始字符
	 * @param fullC 填充字符
	 * @param size  总长度
	 * @return
	 */
	private String fillCharacter(String oriC,String fillC,int size){
		String res = "";
		if(oriC != null){
			int oriCLen = oriC.length();
			for(int i = size - oriCLen;i>0;i--){
				res += fillC;
			}
		}
		res += oriC;
		return res;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			IdGenerator.getInstance().getId();
		}
	}
	
}
