package com.Es.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.Mapping;

@Document(indexName = "database",type = "danmu", shards = 1,replicas = 0, refreshInterval = "-1")
@Mapping(mappingPath = "esmapping/danmusearch_mapping.json")
public class DanmuEs {
	 @Id 
	 private String id;

	 private String username;
	 
	
	 private String content;

	 private String romeid;
	 

	 private String romeurl;
	 
	 @Field 
	 private String host;

	 
	private String HighlightStr;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRomeid() {
		return romeid;
	}

	public void setRomeid(String romeid) {
		this.romeid = romeid;
	}

	public String getRomeurl() {
		return romeurl;
	}

	public void setRomeurl(String romeurl) {
		this.romeurl = romeurl;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getHighlightStr() {
		return HighlightStr;
	}

	public void setHighlightStr(String highlightStr) {
		HighlightStr = highlightStr;
	}
	 
	 
	 
}
