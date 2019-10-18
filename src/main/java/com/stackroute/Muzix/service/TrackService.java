package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.domain.Track;
import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws Exception;
    public List<Track> getAllTrack();
    public Track deleteTrack(int trackId) throws Exception;
    public List<Track> trackByName(String trackName) throws Exception;
    public Track updateTrack(Track track) ;
    public void serviceUsed();

}
