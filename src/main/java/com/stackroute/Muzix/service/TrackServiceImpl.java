package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.repository.TrackRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class TrackServiceImpl implements TrackService{
    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void serviceUsed() {
        System.out.println("original");
    }

    @Override
    public Track saveTrack(Track track) throws Exception{
        if(trackRepository.existsById(track.getTrackId()))
            throw new Exception("TrackAlreadyExists");
        Track savedTrack =trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllTrack() {
        return (List<Track>) trackRepository.findAll();
    }

    @Override
    public Track updateTrack(Track track) {
        Track updatedtrack =trackRepository.save(track);
        return updatedtrack;
    }

    @Override
    public Track deleteTrack(int trackId) throws Exception{
        if(trackRepository.findById(trackId)==null)
        {
            throw new Exception("TrackNotFoundException");
        }
        else
            return trackRepository.getOne(trackId);
    }
    @Override
    public List<Track> trackByName(String trackName) throws Exception{
        List<Track> tracks = trackRepository.getTrackByName(trackName);
        if(tracks.size()==0)
            throw new Exception("TrackNotFoundException");
        else
            return tracks;
    }

}
