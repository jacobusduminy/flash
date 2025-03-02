package com.flash.regapp.rest.repository.mapper;

import com.flash.regapp.rest.repository.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoMapper implements RowMapper<UserDto> {
    @Override
    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDto user = new UserDto();
        user.setUsername(rs.getString("username"));
        user.setSurname(rs.getString("surname"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setPasswordResetCode(rs.getString("password_reset_code"));
        return user;
    }
}
