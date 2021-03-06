package org.intuit.dmf.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.intuit.dmf.entity.EntityCassandraDao;
import org.intuit.dmf.entity.EntityDao;
import org.intuit.dmf.repository.cassandra.EntityCassandraRepository;
import org.intuit.dmf.repository.elasticsearch.EntityElasticSearchRepository;
import org.intuit.dmf.service.EntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class EntityServiceImpl implements EntityService {

    @Autowired
    EntityElasticSearchRepository entityElasticSearchRepository;

    @Autowired
    EntityCassandraRepository entityCassandraRepository;

    @Autowired
    ObjectMapper objectMapper;

    private static final Logger LOG = LoggerFactory.getLogger(EntityServiceImpl.class);


    @Override
    public EntityDao getEntity(String entityId){

        EntityDao entityDaoForResponse;


        entityDaoForResponse = entityElasticSearchRepository.findOne(entityId);

        if (entityDaoForResponse == null){

            LOG.info("Entity " + entityId + " not found in Cache");

            try {
                List<EntityCassandraDao> cassandraDaoList = entityCassandraRepository.getEntityById(entityId);

                if (cassandraDaoList.size() == 0 || cassandraDaoList == null) {

                    LOG.info("Entity " + entityId + " not found in Central repository also");
                }
                else {

                    LOG.info("Entity " + entityId + " found in Central repository");

                    entityDaoForResponse = new EntityDao();

                    entityDaoForResponse.setId(cassandraDaoList.get(0).getId());
                    entityDaoForResponse.setKey(cassandraDaoList.get(0).getKey());
                    entityDaoForResponse.setValue((Object)cassandraDaoList.get(0).getValue());

                    return entityDaoForResponse;
                }
            }
            catch (Exception e){

                e.printStackTrace();
            }
        }
        else{

            LOG.info("Entity " + entityId + " found in Cache");
            return entityDaoForResponse;
        }

        return null;
    }
}
