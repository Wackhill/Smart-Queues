package com.shpakovskiy.smartqueues.service;

import com.shpakovskiy.smartqueues.entity.Queue;
import com.shpakovskiy.smartqueues.entity.QueueCreationData;
import com.shpakovskiy.smartqueues.repository.QueueRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultQueueService implements QueueService {

    private final QueueRepository queueRepository;

    public DefaultQueueService(QueueRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    @Override
    public String addQueue(Queue queue) {
        return queueRepository.addQueue(queue);
    }

    @Override
    public String createNewQueue(QueueCreationData queueCreationData) {
        return queueRepository.createNewQueue(queueCreationData);
    }

    @Override
    public Queue getQueueByAccessLink(String id) {
        return queueRepository.getQueueByAccessLink(id);
    }
}