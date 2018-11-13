package org.intuit.dmf.repository.elasticsearch;

import org.intuit.dmf.entity.EntityDao;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityElasticSearchRepository  extends ElasticsearchRepository<EntityDao, String> {
}
