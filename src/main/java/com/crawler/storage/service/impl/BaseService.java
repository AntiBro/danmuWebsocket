package com.crawler.storage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Es.entity.DanmuEs;
import com.Es.entity.EntityUtils;
import com.Es.reposity.DanMuReposity;
import com.crawler.storage.dao.DanMuDTOMapper;
import com.crawler.storage.dto.DanMuDTO;
import com.crawler.storage.service.BaseInterface;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


@Service
public class BaseService implements BaseInterface {
	@Autowired
	DanMuDTOMapper danMuDTOMapper;

	@Autowired
	DanMuReposity danMuReposity;
	@Override
	public List<DanMuDTO> getById(String id) {
		DanMuDTO e=new DanMuDTO();
		e.setId(id);
		return danMuDTOMapper.queryById(e);
	}

	@Override
	public void insertRecord(DanMuDTO e) {
		danMuDTOMapper.insertRecord(e);
	}

	@Override
	public int getTotalCount() {
		return danMuDTOMapper.getTotalCount();
	}

	@Override
	public Page<DanMuDTO> queryByPage(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);	
		return danMuDTOMapper.queryAll();
	}

	
	@Override
	public int putToEs() {
		int pagesize=200;
		int count=getTotalCount();
		int batchN=count/pagesize;
		
		for(int i=1;i<2;i++){
			
			List<DanmuEs> eslist=new ArrayList<DanmuEs>();
			PageHelper.startPage(i, pagesize);
			List<DanMuDTO> rs=danMuDTOMapper.queryAll();
			
			for(int j=0;j<rs.size();j++){
				eslist.add(EntityUtils.tansferfromDTO(rs.get(j)));
			}
			danMuReposity.saveAll(eslist);
			
			
		}
		
		return count;
	}

	@Override
	public void deleteAllData() {
		danMuReposity.deleteAll();		
	}

}
