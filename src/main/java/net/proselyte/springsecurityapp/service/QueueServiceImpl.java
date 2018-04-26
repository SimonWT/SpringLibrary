package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.DocDao;
import net.proselyte.springsecurityapp.dao.QueueDao;
import net.proselyte.springsecurityapp.dao.UserDao;
import net.proselyte.springsecurityapp.model.Booking.Queue;
import net.proselyte.springsecurityapp.model.Users.Patron;
import net.proselyte.springsecurityapp.model.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


@EnableScheduling
@Service
public class QueueServiceImpl implements QueueService {

    @Autowired
    private QueueDao queueDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DocDao docDao;

    @Autowired
    @Transient
    private UserServiceImpl userService;

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

    @Override
    public java.util.Queue getPriorityQueue(Long docId) {
        java.util.Queue<Patron> queue = new PriorityQueue<>(1, new PatronComparator());
        List<Queue> queueList = queueDao.getAllByDocId(docId);
        for (Queue qUser: queueList){
            queue.add((Patron) userDao.getUserById(qUser.getUserId()));
        }

        return queue;
    }

    @Override
    @Scheduled(fixedDelay = 86400000)
    public void sendNotificationToPeekOfQueue() {
        //List<Queue> docIdQueue = queueDao.findQueuesUnicByDocId();
        List<Long> docIds = queueDao.findUnicDocId();
        List<java.util.Queue<Patron>> listOfQueues = new LinkedList<>();
        for (Long docId: docIds) {
             listOfQueues.add(getPriorityQueue(docId));
        }

        for (int i = 0; listOfQueues.size()!=0 && i<listOfQueues.size(); i++) {
            java.util.Queue<Patron> queue = listOfQueues.get(i);

            if(false && queue.size()!=0 && queue.peek().getNotification()!=null )
                if(queue.peek().getNotification().equals("") ){
                    //send notifications
                    //TODO: send notification and how to check it (above)
                } else{
                    queueDao.deleteByUserIdAndDocId(queue.peek().getId(), docIds.get(i));
                    queue.poll();
                    //TODO: send notification
                }
        }

    }
}


