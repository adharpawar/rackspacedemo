package com.rackspace.demo.numbergenerator;

import com.rackspace.demo.numbergenerator.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class RandomNumberGeneratorService {

   Logger logger = LoggerFactory.getLogger(this.getClass().getName());

   /*
    This method will return random number between 1 and given integer including both 1 & limit
    if given input is null then it will generate between 1 and 6, including 1 & 6.
    */
    public Status generatorRandomNumer(Integer limit)
    {
        logger.info("entering generatorRandomNumer with limit : {}", limit);
        Status status = null;
        try {
            limit = (limit == null) ? 6 : (limit);

            Random random = new Random();
            int nextRandomNumber = random.nextInt(limit);
            nextRandomNumber = (nextRandomNumber == 0) ? nextRandomNumber+1 : nextRandomNumber;

            logger.info("leaving generatorRandomNumer with nextRandomNumber is : {}", nextRandomNumber);
            return new Status(0, nextRandomNumber);
        }catch(Exception ex){
            logger.error("exception occurred in generatorRandomNumer method.");
            return new Status(-1, -1); // 20171 20166  20166 or raystone  costly
        }
    }
}
