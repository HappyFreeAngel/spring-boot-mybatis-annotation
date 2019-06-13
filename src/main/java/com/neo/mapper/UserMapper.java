package com.neo.mapper;

import java.util.List;

import com.neo.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neo.enums.UserSexEnum;

public interface UserMapper {
	
	@Select("SELECT * FROM user")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name")
	})
	List<User> getAll();
	
	@Select("SELECT * FROM user WHERE id = #{id}")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name"),
			@Result(property = "userName", column = "user_name")
	})
	User getOne(Long id);

	@Insert("INSERT INTO user(user_name,password,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
	void insert(User user);

	@Update("UPDATE user SET user_name=#{userName},nick_name=#{nickName} WHERE id =#{id}")
	void update(User user);

	@Delete("DELETE FROM user WHERE id =#{id}")
	void delete(Long id);

	@Update(" ")
	void createTable(String createSQL);
}