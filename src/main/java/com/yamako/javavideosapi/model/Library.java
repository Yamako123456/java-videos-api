package com.yamako.javavideosapi.model;

public class Library {
    private int libraryId; //library_id integer NOT NULL DEFAULT nextval('library_library_id_seq'::regclass),
    private int ownerId; //owner_id integer NOT NULL,
    private String name; //name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    private String description; //description character varying(200) COLLATE pg_catalog."default",

    public Library(int ownerId, String name) {
        this.ownerId = ownerId;
        this.name = name;
    }

    public Library() {
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
