package com.at.cache.mapper;

import com.at.cache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id=#{id}")
    Department getDepartmentById(Integer id);
}
