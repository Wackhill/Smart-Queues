package com.shpakovskiy.smartqueues.service;

import com.shpakovskiy.smartqueues.entity.Queue;
import com.shpakovskiy.smartqueues.entity.QueueCreationData;

public interface QueueService {

    String addQueue(Queue queue);
    String createNewQueue(QueueCreationData queueCreationData);
    Queue getQueueByAccessLink(String id);
}
