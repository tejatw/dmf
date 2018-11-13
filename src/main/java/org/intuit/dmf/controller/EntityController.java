package org.intuit.dmf.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.intuit.dmf.entity.EntityDao;
import org.intuit.dmf.repository.elasticsearch.EntityElasticSearchRepository;
import org.intuit.dmf.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/entity")
@Api(value = "Get an entity", description = "GET an entity")
@ResponseBody
public class EntityController {

    @Autowired
    EntityService entityService;

    @ApiOperation(value = "Get an entity by Id")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getEntityDetails(HttpServletRequest request, @RequestParam("entityId") String entityId){

        try {

            EntityDao entityDao = entityService.getEntity(entityId);


            if (entityDao != null) {

                return ResponseEntity.status(HttpStatus.OK).body(entityDao.getValue());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Entity not found for Id " + entityId + "\"}");

        }
        catch(Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"Internal Server Error\"}");
        }
    }


}
