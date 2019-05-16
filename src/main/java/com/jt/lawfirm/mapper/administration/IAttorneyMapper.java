package com.jt.lawfirm.mapper.administration;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.administration.Attorney;

public interface IAttorneyMapper extends BaseMapper<Attorney>{

	List<Attorney> selAttorneyAll(Map<String, Object> map);

	List<Attorney> selAttorneyByID(Integer id);

}
