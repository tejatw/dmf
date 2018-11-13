package org.intuit.dmf.repository.cassandra;

import org.intuit.dmf.entity.EntityCassandraDao;
import org.intuit.dmf.entity.EntityDao;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.cdi.CassandraRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityCassandraRepository extends CassandraRepository<EntityCassandraDao> {

    @Query("SELECT * FROM dmf.entities WHERE id=?0")
    public List<EntityCassandraDao> getEntityById(String entityId);
}
