package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.*;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link ArticleService} interface.
 *
 * @author Igor Vakhula
 */

@Service
public class AudioVideoMaterialServiceImpl implements AudioVideoMaterialService {



    @Autowired
    private AudioVideoDao audioVideoDao;


    @Override
    public void save(AudioVideo audioVideo) {
        audioVideoDao.save(audioVideo);
    }

    @Override
    public void delete(Long id) {
        audioVideoDao.delete(id);
    }

    @Override
    public AudioVideo getAudioVideoById(Long id) {
        return audioVideoDao.getAudioVideoById(id);
    }

    @Override
    public void update(AudioVideo audioVideo) {
        audioVideoDao.save(audioVideo);
    }


}
