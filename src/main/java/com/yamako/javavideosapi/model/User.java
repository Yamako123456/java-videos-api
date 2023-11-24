package com.yamako.javavideosapi.model;

public class User {
    private int userId; //user_id integer NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    private String username; //username character varying(50) COLLATE pg_catalog."default" NOT NULL,
    private String passwordHash; //password_hash character varying(200) COLLATE pg_catalog."default" NOT NULL,
    private String role; //role character varying(50) COLLATE pg_catalog."default" NOT NULL,
    private String name; //name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    private String email; //email character varying(200) COLLATE pg_catalog."default" NOT NULL,
    private String address; //address character varying(100) COLLATE pg_catalog."default",
    private String city; //city character varying(50) COLLATE pg_catalog."default",
    private String stateCode; //state_code character(2) COLLATE pg_catalog."default",
    private String zip; //zip character varying(5) COLLATE pg_catalog."default",

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
