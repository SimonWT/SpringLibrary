package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Booking.Queue;

import java.util.List;

public interface QueueService {

    Queue getQueueById(Long id);
    List<Queue> getListOfQueueByUser(Long id);
    void updateQueue(Queue queue);
    void save(Queue queue);
    java.util.Queue getPriorityQueue(Long docId);
    void sendNotificationToPeekOfQueue();
}
