package com.bway.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bway.springdemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	   //Spring Data JPA convention
	  User   findByUserNameAndPassword(String un, String psw);
	  
	  //SQL Native
	  @Query(value = "select * from user_tbl  where user_name = :un and password = :psw ", nativeQuery = true)
	  User isExist(@Param("un") String un, @Param("psw") String psw);
	  
	  //HQL
	  @Query("FROM User where userName = :un and password = :psw")
	  User findUser(String un, String psw);
}
