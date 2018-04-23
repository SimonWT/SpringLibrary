package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.DocDao;
import net.proselyte.springsecurityapp.dao.QueueDao;
import net.proselyte.springsecurityapp.dao.UserDao;
import net.proselyte.springsecurityapp.model.Booking.Queue;
import net.proselyte.springsecurityapp.model.Users.Patron;
import net.proselyte.springsecurityapp.model.Users.PatronComparator;
import net.proselyte.springsecurityapp.model.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

@Service
@EnableScheduling
public class QueueServiceImpl implements QueueService {

    @Autowired
    private QueueDao queueDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DocDao docDao;

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
    public void sendNotificationToPeekOfQueue() {
//        //List<Queue> docIdQueue = queueDao.findQueuesUnicByDocId();
//        List<java.util.Queue<Patron>> listOfQueues = new LinkedList<>();
//        for (Queue docQ: docIdQueue) {
//             listOfQueues.add(getPriorityQueue(docQ.getDocId()));
//        }
//
//        for (java.util.Queue<Patron> queue: listOfQueues) {
//            if( queue.peek().getNotification().equals("") ){
               wait1dayUntilDrop();
//            }
//        }

    }


    private void wait1dayUntilDrop(){
//        List<Queue> docIdQueue = queueDao.findQueuesUnicByDocId();
//        List<java.util.Queue<Patron>> listOfQueues = new LinkedList<>();
//        for (Queue docQ: docIdQueue) {
//            listOfQueues.add(getPriorityQueue(docQ.getDocId()));
//        }
//
//        for (java.util.Queue<Patron> queue: listOfQueues) {
//            queueDao.deleteByUserId(queue.peek().getId());
//        }
    }


}
