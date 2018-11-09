package com.Es.entity;

import com.crawler.storage.dto.DanMuDTO;

public class EntityUtils {
	
	/**
	 * 转化成Es的entity类
	 * @param e
	 * @return
	 */
	public static DanmuEs tansferfromDTO(DanMuDTO e){
		DanmuEs newe=new DanmuEs();
		newe.setContent(e.getContent());
		newe.setHost(e.getWebsite());
		newe.setId(e.getId());
		newe.setRomeurl(e.getRomeurl());
		newe.setUsername(e.getUsername());
		newe.setRomeid(e.getRomeid());
		return newe;
	}

}
