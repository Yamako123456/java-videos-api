package com.yamako.javavideosapi.dao;

import com.yamako.javavideosapi.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserDao implements UserDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            users.add(mapRowToUser(rowSet));
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String sql = "select * from users " +
                "where user_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
        if (rowSet.next()) {
            user = mapRowToUser(rowSet);
        }
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        String sql = "select * from users " +
                "where username = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
        if (rowSet.next()) {
            user = mapRowToUser(rowSet);
        }
        return user;
    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();

        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPasswordHash(rs.getString("password_hash"));
        user.setRole(rs.getString("role"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setAddress(rs.getString("address"));
        user.setCity(rs.getString("city"));
        user.setStateCode(rs.getString("state_code"));
        user.setZip(rs.getString("zip"));
        return user;
    }
}
