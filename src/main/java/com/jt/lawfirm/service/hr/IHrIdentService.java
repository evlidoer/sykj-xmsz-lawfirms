package com.jt.lawfirm.service.hr;
/*
 * 
 * @author代国繁
 * */
import java.util.List;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.hr.HrIdent;
import com.jt.lawfirm.bean.hr.myhrbean.Myempident;

public interface IHrIdentService {
List<HrIdent> selectaident(PageBean pageBean,Myempident myempident);
boolean insertident(HrIdent hrIdent);
}
