package com.yamako.javavideosapi.dao;

import com.yamako.javavideosapi.model.Library;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLibraryDao implements LibraryDao{

   private final JdbcTemplate jdbcTemplate;

    public JdbcLibraryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Library> getLibraryies() {
        List<Library> libraries = new ArrayList<>();

        String sql = "select * from library;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
           libraries.add(mapRowToLibrary(rowSet));
        }
        return libraries;
    }

    @Override
    public List<Library> getLibraryiesByOwnerId(int ownerId) {
        List<Library> libraries = new ArrayList<>();
        String sql = "select * from library " +
                "where owner_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, ownerId);
        while (rowSet.next()) {
            libraries.add(mapRowToLibrary(rowSet));
        }
        return libraries;
    }

    @Override
    public List<Library> getLibraryiesByName(String name, boolean useWildCard) {
        List<Library> libraries = new ArrayList<>();
        if (useWildCard)
            name = "%" + name + "%";

        String sql = "select * from library " +
                "where name LIKE ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, name);
        while (rowSet.next()) {
            libraries.add(mapRowToLibrary(rowSet));
        }
        return libraries;
    }

    @Override
    public Library getLibraryById(int id) {
        Library library = null;
        String sql = "select * from library " +
                "where library_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
        if (rowSet.next()) {
            library = mapRowToLibrary(rowSet);
        }
        return library;
    }

    private Library mapRowToLibrary(SqlRowSet rs) {
        Library library = new Library();

        library.setLibraryId(rs.getInt("library_id"));
        library.setOwnerId(rs.getInt("owner_id"));
        library.setName(rs.getString("name"));
        library.setDescription(rs.getString("description"));

        return library;
    }
}
