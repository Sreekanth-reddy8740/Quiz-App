package com.Microservices.QuizProject.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Microservices.QuizProject.Dao.QuizDao;
import com.Microservices.QuizProject.Feign.QuizInterface;
import com.Microservices.QuizProject.Model.QuationWrapper;
import com.Microservices.QuizProject.Model.Quiz;
import com.Microservices.QuizProject.Model.Responce;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Integer> quations= quizInterface.getQuationForQuiz(category,numQ).getBody();
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuations(quations);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}

	public ResponseEntity<List<QuationWrapper>> getQuizQuations(Integer id) {
		
		Quiz quiz=quizDao.findById(id).get(); 
		List<Integer> quations=quiz.getQuations();
		ResponseEntity<List<QuationWrapper>> quations1=quizInterface.getQuationsFromId(quations);
		return quations1;
		
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Responce> responces) {
		
		ResponseEntity<Integer> score = quizInterface.getScore(responces);
		return score;		
	}
	
	
}
