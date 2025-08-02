package com.rustyapp.common.quartz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Properties;

/**
 * Quartz configuration class
 */
@Configuration
public class QuartzConfig {

    /**
     * Configure Quartz scheduler factory bean
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        
        // Configure Quartz properties
        Properties quartzProperties = new Properties();
        quartzProperties.setProperty("org.quartz.scheduler.instanceName", "AppScheduler");
        quartzProperties.setProperty("org.quartz.scheduler.instanceId", "AUTO");
        quartzProperties.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        quartzProperties.setProperty("org.quartz.threadPool.threadCount", "10");
        quartzProperties.setProperty("org.quartz.threadPool.threadPriority", "5");
        quartzProperties.setProperty("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");
        
        schedulerFactory.setQuartzProperties(quartzProperties);
        schedulerFactory.setAutoStartup(true);
        schedulerFactory.setStartupDelay(5);
        
        return schedulerFactory;
    }
} 