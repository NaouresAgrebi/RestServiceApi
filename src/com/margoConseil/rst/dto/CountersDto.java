package com.margoConseil.rst.dto;

public class CountersDto {

	private int visitedCounter;
	private int unVisitedCounter;

	public CountersDto() {
		super();
	}

	public CountersDto(int visitedCounter, int unVisitedCounter) {
		super();
		this.visitedCounter = visitedCounter;
		this.unVisitedCounter = unVisitedCounter;
	}

	public int getVisitedCounter() {
		return visitedCounter;
	}

	public void setVisitedCounter(int visitedCounter) {
		this.visitedCounter = visitedCounter;
	}

	public int getUnVisitedCounter() {
		return unVisitedCounter;
	}

	public void setUnVisitedCounter(int unVisitedCounter) {
		this.unVisitedCounter = unVisitedCounter;
	}

	@Override
	public String toString() {
		return "CountersDto [visitedCounter=" + visitedCounter + ", unVisitedCounter=" + unVisitedCounter + "]";
	}

}
