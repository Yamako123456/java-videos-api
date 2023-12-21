package com.yamako.javavideosapi.dao;

import com.yamako.javavideosapi.model.Library;
import com.yamako.javavideosapi.services.LibraryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libraries")


public class LibraryController {
    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Library> getLibrariesByName(@RequestParam(defaultValue = "") String name,
                                            @RequestParam(defaultValue = "1") int userId) {
        List<Library> libraries = null;
//        if (name.trim().length() > 0)
//            libraries = libraryService.get
        return libraries;
    }

}
