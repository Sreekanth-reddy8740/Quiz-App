package com.Microservices.QuizProject.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Microservices.QuizProject.Model.QuationWrapper;
import com.Microservices.QuizProject.Model.QuizDto;
import com.Microservices.QuizProject.Model.Responce;
import com.Microservices.QuizProject.Service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizservice;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
		return quizservice.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuations(),quizDto.getTitle());
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuationWrapper>> getQuizQuations(@PathVariable Integer id){
		return quizservice.getQuizQuations(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Responce> responces){
		return quizservice.calculateResult(id,responces);
		
	}
	
}
