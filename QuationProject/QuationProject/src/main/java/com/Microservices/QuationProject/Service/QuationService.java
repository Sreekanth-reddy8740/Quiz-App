package com.Microservices.QuationProject.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Microservices.QuationProject.Dao.QuationDao;
import com.Microservices.QuationProject.Model.Quation;
import com.Microservices.QuationProject.Model.QuationWrapper;
import com.Microservices.QuationProject.Model.Responce;

@Service
public class QuationService {

	@Autowired
	QuationDao quationDao;
	
	public ResponseEntity<Quation> addQuation(Quation quation){
		return new ResponseEntity<>(quationDao.save(quation),HttpStatus.CREATED);
		 
	}

	public ResponseEntity<List<Quation>> getAllQuations() {
		try {
			return new ResponseEntity<>(quationDao.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<List<Quation>> getQuationsBycategory(String category) {
		try {
			return new ResponseEntity<>(quationDao.findByCategory(category),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<List<Integer>> getQuationsForQuiz(String categoryName, Integer numQuations) {
		
		List<Integer> quations=quationDao.findRandomQuestionsByCategory(categoryName,numQuations);
		return new ResponseEntity<>(quations,HttpStatus.OK);
	}

	public ResponseEntity<List<QuationWrapper>> getQuationsFromId(List<Integer> quationIds) {
		
		List<QuationWrapper> wrappers=new ArrayList<>();
		List<Quation> quations=new ArrayList<>();
		
		for(Integer id : quationIds) {
			quations.add(quationDao.findById(id).get());
		}
		
		for(Quation quation : quations) {
			QuationWrapper wrapper = new QuationWrapper();
			wrapper.setId(quation.getId());
			wrapper.setQuationTitle(quation.getQuationTitle());
			wrapper.setOption1(quation.getOption1());
			wrapper.setOption2(quation.getOption2());
			wrapper.setOption3(quation.getOption3());
			wrapper.setOption4(quation.getOption4());
			wrappers.add(wrapper);
		}
		return new ResponseEntity<>(wrappers,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Responce> responces) {
		int right =0;
		
		for(Responce responce :responces) {
			Quation quation = quationDao.findById(responce.getId()).get();
			if(responce.getResponce().equals(quation.getRightAnswer()))
				right++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
}





