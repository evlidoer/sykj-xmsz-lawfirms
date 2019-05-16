/**
 * 2019年5月2日上午10:51:14
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.util;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.jt.lawfirm.bean.system.User;
import com.jt.lawfirm.service.role.RoleService;

/**
 * 2019年5月2日上午10:51:14
 * @author 许威
 * @Desc 
 */
public class ShiroRealm extends AuthorizingRealm{
	/**
	 * 2019年5月2日上午11:05:16
	 * @author 许威
	 * @Desc 
	 * @param arg0
	 * @return
	 * @throws AuthenticationException
	 */
	@Resource(name = "LoginService")
	private com.jt.lawfirm.service.login.LoginService userSer;

	@Resource(name = "RoleService")
	private RoleService roleService;
	/**
	 * @see 认证登录，查询数据库，如果该用户名正确，得到正确的数据，并返回正确的数据
	 * 		AuthenticationInfo的实现类SimpleAuthenticationInfo保存正确的用户信息
	 *    
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.将token转换为UsernamePasswordToken
		UsernamePasswordToken userToken = (UsernamePasswordToken)token;
		//2.获取token中的登录账户
		String userCode = userToken.getUsername();
		//3.查询数据库，是否存在指定的用户名和密码的用户(主键/账户/密码/账户状态/盐)
		User us = null;
		us = userSer.finUserByNamw(userCode);
		//4.1 如果没有查询到，抛出异常
		if( us == null ) {
			throw new UnknownAccountException("账户"+userCode+"不存在！");
		}
		if( us.getUserStatus() == "N"){
			throw new LockedAccountException(us.getUserName()+"被锁定！");
		}
		//4.2 如果查询到了，封装查询结果，
		Object principal = us.getUserName();
		Object credentials = us.getUserPwd();
		String realmName = this.getName();
		//获取盐，用于对密码在加密算法(MD5)的基础上二次加密ֵ
		ByteSource byteSalt = ByteSource.Util.bytes(us.getUserName());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, byteSalt, realmName);
		//5. 返回给调用login(token)方法
		System.out.println("登录验证中:");
		return info;
	}
	/**
	 * @see 授权，在配有缓存的情况下，只加载一次。
	 */
	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName=(String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		try{
			Set<String> findRoleByUserId2 = roleService.findPermissionByUserId(userName);
			for (String string : findRoleByUserId2) {
				System.out.println("当前交色拥有权限:--------"+string);
			}
			authorizationInfo.setStringPermissions(roleService.findPermissionByUserId(userName));
			authorizationInfo.setRoles(roleService.findRoleByUserId(userName));
		}catch(Exception e){
			e.printStackTrace();
		}
		return authorizationInfo;
	}
}
