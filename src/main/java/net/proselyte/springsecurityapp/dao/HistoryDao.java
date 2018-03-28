package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Booking.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryDao extends JpaRepository<History, Long> {
    History getHistoryById(Long id);

    List<History> findAllByUserId(Long id);

}
