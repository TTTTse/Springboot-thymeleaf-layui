package com.ttttse.dao;

import com.ttttse.entity.MyUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyUserInfoMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(MyUserInfo record);

    int insertSelective(MyUserInfo record);

    MyUserInfo selectByPrimaryKey(Integer userid);
    List<MyUserInfo>selectAllUser();
    MyUserInfo selectUserByUsername(String username);

    int updateByPrimaryKeySelective(MyUserInfo record);

    int updateByPrimaryKey(MyUserInfo record);
}