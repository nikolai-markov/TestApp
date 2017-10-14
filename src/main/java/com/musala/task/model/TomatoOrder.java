package com.musala.task.model;

public class TomatoOrder {
	
	private String id;
	private int tomatoes;
	private String provider;
	private Long date;
	
	public TomatoOrder() {
		
	}
	
	public TomatoOrder(String id, int tomatoes, String provider, Long date) {
		super();
		this.id = id;
		this.tomatoes = tomatoes;
		this.provider = provider;
		this.date = date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTomatoes() {
		return tomatoes;
	}
	public void setTomatoes(int tomatoes) {
		this.tomatoes = tomatoes;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	
}
