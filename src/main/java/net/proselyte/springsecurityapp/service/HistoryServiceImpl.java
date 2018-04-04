package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.HistoryDao;
import net.proselyte.springsecurityapp.model.Booking.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryDao historyDao;

    @Override
    public History getHistoryById(Long id) {
        return historyDao.getHistoryById(id);
    }

    @Override
    public List<History> getListOfHistoryByUser(Long id) {
        return historyDao.findAllByUserId(id);
    }

    @Override
    public void updateHistory(History history) {
        historyDao.save(history);
    }

    @Override
    public void save(History history) {
        historyDao.save(history);
    }

    @Override
    public History getHistoryByIdAndDocId(Long userId, Long docId) {
        return historyDao.getHistoryByUserIdAndDocId(userId,docId);
    }

    @Override
    public List<History> getListHistoriesByIdAndDocId(Long userId, Long docId) {
        return historyDao.getHistoriesByUserIdAndDocIdOrderById(userId,docId);
    }


}
