package com.crawler.storage.service;

import java.util.List;

import com.crawler.storage.dto.DanMuDTO;
import com.github.pagehelper.Page;



public interface BaseInterface {
	List<DanMuDTO> getById(String id);
	
	void insertRecord(DanMuDTO e);
	/**
	 * 获取总的记录数
	 * @return
	 */
	int getTotalCount();
	/**
	 * 分页查询结果
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page<DanMuDTO> queryByPage(int pageNo,int pageSize);
	/**
	 * Es添加索引数据
	 * @return
	 */
	int putToEs();
	
	void deleteAllData();
	
}
