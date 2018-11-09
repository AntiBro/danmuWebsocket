package com.Es.service;

import java.util.List;

import com.Es.entity.DanmuEs;

public interface EsService {
	
	void deleteAll();
	
	void AddToEs(int pageno,int pagesize);
	
	List<DanmuEs> Search(String keyword);
	
	Boolean deleteIndex();

}
