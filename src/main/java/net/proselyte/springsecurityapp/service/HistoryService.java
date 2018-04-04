package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Booking.History;

import java.util.List;

public interface HistoryService {
    History getHistoryById(Long id);
    List<History> getListOfHistoryByUser(Long id);
    void updateHistory(History history);
    void save(History history);
    History getHistoryByIdAndDocId(Long userId, Long docId);
    List<History> getListHistoriesByIdAndDocId(Long userId, Long docId);

}
