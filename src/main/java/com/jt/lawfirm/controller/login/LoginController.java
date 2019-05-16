/**
 * 2019年5月2日上午10:54:16
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.controller.login;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.system.Log;
import com.jt.lawfirm.exception.InHttpServletIsEmptyException;
import com.jt.lawfirm.service.systemlog.ISystemlogService;

/**
 * 2019年5月2日上午10:54:16
 * @author 许威
 * @Desc 
 */
@Controller
public class LoginController{

	@Resource(name="systemlogservice")
	private ISystemlogService systemlogService;

	@RequestMapping("goto/index")
	public String LoginidneController() {
		return"shouye/index";
	}
	@RequestMapping(value = "loginRequest",method = RequestMethod.POST)
	public @ResponseBody Map<Object, String> logon(@RequestParam("name")String name,@RequestParam("pwd")String pwd,HttpServletRequest request) throws InHttpServletIsEmptyException{
		Map<Object, String> map = new HashMap<Object, String>();
		//创建Subject实例对象
		Subject currentUser = SecurityUtils.getSubject();
		Log log = new Log();
		UsernamePasswordToken token = new UsernamePasswordToken(name,pwd);
		try {
			currentUser.login(token);
			String username = token.getUsername();
			request.getSession(true).setAttribute("userName",username);
			Map<String, Object> selectuserid = systemlogService.selectuserid(name);
			Integer id = Integer.valueOf(selectuserid.get("id").toString());
			String systemlogIp = null ;
			try {
				systemlogIp = InetAddress.getLocalHost().toString();
				String str= systemlogIp.substring(systemlogIp.indexOf("/")+1);
				log.setSystemLogIp(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
			log.setSystemLogLogexplain("登陆成功");
			log.setSystemTypeId("用户登陆");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			log.setSystemLogRecordTime(df.format(new Date()));
			log.setUserId(id);
			systemlogService.insertlog(log);
			map.put(200, "index");
			System.out.println("登录验证通过,返回map");
			return map;
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("密码错误!");
			map.put(404, "404");
			return map;
		}
		//	}
		//		//已经登陆过了的
		//		map.put(303, "index");
		//		return map;
	}
}
