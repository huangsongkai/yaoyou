package com.yaoyou.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class SafeEqualCheckerTest {
    @Test
    public void testCheck(){
        BigDecimal a = new BigDecimal("1.00");
        BigDecimal b = new BigDecimal("1.000");
        System.out.println(SafeEqualChecker.isEqualSimpleType(a, b));
    }

}