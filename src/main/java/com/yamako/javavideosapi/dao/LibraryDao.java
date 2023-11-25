package com.yamako.javavideosapi.dao;

import com.yamako.javavideosapi.model.Library;

import java.util.List;

public interface LibraryDao {
    List<Library> getLibraryies();
    List<Library> getLibraryiesByOwnerId(int ownerId);
    List<Library> getLibraryiesByName(String name, boolean useWildCard);
    Library getLibraryById(int id);

}
