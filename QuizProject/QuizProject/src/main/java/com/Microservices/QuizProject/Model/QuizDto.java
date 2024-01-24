package com.Microservices.QuizProject.Model;

import lombok.Data;

@Data
public class QuizDto {

	String categoryName;
	Integer numQuations;
	String title;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getNumQuations() {
		return numQuations;
	}
	public void setNumQuations(Integer numQuations) {
		this.numQuations = numQuations;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public QuizDto(String categoryName, Integer numQuations, String title) {
		super();
		this.categoryName = categoryName;
		this.numQuations = numQuations;
		this.title = title;
	}
	
	
}
