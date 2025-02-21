package com.springmvc.assessment.beans;

public class Course
{
	private int id;
	private String name;
	private int duration;
	/**
	 * 
	 */
	public Course() {
	}
	/**
	 * @param id
	 * @param name
	 * @param duration
	 */
	public Course(int id, String name, int duration) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
}