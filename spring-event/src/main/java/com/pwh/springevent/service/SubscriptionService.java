package com.pwh.springevent.service;

import com.pwh.springevent.domain.MyDomain;
import com.pwh.springevent.domain.MyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author Waver
 * @date 2019/10/25 17:19
 */
@Service
public class SubscriptionService {
    @EventListener
    public void subcription(MyEvent myEvent){
        System.out.println(">>>>>>>>>>"+myEvent+"<<<<<<<<");
    }

    @EventListener
    public void subcription(MyDomain myDomain){
        System.out.println(">>>>>>>>>>"+myDomain+"<<<<<<<<");
    }
}
