package com.yamako.javavideosapi.dao;

import com.yamako.javavideosapi.model.Video;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcVideoDao implements VideoDao {

   private final JdbcTemplate jdbcTemplate;

   //Dependency Injection
    public JdbcVideoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Video> getVideos() {
        return null;
    }

    @Override
    public List<Video> getSelectedVideosByLibraryId( int libId) {
        List<Video> videos = new ArrayList<>();
        String sql =
                "select * from video " +
                "where library_id = ? and selected = true;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, libId);

        while( rowSet.next()) {
            videos.add(mapRowToVideo(rowSet));
        }

        return videos;
    }

    @Override
    public Video getVideoById(int id) {
        return null;
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
