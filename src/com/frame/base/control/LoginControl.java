package com.frame.base.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frame.FrameConst;
import com.frame.base.model.User;
import com.frame.base.service.UserService;
import com.frame.core.BaseControl;
import com.frame.core.UserSession;
import com.util.annotation.Login;
import com.util.md5.Security;
import com.util.page.Pager;
import com.util.page.PagerHelper;

/**
 * 用户登录
 * @version 1.0,2013-9-2
 * @author Wymann
 */
@Controller
@Scope("prototype")
@RequestMapping("/base/**")
public class LoginControl extends BaseControl{

	private static final long serialVersionUID = 3504923449793323240L;
	
	@Resource
	private UserService userService;
	
	/**
	 * 跳转登录界面
	 * @return
	 */
	@RequestMapping(value="/base/goLogin")
	public String goLogin(){
		return "frame/manage/login";
	}
	
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping(value="/base/regedit")
	public String regedit(){
		return "frame/regedit";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping(value="/base/login")
	public String login(User user,ModelMap model,HttpServletRequest request){
		
		if(null==user){
			return null;
		}
		else{
			user.setPassword(Security.md5(user.getPassword()));
			boolean flag=userService.check(user);
			if(!flag){
				model.addAttribute("message","用户名或密码错误");
				return null;
			}
			else{
				//Pager page=PagerHelper.getInstance(request);
				UserSession userSession=new UserSession();
				user=userService.getUser(user);
				userSession.setUser(user);
				request.getSession().setAttribute(FrameConst.SESSION_KEY, userSession);	//前台通过key来取值
				return "redirect:/base";
			}
		}
	}
	
	/**
	 * 跳转到列表页面
	 * @return
	 */
	@RequestMapping(value="/base")
	public String list(ModelMap map){
		map.addAttribute("list",userService.findAll());
		return "frame/manage/userList";
	}
	
	/**
	 * 注册成功，跳转到成功页面
	 * @return
	 */
	@Login()
	@RequestMapping(value="/base/save",method=RequestMethod.POST)
	public String save(User user){
		userService.save(user);
		return "redirect:/base";
	}
	
	/**
	 * 用户删除
	 * @param id
	 * @return
	 */
	@Login()
	@RequestMapping(value="/base/delete/{id}")
	public String delete(@PathVariable String id){
		userService.delte(id);
		return "redirect:/base";
	}
	
	/**
	 * 用户修改
	 * @param user
	 * @return
	 */
	@Login()
	@RequestMapping(value="/base/update/{id}")
	public String update(@PathVariable String id,ModelMap model,HttpSession session){
		User user= userService.getById(id);
		model.addAttribute("user", user);
		return "frame/regedit";
	}	
	
	/**
	 * 条件查询
	 * @return
	 */
	@RequestMapping(value="/base/find")
	public String findByCondition(User user){
		return "frame/manage/userList";
	}
}
