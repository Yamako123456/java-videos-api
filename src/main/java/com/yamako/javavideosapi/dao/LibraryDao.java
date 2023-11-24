package com.yamako.javavideosapi.dao;

import com.yamako.javavideosapi.model.Library;

import java.util.List;

public interface LibraryDao {
    List<Library> getLibraryies();
    List<Library> getLibraryiesByOwnerId();
    List<Library> getLibraryiesByName();
    Library getLibraryById(int id);

}
