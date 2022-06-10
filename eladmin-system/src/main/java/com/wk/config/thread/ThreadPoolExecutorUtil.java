
package com.wk.config.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 用于获取自定义线程池
 * @author wang kang
 * @date 2019年10月31日18:16:47
 */
public class ThreadPoolExecutorUtil {

    public static ThreadPoolExecutor getPoll(){
        return new ThreadPoolExecutor(
                AsyncTaskProperties.corePoolSize,
                AsyncTaskProperties.maxPoolSize,
                AsyncTaskProperties.keepAliveSeconds,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(AsyncTaskProperties.queueCapacity),
                new TheadFactoryName()
        );
    }
}
