package com.hhawking.excel.demo.dao;

import com.hhawking.excel.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<User> getUserList();
}
