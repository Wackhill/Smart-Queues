package com.shpakovskiy.smartqueues.repository;

import com.shpakovskiy.smartqueues.entity.Queue;
import com.shpakovskiy.smartqueues.entity.QueueCreationData;

public interface QueueRepository {

    String addQueue(Queue queue);
    String createNewQueue(QueueCreationData queueCreationData);
    Queue getQueueByAccessLink(String id);
}
