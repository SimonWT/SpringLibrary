package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Booking.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueueDao extends JpaRepository<Queue, Long> {

    Queue getQueueById(Long id);

    List<Queue> getAllByUserId(Long id);
}
