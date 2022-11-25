package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class Networks {
	private int id;
	private String path;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	

}
