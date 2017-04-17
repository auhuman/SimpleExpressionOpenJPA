/**
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 * <p>
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.auhuman.self;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.OpenJpaVendorAdapter;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = { "com.auhuman.self" })
public class JpaConfig extends JpaBaseConfiguration {

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new OpenJpaVendorAdapter() {
            @Override
            public Map<String, Object> getJpaPropertyMap() {
                Map<String, Object> jpaPropertyMap = super.getJpaPropertyMap();
                    jpaPropertyMap.put("openjpa.ConnectionFactoryProperties", "PrintParameters=true");
                jpaPropertyMap.put("openjpa.Multithreaded", true);
                return jpaPropertyMap;
            }
        };
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        Map<String, Object> jpaProps = new HashMap<String, Object>();
        return jpaProps;
    }

}
