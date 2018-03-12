package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
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
