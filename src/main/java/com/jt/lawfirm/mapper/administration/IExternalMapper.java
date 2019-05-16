package com.jt.lawfirm.mapper.administration;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.administration.External;

public interface IExternalMapper extends BaseMapper<External>{

	List<External> selExternaAll(Map<String, Object> map);

	void deleteExternalById(int id);


}
