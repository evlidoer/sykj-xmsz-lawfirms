/**
 * 2019年4月30日下午5:20:54
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.util;

import org.apache.shiro.util.ByteSource;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 2019年4月30日下午5:20:54
 * @author 许威
 * @Desc 
 */
public class Encryption {
	//加密算法名称，有：Base64 , MD5 , SHA1等等
	static final String hashAlgorithmName = "MD5";
	static final int hashIterations = 1024; //加密叠加次数
	
	/**
	 * 加密的方法
	 * @param name
	 * @param password
	 * @return
	 */
	public static String Encryption_MD5(String name, String password) {
		//根据用户名获得盐值
		Object salt = ByteSource.Util.bytes(name);
		//得到加密后的结果
		Object result = new SimpleHash(hashAlgorithmName, password, salt, hashIterations);
		System.out.println("加密后："+result);

		return result.toString();
	}
	public static void main(String[] args) {
       Encryption_MD5("admin","f6fdffe48c908deb0f4c3bd36c032e72");
    }
}
