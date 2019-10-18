package com.stackroute.Muzix.controller;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {

    private ResponseEntity responseEntity;
    private TrackService trackService;

    @Autowired
    @Qualifier("trackDummyServiceImpl")
    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
        trackService.serviceUsed();
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws Exception
    {

        trackService.saveTrack(track);
        responseEntity= new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }
    @GetMapping("/tracks")
    public ResponseEntity<?> getAllTrack()
    {
        return new ResponseEntity<List<Track>>(trackService.getAllTrack(),HttpStatus.OK);
    }
    @DeleteMapping("/track")
    public ResponseEntity<?> deleteTrack(@RequestBody Track track) throws Exception
    {

        ResponseEntity<String> responseEntity = new ResponseEntity<String>("Succesfully deleted"+trackService.deleteTrack(track.getTrackId()), HttpStatus.GONE);
        return responseEntity;
    }
    @PutMapping("/track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track)
    {
            trackService.updateTrack(track);
            responseEntity= new ResponseEntity<String>("successfully updated", HttpStatus.ACCEPTED);
        return responseEntity;
    }
    @GetMapping("track/{name}")
    public ResponseEntity<?> searchTrack(@PathVariable String name) throws Exception
    {
        ResponseEntity responseEntity;
        trackService.trackByName(name);
        responseEntity =new ResponseEntity<String>("Search found",HttpStatus.FOUND);
        return responseEntity;
    }

}
