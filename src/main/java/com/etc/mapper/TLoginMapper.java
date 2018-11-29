package com.etc.mapper;

import com.etc.domain.TLogin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TLoginMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TLogin record);

    TLogin selectByPrimaryKey(Long id);

    List<TLogin> selectAll();

    int updateByPrimaryKey(TLogin record);

    TLogin checkLogin(TLogin login);
}