package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Documents.AudioVideo;

public interface AudioVideoMaterialService {

    void save(AudioVideo audioVideo);

    void delete(Long id);

    AudioVideo getAudioVideoById(Long id);

    void update(AudioVideo audioVideo);
}
