package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.QueueDao;
import net.proselyte.springsecurityapp.model.Booking.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueServiceImpl implements QueueService {

    @Autowired
    private QueueDao queueDao;

    @Override
    public Queue getQueueById(Long id) {
        return queueDao.getQueueById(id);
    }

    @Override
    public List<Queue> getListOfQueueByUser(Long id) {
        return queueDao.getAllByUserId(id);
    }

    @Override
    public void updateQueue(Queue queue) {
        queueDao.save(queue);
    }

    @Override
    public void save(Queue queue) {
        queueDao.save(queue);
    }



}
