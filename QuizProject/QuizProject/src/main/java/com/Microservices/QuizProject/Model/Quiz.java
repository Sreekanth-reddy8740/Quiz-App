package com.Microservices.QuizProject.Model;

import java.util.List;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@ElementCollection
	private List<Integer> quations;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Integer> getQuations() {
		return quations;
	}

	public void setQuations(List<Integer> quations) {
		this.quations = quations;
	}

	public Quiz(Integer id, String title, List<Integer> quations) {
		super();
		this.id = id;
		this.title = title;
		this.quations = quations;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
