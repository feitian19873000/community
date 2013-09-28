package com.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.util.handler.ResultTypeEnum;

/**
 * 建立annotation, 用于标注需要登录检查的spring-mvc方法
 * @author Wymann
 * 2013-9-23 下午04:28:22
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
	//定义一个枚举方法，默认值为page
	ResultTypeEnum value() default ResultTypeEnum.page;
}
