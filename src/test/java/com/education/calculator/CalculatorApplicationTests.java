package com.education.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.co.sintez.black.jack.config.RedisConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RedisConfig.class)
@WebAppConfiguration
public class CalculatorApplicationTests {

    @Test
    public void contextLoads() {
    }

}
