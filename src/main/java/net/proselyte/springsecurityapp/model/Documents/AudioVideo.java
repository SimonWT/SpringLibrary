package net.proselyte.springsecurityapp.model.Documents;


import net.proselyte.springsecurityapp.model.Documents.Document;

import javax.persistence.*;

/**
 * Simple JavaBean domain object that represents a Audio or Video material.
 *
 * @author Igor Vakhula
 */

@Entity
@Table(name = "av")
public class AudioVideo extends Document {

    public AudioVideo() {
    }

    public AudioVideo(int copies, String title, int price, String authors) {
        super(copies, title, price, authors);
    }
}
