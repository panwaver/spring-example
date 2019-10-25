package com.pwh.springevent.service;

import com.pwh.springevent.domain.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("from MyEventListener :" + event);
        System.out.println("event type: "+event.getClass());
    }
}