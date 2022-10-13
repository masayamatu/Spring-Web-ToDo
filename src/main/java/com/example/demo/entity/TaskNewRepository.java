package com.example.demo.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskNewRepository extends JpaRepository<TaskNew, Integer> {
	@Query("SELECT t FROM TaskNew WHERE t.username = :userName")
	List<TaskNew> findByUserName(@Param("userName") String userName);
}
