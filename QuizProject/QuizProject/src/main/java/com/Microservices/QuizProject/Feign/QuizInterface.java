package com.Microservices.QuizProject.Feign;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.Microservices.QuizProject.Model.QuationWrapper;
import com.Microservices.QuizProject.Model.Responce;

@FeignClient("QUATIONPROJECT")
public interface QuizInterface {

	@GetMapping("quation/genarate")
	public ResponseEntity<List<Integer>> getQuationForQuiz
					(@RequestParam String categoryName,@RequestParam Integer numQuations);
	
	@PostMapping("quation/getQuations")
	public ResponseEntity<List<QuationWrapper>> getQuationsFromId(@RequestBody List<Integer> quationIds);
	
	@PostMapping("quation/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Responce> responces);
	
}
