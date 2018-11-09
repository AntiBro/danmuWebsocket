package com.Es.reposity;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.Es.entity.DanmuEs;

public interface DanMuReposity extends ElasticsearchRepository<DanmuEs, String> {

}
