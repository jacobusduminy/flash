package com.flash.regapp.rest.repository.dao;

import com.flash.regapp.config.LookupDataException;
import com.flash.regapp.rest.repository.dto.UserDto;
import com.flash.regapp.rest.repository.entity.User;
import com.flash.regapp.rest.repository.mapper.UserDaoMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDao extends BaseDao {

    public UserDao(DataSource dataSource) {
        super(dataSource);
    }

    public UserDto getUserDao(String email, String passwordResetCode) {
        try {
            assert getJdbcTemplate() != null;
            UserDto userReturn = getJdbcTemplate().queryForObject("select user_id,username ,surname,email,password,password_reset_code from regapp_database.user where email = ? and password_reset_code = ?", new UserDaoMapper(), email, passwordResetCode);
            return userReturn;
        } catch (EmptyResultDataAccessException e) {
            throw new LookupDataException("Email and ResetCode not found", e);
        }
    }
}
