package com.shpakovskiy.smartqueues.queuefactory;

import com.shpakovskiy.smartqueues.entity.Queue;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class QueueFactory {

    public static HashMap<String, Queue> allQueues;

    public static HashMap<String, Queue> getAllQueues() {
        if (allQueues == null) {
            synchronized (QueueFactory.class) {
                if (allQueues == null) {
                    allQueues = new HashMap<>();
                }
            }
        }

        return allQueues;
    }
}
