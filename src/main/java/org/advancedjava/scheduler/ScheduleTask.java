package org.advancedjava.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class ScheduleTask {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    public static void main(String[] args) {
        logger.info("Start logging........");
        ScheduleTask.scheduleTaskAfterSomeDelay();
    }

    public static void scheduleTaskAfterSomeDelay() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> future = executor.schedule(() -> {

              //we can do anything here it will execute after the specified time
//            logger.info("Scheduler");

            return "Executor running.......";

        }, 1, TimeUnit.MINUTES);

        try {
            // Wait for the task to complete
            String s = (String) future.get();
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Shutdown the executor service
        executor.shutdown();

    }
}
