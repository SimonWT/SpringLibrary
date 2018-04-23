package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Booking.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QueueDao extends JpaRepository<Queue, Long> {

    Queue getQueueById(Long id);
    List<Queue> getAllByUserId(Long id);
    
    List<Queue> getAllByDocId(Long docId);

    @Query(value = "SELECT DISTINCT doc_id from queue")
    List<Queue> findQueuesByUnicDocId();

    void deleteByUserId(Long userId);

}
