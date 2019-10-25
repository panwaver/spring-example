package com.pwh.springevent.service;

import com.pwh.springevent.domain.MyDomain;
import com.pwh.springevent.domain.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author Waver
 * @date 2019/10/25 17:14
 */
@Service
public class MyDomainPublicationService {
    @Autowired
    ApplicationContext context;

    public void publish(MyDomain myDomain){

        this.context.publishEvent(myDomain);
    }

    public void publish1(){
        MyDomain myDomain = new MyDomain();
        myDomain.setId("111");
        myDomain.setName("domain");

        this.context.publishEvent(myDomain);
    }
}
