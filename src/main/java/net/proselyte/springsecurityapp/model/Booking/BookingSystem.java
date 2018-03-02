package net.proselyte.springsecurityapp.model.Booking;

import net.proselyte.springsecurityapp.model.Documents.Document;

import java.util.ArrayList;

/**
 * Created by evgeniy on 31.01.18.
 */
public interface BookingSystem {
    ArrayList<Document> docs = null;
    ArrayList<Document> search();
}