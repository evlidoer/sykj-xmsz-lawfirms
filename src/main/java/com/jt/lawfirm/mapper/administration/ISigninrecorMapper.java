package com.jt.lawfirm.mapper.administration;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.administration.Signinrecor;
import com.jt.lawfirm.bean.administration.dtd.MySigninrecor;

public interface ISigninrecorMapper {

	List<Signinrecor> selSigninrecorAll(Map<String, Object> map);

	List<MySigninrecor> selMySigninrecorAll();

}
