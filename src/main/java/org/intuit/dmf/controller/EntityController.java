package org.intuit.dmf.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/entity")
@Api(value = "Cost Amendment Email Notification Batch Status", description = "GET an entity")
@ResponseBody
public class EntityController {

    @ApiOperation(value = "Get an entity by Id")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getEntityDetails(HttpServletRequest request, @RequestParam("entityId") String entityId){

        return ResponseEntity.status(404).body("{\"message\": \"Entity not found for Id " + entityId + "\"}");
    }

}
