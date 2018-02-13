package system.model.Booking;

import system.model.Documents.Document;

import java.util.ArrayList;

/**
 * Created by evgeniy on 31.01.18.
 */
public interface BookingSystem {
    ArrayList<Document> docs = null;
    ArrayList<Document> search();
}
