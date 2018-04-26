package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Booking.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface QueueDao extends JpaRepository<Queue, Long> {

    Queue getQueueById(Long id);
    List<Queue> getAllByUserId(Long id);
    
    List<Queue> getAllByDocId(Long docId);

    @Query(value = "select distinct docId from Queue")
    List<Long> findUnicDocId();

    void deleteByUserId(Long userId);
    void deleteByUserIdAndDocId(Long userId, Long docId);

}
