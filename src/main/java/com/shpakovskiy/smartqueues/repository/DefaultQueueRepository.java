package com.shpakovskiy.smartqueues.repository;

import com.shpakovskiy.smartqueues.entity.Queue;
import com.shpakovskiy.smartqueues.entity.QueueCreationData;
import com.shpakovskiy.smartqueues.queuefactory.QueueFactory;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Repository
public class DefaultQueueRepository implements QueueRepository {

    @Override
    public String addQueue(Queue queue) {
        QueueFactory.getAllQueues().put(queue.getAccessLink(), queue);
        return queue.getAccessLink();
    }

    @Override
    public String createNewQueue(QueueCreationData queueCreationData) {
        String fullDateAndTime = queueCreationData.getStartDate() + " " + queueCreationData.getStartTime();

        try {
            Queue queue = new Queue.Builder()
                    .title(queueCreationData.getTitle())
                    .usersNumber(queueCreationData.getMaxPlaces())
                    .registrationStart(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(fullDateAndTime).getTime())
                    .build();

            return this.addQueue(queue);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Queue getQueueByAccessLink(String id) {
        return QueueFactory.getAllQueues().get(id);
    }
}
