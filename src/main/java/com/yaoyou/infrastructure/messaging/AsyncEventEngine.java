package com.yaoyou.infrastructure.messaging;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.springframework.stereotype.Service;

/**
 * AkkaManager
 *
 * @author liuruichao
 * @date 15/8/13 下午1:35
 */
@Service
public final class AsyncEventEngine /*implements EventEngine*/ {
    private static final ActorSystem rootSystem = ActorSystem.create("rootSystem");
    private static final ActorRef emitter = rootSystem.actorOf(Props.create(Emitter.class));

    public static void fireEvent(DomainEvent event) {
        emitter.tell(event, null);
    }

    public static ActorSystem getActorSystem() {
        return rootSystem;
    }
}
