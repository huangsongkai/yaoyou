package com.yaoyou.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ItemServiceTest {

    @Test
    public void testGetLatestItemSnapId() throws Exception {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("/applicationContext.xml");
        ItemService itemService = (ItemService) ctx.getBean("itemService");
        System.out.println(itemService.getLatestItemSnapId(18));

    }
}