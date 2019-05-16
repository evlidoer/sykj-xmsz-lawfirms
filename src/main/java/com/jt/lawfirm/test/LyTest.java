package com.jt.lawfirm.test;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jt.lawfirm.service.anjian.CaseService;
/**
 * 
 * @author 李阳
 *
 */
public class LyTest {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
//		System.out.println(ac);
		CaseService bean = ac.getBean("caseService",CaseService.class);
//		
//		//List<Map<String, Object>> findCase = bean.findCase(new HashMap<String,Object>());
//		//List<CaseType> findCaseType = bean.findCaseType(1001);
//		Law law = new Law();
//		law.setCaseParties("1");
//		Integer addCaseLaw = bean.addCaseLaw(law);
//		
//		System.out.println(addCaseLaw+"---");
		
		
//		int a = (int)(Math.random()*1000);  
//		System.out.println(a);
		Integer anjianHaoYN = bean.anjianHaoSel("2019（民）第0800号");
		System.out.println(anjianHaoYN);
		 String string = LocalDate.now().toString();
		 System.out.println(string);
		 
		 
		 
	}
}



