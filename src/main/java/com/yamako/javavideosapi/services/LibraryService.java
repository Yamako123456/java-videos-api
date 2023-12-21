package com.yamako.javavideosapi.services;

import com.yamako.javavideosapi.dao.LibraryDao;
import com.yamako.javavideosapi.dao.UserDao;
import com.yamako.javavideosapi.dao.VideoDao;
import com.yamako.javavideosapi.model.Library;
import com.yamako.javavideosapi.model.Video;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryService {
    private VideoDao videoDao;
    private LibraryDao libraryDao;
    private UserDao userDao;

    public LibraryService(VideoDao videoDao, LibraryDao libraryDao, UserDao userDao) {
        this.videoDao = videoDao;
        this.libraryDao = libraryDao;
        this.userDao = userDao;
    }

    public List<Video> getActiveVideos(int libraryId) {
        return videoDao.getSelectedVideosByLibraryId(libraryId);
    }

    public List<Library> getLibraries(String name) {
        if (name.trim().length() > 0)
            return libraryDao.getLibraryiesByName(name, true);
        else
            return libraryDao.getLibraryies();

    }

    public Library getLibraryById(int id) {
        return libraryDao.getLibraryById(id);
    }
}
