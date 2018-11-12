package org.intuit.dmf.repository.cassandra;

import org.intuit.dmf.entity.EntityDao;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.cdi.CassandraRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityCassandraRepository extends CassandraRepository<EntityDao> {
}
