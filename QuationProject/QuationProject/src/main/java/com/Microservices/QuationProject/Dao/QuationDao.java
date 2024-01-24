package com.Microservices.QuationProject.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Microservices.QuationProject.Model.Quation;

@Repository
public interface QuationDao extends JpaRepository<Quation, Integer> {

	List<Quation>findByCategory(String category);

	//@Query(value = "SELECT q.id FROM question q Where q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	@Query(value = "SELECT q.id FROM quation q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
