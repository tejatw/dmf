package org.intuit.dmf.service;

import org.intuit.dmf.entity.EntityDao;
import org.springframework.stereotype.Service;

@Service
public interface EntityService {

    public EntityDao getEntity(String entityId);
}
