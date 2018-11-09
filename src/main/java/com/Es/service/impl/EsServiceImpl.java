package com.Es.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import com.Es.entity.DanmuEs;
import com.Es.reposity.DanMuReposity;
import com.Es.service.EsService;
@Service
public class EsServiceImpl implements EsService {

	@Autowired
	DanMuReposity danmuReposity;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Override
	public void deleteAll() {
		danmuReposity.deleteAll();
	}

	@Override
	public void AddToEs(int pageno, int pagesize) {

	}

	@Override
	public List<DanmuEs> Search(String keyword) {
		elasticsearchTemplate.getClient().prepareDelete().setIndex("danmu").execute();
		HighlightBuilder highlighter=new HighlightBuilder().field("content").postTags("<my>").preTags("</my>");
		SearchResponse response = elasticsearchTemplate.getClient().prepareSearch("database").setTypes("danmu")
				.highlighter(highlighter)

				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(QueryBuilders.matchQuery("content", keyword)) // 全文检索

			//	.setQuery(QueryBuilders.matchQuery("username", keyword)).setFrom(0).setSize(10).setExplain(true)// 分页

				.addSort(new ScoreSortBuilder().order(SortOrder.DESC))// 排序

				.setTrackScores(true)// 获取得分

				.execute().actionGet();
		// response.

		List<DanmuEs> chunk = new ArrayList<>();

		for (SearchHit searchHit : response.getHits()) {

			if (response.getHits().getHits().length <= 0) {

				return null;

			}

			System.out.println(searchHit.getScore());

			DanmuEs test = new DanmuEs();

			test.setId(searchHit.getId());

			test.setContent((String) searchHit.getSource().get("content"));

			test.setHighlightStr(searchHit.getHighlightFields().get("content").fragments()[0].toString());

			chunk.add(test);

		}

		return chunk;

	}

	@Override
	public Boolean deleteIndex() {
		// TODO Auto-generated method stub
		DeleteIndexResponse dResponse = elasticsearchTemplate.getClient().admin().indices().prepareDelete("database")
                .execute().actionGet();
		return dResponse.isAcknowledged();
	}

}
