package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.AudioVideo;
import net.proselyte.springsecurityapp.model.Book;
import net.proselyte.springsecurityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO interface
 *
 * @author Igor Vakhula
 *
 */
public interface AudioVideoDao extends JpaRepository<AudioVideo, Long> {
    AudioVideo getAudioVideoById(Long id);
}
