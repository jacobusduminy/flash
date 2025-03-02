package com.flash.regapp.rest.repository;

import com.flash.regapp.rest.repository.entity.User;
import com.flash.regapp.util.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    User findByEmail(String email);

}
