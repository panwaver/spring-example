package com.pwh.springevent.service;

import com.pwh.springevent.domain.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author Waver
 * @date 2019/10/25 17:14
 */
@Service
public class MyEventPublicationService {
    @Autowired
    ApplicationContext context;

    public void publish(MyEvent myEvent){

        this.context.publishEvent(myEvent);
    }

    public void publish1(){
        MyEvent myEvent = new MyEvent(context);
        myEvent.setId("2");
        myEvent.setName("lisi");

        this.context.publishEvent(myEvent);
    }
}
