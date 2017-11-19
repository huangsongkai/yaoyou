package com.yaoyou.infrastructure.messaging.init;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.yaoyou.infrastructure.messaging.AddItemSnap;
import com.yaoyou.infrastructure.messaging.AsyncEventEngine;
import com.yaoyou.infrastructure.messaging.handler.AddItemSnapHandler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ActorsInitListener
 *
 * @date 15/8/12 下午2:50
 */
public class ActorsInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ActorSystem rootSystem = AsyncEventEngine.getActorSystem();
        ActorRef addItemHandler = rootSystem.actorOf(Props.create(AddItemSnapHandler.class));
        // 注册监听者
        rootSystem.eventStream().subscribe(addItemHandler, AddItemSnap.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        AsyncEventEngine.getActorSystem().shutdown();
        AsyncEventEngine.getActorSystem().awaitTermination();
    }
}
