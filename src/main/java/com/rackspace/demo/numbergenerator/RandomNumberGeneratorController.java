package com.rackspace.demo.numbergenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

@RestController
public class RandomNumberGeneratorController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private RandomNumberGeneratorService randomNumberGeneratorService;

    @ApiOperation(value = "generates randowm number between 1 and given limit", response = ResponseEntity.class, tags = {"generateRandomNumber",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "NO DATA FOUND", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "Bad Request | Error", response = ResponseEntity.class)})
    @GetMapping (path = "/randomnumbers", produces = {"application/json"})
   // @RequestMapping(value = "/randomnumbers",produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<Status> returnRandomNumber(
            @ApiParam(value = "unique session id for request.", required = true) @RequestHeader(value = "SESSIONID") String sessionId,
            @ApiParam(value = "specify the limit.", required = false) @PathVariable(value = "limit", required = false) Integer limit)
    {
        logger.info("entering returnRandomNumber with limit : {}", limit);
        Status status = randomNumberGeneratorService.generatorRandomNumer(limit);
        logger.info("entering returnRandomNumber with status code : {} & randomNumber : {}", status.getStatusCode(), status.getRandomNumber());
        return buildResponseEntity(status);
    }

    private ResponseEntity<Status> buildResponseEntity(Status status)
    {
        ResponseEntity entity = null;
        if(null != status && status.getStatusCode() == 0)
        {
            return new ResponseEntity(status, HttpStatus.OK);
        }else{
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
