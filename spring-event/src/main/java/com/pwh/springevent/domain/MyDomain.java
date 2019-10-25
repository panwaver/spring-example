package com.pwh.springevent.domain;

/**
 * @author Waver
 * @date 2019/10/25 18:10
 */
public class MyDomain {
    private String id;
    private String name;

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
        return "MyDomain{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
