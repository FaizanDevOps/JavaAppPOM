package org.qritrim.qivrtrack.model;

import java.util.Date;

import lombok.Data;

@Data
public class InfEmailThread {

	private String thread;
	private String fromId;
	private String toId;
	private boolean isUFav;
	private boolean isInfFav;
	private boolean isUSaved;
	private boolean isInfSaved;
	private boolean isURemainder;
	private boolean isInfRemainder;
	private boolean isURead;
	private boolean isInfRead;
	private Date uRemTime;
	private Date infRemTime;
	private int msgId;
	private Date time;
	private int threadId;
	private String property;
	private boolean isFav;
	private String sendMail;
	private String type;
	private String url;
	
	public String getSendMail() {
		return sendMail;
	}
	public void setSendMail(String sendMail) {
		this.sendMail = sendMail;
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
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public boolean getIsFav() {
		return isFav;
	}
	public void setIsFav(boolean isFav) {
		this.isFav = isFav;
	}
	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
	public String getThread() {
		return thread;
	}
	public void setThread(String thread) {
		this.thread = thread;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public boolean getIsUFav() {
		return isUFav;
	}
	public void setIsUFav(boolean isUFav) {
		this.isUFav = isUFav;
	}
	public boolean getIsInfFav() {
		return isInfFav;
	}
	public void setIsInfFav(boolean isInfFav) {
		this.isInfFav = isInfFav;
	}
	public boolean getIsUSaved() {
		return isUSaved;
	}
	public void setIsUSaved(boolean isUSaved) {
		this.isUSaved = isUSaved;
	}
	public boolean getIsInfSaved() {
		return isInfSaved;
	}
	public void setIsInfSaved(boolean isInfSaved) {
		this.isInfSaved = isInfSaved;
	}
	public boolean getIsURemainder() {
		return isURemainder;
	}
	public void setIsURemainder(boolean isURemainder) {
		this.isURemainder = isURemainder;
	}
	public boolean getIsInfRemainder() {
		return isInfRemainder;
	}
	public void setIsInfRemainder(boolean isInfRemainder) {
		this.isInfRemainder = isInfRemainder;
	}
	public boolean getIsURead() {
		return isURead;
	}
	public void setIsURead(boolean isURead) {
		this.isURead = isURead;
	}
	public boolean getIsInfRead() {
		return isInfRead;
	}
	public void setIsInfRead(boolean isInfRead) {
		this.isInfRead = isInfRead;
	}
	public Date getuRemTime() {
		return uRemTime;
	}
	public void setuRemTime(Date uRemTime) {
		this.uRemTime = uRemTime;
	}
	public Date getInfRemTime() {
		return infRemTime;
	}
	public void setInfRemTime(Date infRemTime) {
		this.infRemTime = infRemTime;
	}
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public void setURemTime(Object object) {
		// TODO Auto-generated method stub
		
	}
	
}
