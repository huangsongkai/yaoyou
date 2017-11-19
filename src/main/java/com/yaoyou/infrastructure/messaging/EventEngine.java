package com.yaoyou.infrastructure.messaging;

/**
 * AkkaManager
 *
 * @date 15/8/13 下午1:35
 */
public interface EventEngine {
    void fireEvent(DomainEvent event);
}
