package com.yamako.javavideosapi.dao;

import com.yamako.javavideosapi.model.Video;

import java.util.List;

public interface VideoDao {
    List<Video> getVideos();
    List<Video> getSelectedVideosByLibraryId( int libId);
    Video getVideoById(int id);

}
