package com.yamako.javavideosapi.dao;

import com.yamako.javavideosapi.model.Video;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVideoDao implements VideoDao {

   private final JdbcTemplate jdbcTemplate;

   //Dependency Injection
    public JdbcVideoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Video> getVideos() {
        List<Video> videos = new ArrayList<>();
        String sql = "select * from video;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            videos.add(mapRowToVideo(rowSet));
        }
        return videos;
    }

    @Override
    public List<Video> getSelectedVideosByLibraryId( int libId) {
        List<Video> videos = new ArrayList<>();
        String sql =
                "select * from video " +
                "where library_id = ? and selected = true;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, libId);
        while ( rowSet.next()) {
            videos.add(mapRowToVideo(rowSet));
        }
        return videos;
    }

    @Override
    public List<Video> getVideoByName(String name, boolean useWildCard) {
        List<Video> videos = new ArrayList<>();
        if (useWildCard)
            name = "%" + name + "%";
        String sql = "select * from video " +
                "where name LIKE ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, name);
        while (rowSet.next()) {
            videos.add(mapRowToVideo(rowSet));
        }
        return videos;
    }

    @Override
    public Video getVideoById(int id) {
        Video video = null;
        String sql = "select * from video " +
                "where video_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
        if (rowSet.next()){
            video = mapRowToVideo(rowSet);
        }
        return video;
    }


    private Video mapRowToVideo(SqlRowSet rs) {
        Video video = new Video();

        video.setVideoId(rs.getInt("video_id"));
        video.setLibraryId(rs.getInt("library_id"));
        video.setName(rs.getString("name"));
        video.setUrl(rs.getString("url" ));
        video.setThumbnail(rs.getString("thumbnail"));
        video.setTitle(rs.getString("title"));
        video.setComment(rs.getString("comment"));
        video.setSelected(rs.getBoolean("selected"));

        return video;
    }
}
