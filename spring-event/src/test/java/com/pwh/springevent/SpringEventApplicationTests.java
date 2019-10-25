package com.pwh.springevent;

import com.pwh.springevent.domain.MyDomain;
import com.pwh.springevent.domain.MyEvent;
import com.pwh.springevent.service.MyDomainPublicationService;
import com.pwh.springevent.service.MyEventPublicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringEventApplicationTests {
    @Autowired
    MyEventPublicationService publicationService;
    @Autowired
    ApplicationContext context;

    @Autowired
    MyDomainPublicationService myDomainPublicationService;

    @Test
    void contextLoads() {
        MyEvent myEvent = new MyEvent(context);
        myEvent.setId("01");
        myEvent.setName("zhangsan0");
        publicationService.publish(myEvent);
        publicationService.publish1();

        MyDomain myDomain = new MyDomain();
        myDomain.setId("000");
        myDomain.setName("domain000");
        myDomainPublicationService.publish(myDomain);

        myDomainPublicationService.publish1();

    }

}
