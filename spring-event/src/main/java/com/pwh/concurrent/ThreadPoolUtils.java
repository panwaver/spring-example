package com.pwh.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工具类
 *
 * @author panweihua450
 * @date 2021/5/27 16:29
 */
public class ThreadPoolUtils {

    private ThreadPoolUtils() {

    }

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolUtils.class);

    /**
     * 核心线程数
     */
    private static final int DEFAULT_CORE_SIZE = Runtime.getRuntime().availableProcessors() - 1;

    /**
     * 最大线程数
     */
    private static final int MAX_POOL_SIZE = ((DEFAULT_CORE_SIZE + 1) * 2 + 1) * 2;

    /**
     * 线程最大空闲时间
     */
    private static final long KEEP_ALIVE_TIME = 0L;

    /**
     * 线程池生成器:内部类+静态变量初始化保证线程安全
     */
    private static class ThreadPoolHolder {

        /**
         * 定时任务线程池初始化
         */
        private static ScheduledThreadPoolExecutor scheduleInstance = new ScheduledThreadPoolExecutor(
                DEFAULT_CORE_SIZE,
                // 线程创建工厂 实现ThreadFactory
                new BasicThreadFactory.Builder().namingPattern("datax-web-schedule-pool-%d").daemon(true).build()
        );

        /**
         * 线程池初始化
         */
        private static ThreadPoolExecutor instance = new ThreadPoolExecutor(
                DEFAULT_CORE_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(200),
                // 线程创建工厂 实现ThreadFactory
                new ThreadFactoryBuilder().setNameFormat("datax-web-pool-custom-thread-%d").build(),
                // 拒绝策略 实现RejectedExecutionHandler=>改为直接抛出异常
                new ThreadPoolExecutor.AbortPolicy() /*{
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                        LOGGER.error("======{}线程任务{}执行DiscardPolicy拒绝策略,isShutdown={},isTerminating={},isTerminated={},",
                                e.toString(), r.toString(), e.isShutdown(), e.isTerminating(), e.isTerminated());
                        if (!e.isShutdown()) {
                            if (r instanceof FutureTask) {
                                ((FutureTask) r).cancel(true);
                            } else {
                                r.run();
                            }
                        } else {
                            r.run();
                        }
                    }
                }*/
        );

        /**
         * 导入的线程池单例
         */
        private static ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor() {{
            setCorePoolSize(1);
            setMaxPoolSize(MAX_POOL_SIZE);
            setKeepAliveSeconds(0);
            setQueueCapacity(200);
            // 溢出线程采用当前线程
            setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
            initialize();
        }};
    }

    /**
     * 获取定时任务线程池实例-单例
     * 拒绝策略: AbortPolicy
     *
     * @return ThreadPoolExecutor
     */
    public static ScheduledThreadPoolExecutor getScheduleInstance() {
        return ThreadPoolHolder.scheduleInstance;
    }

    /**
     * 获取线程池实例-单例
     *
     * @return ThreadPoolExecutor
     */
    public static ThreadPoolExecutor getInstance() {
        return ThreadPoolHolder.instance;
    }

    /**
     * 获取线程池实例-单例
     * 拒绝策略: CallerRunsPolicy
     *
     * @return ThreadPoolExecutor
     */
    public static ThreadPoolTaskExecutor getTaskInstance() {
        return ThreadPoolHolder.threadPoolTaskExecutor;
    }

}
