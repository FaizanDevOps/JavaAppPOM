package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class QivrRequestEntity<T> implements Cloneable{
	
	private T body;
	
	//private User loggedUser;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
	
}

