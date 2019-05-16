package com.jt.lawfirm.service.statistics.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.mapper.statistics.IComprehensiveMapper;
import com.jt.lawfirm.service.statistics.IStatisticalCenterService;
import com.jt.lawfirm.util.DateTime;

@Service("centerService")
public class StatisticalCenterServiceImpl implements IStatisticalCenterService {
	
	@Resource(name="IComprehensiveMapper")
	private IComprehensiveMapper siveMapper;

	@Override
	public List<Map<String, String>> findSiveToMap(Map<String, String> map) {
		Map<String, String> mapT = DateTime.exchangeDate(map, "startTime", "endTime");
		String[] arr = mapT.get("endTime").split("-");
		int i = Integer.parseInt(arr[1]);
		if(++i < 10) {
			mapT.put("endTime", arr[0] + "-0" + i);
		}else {
			mapT.put("endTime", arr[0] + "-" + i);
		}
		return siveMapper.selectSiveToMap(mapT);
	}

	@Override
	public List<Map<String, String>> findPersonalBusiness(Map<String, String> map) {
		Map<String, String> mapT = DateTime.exchangeDate(map, "startTime", "endTime");
		String[] arr = mapT.get("endTime").split("-");
		int i = Integer.parseInt(arr[1]);
		if(++i < 10) {
			mapT.put("endTime", arr[0] + "-0" + i);
		}else {
			mapT.put("endTime", arr[0] + "-" + i);
		}
		return siveMapper.selectPersonalBusiness(mapT);
	}

	@Override
	public List<Map<String, String>> findSiveToMapPlus(Map<String, String> map) {
		Map<String, String> mapT = DateTime.exchangeDate(map, "startTime", "endTime");
		String[] arr = mapT.get("endTime").split("-");
		int i = Integer.parseInt(arr[1]);
		if(++i < 10) {
			mapT.put("endTime", arr[0] + "-0" + i);
		}else {
			mapT.put("endTime", arr[0] + "-" + i);
		}
		return siveMapper.selectSiveToMapPlus(mapT);
	}

	@Override
	public List<Map<String, String>> findReceiveStatistical(Map<String, String> map) {
		Map<String, String> mapT = DateTime.exchangeDate(map, "startTime", "endTime");
		String[] arr = mapT.get("endTime").split("-");
		int i = Integer.parseInt(arr[1]);
		if(++i < 10) {
			mapT.put("endTime", arr[0] + "-0" + i);
		}else {
			mapT.put("endTime", arr[0] + "-" + i);
		}
		return siveMapper.selectReceiveStatistical(mapT);
	}

	@Override
	public List<Map<String, String>> findClassInvoice(Map<String, String> map) {
		Map<String, String> mapT = DateTime.exchangeDate(map, "startTime", "endTime");
		String[] arr = mapT.get("endTime").split("-");
		int i = Integer.parseInt(arr[1]);
		if(++i < 10) {
			mapT.put("endTime", arr[0] + "-0" + i);
		}else {
			mapT.put("endTime", arr[0] + "-" + i);
		}
		return siveMapper.selectClassInvoice(mapT);
	}

}
