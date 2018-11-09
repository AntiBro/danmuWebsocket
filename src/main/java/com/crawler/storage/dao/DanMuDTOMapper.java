package com.crawler.storage.dao;

import java.util.List;

import com.crawler.storage.dto.DanMuDTO;
import com.github.pagehelper.Page;


public interface DanMuDTOMapper {
    int insertRecord(DanMuDTO record);

    int insertSelective(DanMuDTO record);
    
    public List<DanMuDTO> queryById(DanMuDTO record);  
    
    Integer getTotalCount();
    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<DanMuDTO> queryAll();
}