package com.yamako.javavideosapi.model;

public class Video {
    private int videoId; //video_id integer NOT NULL DEFAULT nextval('video_video_id_seq'::regclass),
    private int libraryId; //library_id integer NOT NULL,
    private String name; //name character; //character varying(50) COLLATE pg_catalog."default" NOT NULL,
    private String url; //url character varying(200) COLLATE pg_catalog."default" NOT NULL,
    private String thumbnail; //thumbnail character varying(200) COLLATE pg_catalog."default" NOT NULL,
    private String title; //title character varying(50) COLLATE pg_catalog."default" NOT NULL,
    private String comment; //comment character varying COLLATE pg_catalog."default",
    private boolean selected; //selected boolean NOT NULL,

    public Video(int libraryId, String name, String url, String thumbnail, String title, boolean selected) {
        this.libraryId = libraryId;
        this.name = name;
        this.url = url;
        this.thumbnail = thumbnail;
        this.title = title;
        this.selected = selected;
    }

    public Video() {
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", libraryId=" + libraryId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                ", selected=" + selected +
                '}';
    }
}
