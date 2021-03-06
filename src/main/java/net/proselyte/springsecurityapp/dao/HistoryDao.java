package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Booking.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryDao extends JpaRepository<History, Long> {
    History getHistoryById(Long id);
    List<History> findAllByUserId(Long id);
    History getHistoryByUserIdAndDocId(Long userId, Long docId);

    List<History> getHistoriesByUserIdAndDocIdOrderById(Long userId,Long docId);
    List<History> getHistoriesByUserIdAndStatus(Long userId, int status );

    List<History> getHistoriesByDocIdAndStatus(Long docId, int status);

}
