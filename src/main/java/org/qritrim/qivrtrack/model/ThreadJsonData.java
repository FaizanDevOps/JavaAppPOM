package org.qritrim.qivrtrack.model;

import com.google.api.client.json.Json;
import lombok.Data;

@Data
public class ThreadJsonData {

	private Object threadData;
	private String sendMail;
	
	private Json thread;
	private int threadId;
	private String type;
	private String url;
//	public Json[] getThreadData() {
//		return threadData;
//	}
//	public void setThreadData(Json[] threadData) {
//		this.threadData = threadData;
//	}
	public String getSendMail() {
		return sendMail;
	}
	public void setSendMail(String sendMail) {
		this.sendMail = sendMail;
	}
	public Json getThread() {
		return thread;
	}
	public void setThread(Json thread) {
		this.thread = thread;
	}
	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Object getThreadData() {
		return threadData;
	}
	public void setThreadData(Object threadData) {
		this.threadData = threadData;
	}
	
	
}
