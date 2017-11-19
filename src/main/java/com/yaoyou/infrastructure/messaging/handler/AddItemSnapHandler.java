package com.yaoyou.infrastructure.messaging.handler;

import akka.actor.UntypedActor;
import com.yaoyou.dao.ItemSnapMapper;
import com.yaoyou.infrastructure.messaging.AddItemSnap;
import com.yaoyou.model.dataObject.Item;
import com.yaoyou.model.dataObject.ItemSnap;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.lang.reflect.InvocationTargetException;


/**
 */
//@Component
public class AddItemSnapHandler extends UntypedActor {
    private final Logger logger = Logger.getLogger(this.getClass());

//    @Resource
//    ItemSnapMapper itemSnapMapper;
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof AddItemSnap) {
            logger.info("new Item");
            ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
            ItemSnapMapper itemSnapMapper = (ItemSnapMapper)ctx.getBean("itemSnapMapper");
            itemSnapMapper.insert(genSnap(((AddItemSnap) message).getItem()));
        }
    }
    private ItemSnap genSnap(Item item){
        ItemSnap itemSnap = new ItemSnap();
        try {
            BeanUtils.copyProperties(itemSnap, item);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return itemSnap;
    }
}
