package com.telego.model.status;

public enum STATUS {
	SUCCESS(1), FAILED(2);

	private Integer id;

	private STATUS(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

}
