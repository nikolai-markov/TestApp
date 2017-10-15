package com.musala.task.model;

public class TomatoOrder {
	
	private String id;
	private int tomatoes;
	private String provider;
	private Long timestamp;
	
	public TomatoOrder() {
		
	}
	
	public TomatoOrder(String id, int tomatoes, String provider, Long timestamp) {
		super();
		this.id = id;
		this.tomatoes = tomatoes;
		this.provider = provider;
		this.timestamp = timestamp;
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
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
}
