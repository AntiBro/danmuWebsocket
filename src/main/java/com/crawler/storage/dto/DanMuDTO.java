package com.crawler.storage.dto;

import java.util.Date;

public class DanMuDTO {
    private String id;

    private Date createtime;

    private String website;

    private String userid;

    private String username;

    private String content;

    private String romeid;

    private String romename;

    private RomeType rometype;

    private String romeurl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public String getRomename() {
        return romename;
    }

    public void setRomename(String romename) {
        this.romename = romename;
    }

  

    public String getRomeurl() {
        return romeurl;
    }

    public void setRomeurl(String romeurl) {
        this.romeurl = romeurl;
    }

	public RomeType getRometype() {
		return rometype;
	}

	public void setRometype(RomeType rometype) {
		this.rometype = rometype;
	}
}