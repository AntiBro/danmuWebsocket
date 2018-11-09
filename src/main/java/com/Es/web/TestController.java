package com.Es.web;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Es.entity.DanmuEs;
import com.Es.reposity.DanMuReposity;
import com.Es.service.EsService;
import com.crawler.storage.service.BaseInterface;

@RestController
public class TestController {
	@Autowired
	DanMuReposity danmuReposity;

	@Autowired
	BaseInterface douyuservice;
	
	@Autowired
	EsService esService;

	@RequestMapping("/putDemo")
	public String testEnum() {
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		DanmuEs ne = new DanmuEs();
		ne.setId(id);
		ne.setHost("www.douyu.com");
		ne.setRomeid("mm我卡洛斯的减肥了");
		ne.setRomeurl("www.douyu.com/asd");
		ne.setUsername("b吧班");
		ne.setContent("豪砸偶");
		danmuReposity.save(ne);
		// danmuReposity.
		return id.length() + "/" + id;

	}

	@RequestMapping("/putEs")
	public int putEsFromMysql() {
		// danmuReposity.s
		return douyuservice.putToEs();
	}

	@RequestMapping("/deleteEs")
	public int deleteEs() {
		// danmuReposity.s
		douyuservice.deleteAllData();
		return 1;
	}
	@RequestMapping("/search")
	public void searchBycontent() {
		String queryString = "垃圾";// 搜索关键字
		QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
		//builder.
		Iterable<DanmuEs> searchResult = danmuReposity.search(builder);
		Iterator<DanmuEs> iterator = searchResult.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getContent());
		}
	}
	
	@RequestMapping("/searchBytmpl")
	public List<DanmuEs> searchtmpl(String key){
		return esService.Search(key);
	}
	
	@RequestMapping("/deleIndex")
	public Boolean deleIndex(){
		return esService.deleteIndex();
	}
	                      

}
