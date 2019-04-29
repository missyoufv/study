package com.springioc.bean;

import org.springframework.beans.factory.FactoryBean;

public class ProductFactory implements FactoryBean<Product> {
    @Override
    public Product getObject() throws Exception {
        return new Product("1","phone");
    }

    @Override
    public Class<?> getObjectType() {
        return Product.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
