package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.*;
import net.proselyte.springsecurityapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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


}
