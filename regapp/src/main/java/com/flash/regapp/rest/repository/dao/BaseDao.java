package com.flash.regapp.rest.repository.dao;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

@NoRepositoryBean
public class BaseDao extends JdbcDaoSupport {

    public BaseDao(DataSource dataSource) {
        setDataSource(dataSource);
    }

}
