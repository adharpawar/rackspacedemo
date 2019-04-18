package com.rackspace.demo.numbergenerator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RandomNumberGeneratorServiceTest {

    @Autowired
    RandomNumberGeneratorService randomNumberGeneratorService;

    @Autowired
    Status status;

    @Before
    public void setUp() throws Exception {
        randomNumberGeneratorService = new RandomNumberGeneratorService();
    }

    @Test
    public void returnRandomNumberTest_verifySucessWithValidLimit() throws Exception{
        status = randomNumberGeneratorService.generatorRandomNumer(10);

        assertEquals("Status should be 0", status.getStatusCode(), 0);
        assertTrue("Generated Random Number should be greater than or equal to 1 ", status.getRandomNumber() >= 1);
        assertTrue("Generated Random Number should be less than or equal to 10 ", status.getRandomNumber() <= 10);
    }

    @Test
    public void returnRandomNumberTest_verifySucessWhenNoLimitProvided() throws Exception{
        status = randomNumberGeneratorService.generatorRandomNumer(null);

        assertEquals("Status should be 0", status.getStatusCode(), 0);
        assertTrue("Generated Random Number should be greater than or equal to 1 ", status.getRandomNumber() >= 1);
        assertTrue("Generated Random Number should be less than or equal to 6 ", status.getRandomNumber() <= 6);
    }

    @Test
    public void returnRandomNumberTest_verifyFailedWhenNoLimitProvided() throws Exception{
        status = randomNumberGeneratorService.generatorRandomNumer(null);

        assertEquals("Status should be 0", status.getStatusCode(), 0);
        assertTrue("Generated Random Number should be greater than or equal to 1 ", status.getRandomNumber() >= 1);
        assertFalse("Generated Random Number should be less than or equal to 6 ", status.getRandomNumber() > 6);
    }
}