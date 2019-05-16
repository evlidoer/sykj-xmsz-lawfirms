package com.jt.lawfirm.service.administration;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.administration.Signinrecor;
import com.jt.lawfirm.bean.administration.dtd.MySigninrecor;

public interface SigninrecorService {

	List<Signinrecor> findSigninrecorAll(Map<String, Object> map);

	List<MySigninrecor> findMySigninrecorAll();

}
