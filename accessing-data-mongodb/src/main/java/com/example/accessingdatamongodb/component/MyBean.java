package com.example.accessingdatamongodb.component;

/*
Reference: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-mongodb
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    private final MongoDatabaseFactory mongo;

    @Autowired
    public MyBean(MongoDatabaseFactory mongo) {
        this.mongo = mongo;
    }
}
