package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.AudioVideo;

public interface AudioVideoMaterialService {

    void save(AudioVideo audioVideo);

    void delete(Long id);
}
