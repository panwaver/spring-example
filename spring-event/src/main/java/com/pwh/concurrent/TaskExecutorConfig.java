package com.pwh.concurrent;


import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @description: 异步线程池
 * @author: 512806
 * @create: 2020-12-23 15:27
 */
@Configuration
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {
    // 配置类实现AsyncConfinger 接口并重现getAsyncExecutor方法，并返回一个ThreadPoolTaskExecutor，这样我们就获得了一个线程池threadPoolTaskExecutor。
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //核心线程大小
        threadPoolTaskExecutor.setCorePoolSize(5);
        //最大线程大小
        threadPoolTaskExecutor.setMaxPoolSize(10);
        //队列最大容量
        threadPoolTaskExecutor.setQueueCapacity(100);
        //存活时间
        threadPoolTaskExecutor.setKeepAliveSeconds(3000);
        //拒绝执行时如何处理
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}
