package com.pwh.springevent.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author Waver
 * @date 2019/10/25 17:10
 */
public class MyEvent extends ApplicationContextEvent {
    private String id;
    private String name;

    public MyEvent(ApplicationContext source) {
        super(source);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyEvent{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
