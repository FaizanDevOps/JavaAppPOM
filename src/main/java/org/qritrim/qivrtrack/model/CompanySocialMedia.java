package org.qritrim.qivrtrack.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class CompanySocialMedia {
	private int companyId;
	private ArrayList<String> youtube;
	private ArrayList<String> instagram;
	private ArrayList<String> tiktok;
	private ArrayList<String> facebook;
	private ArrayList<String> twitter;
	private ArrayList<String> line;
	private ArrayList<String> pinterest;
	private ArrayList<String> snapchat;
	private ArrayList<String> reddit;
	private ArrayList<String> qq;
	
	private int youtubeCount;
	private int instagramCount;
	private int tiktokCount;
	private int facebookCount;
	private int twitterCount;
	private int lineCount;
	private int pinterestCount;
	private int snapchatCount;
	private int redditCount;
	private int qqCount;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public ArrayList<String> getYoutube() {
		return youtube;
	}
	public void setYoutube(ArrayList<String> youtube) {
		this.youtube = youtube;
	}
	public ArrayList<String> getInstagram() {
		return instagram;
	}
	public void setInstagram(ArrayList<String> instagram) {
		this.instagram = instagram;
	}
	public ArrayList<String> getTiktok() {
		return tiktok;
	}
	public void setTiktok(ArrayList<String> tiktok) {
		this.tiktok = tiktok;
	}
	public ArrayList<String> getFacebook() {
		return facebook;
	}
	public void setFacebook(ArrayList<String> facebook) {
		this.facebook = facebook;
	}
	public ArrayList<String> getTwitter() {
		return twitter;
	}
	public void setTwitter(ArrayList<String> twitter) {
		this.twitter = twitter;
	}
	public ArrayList<String> getLine() {
		return line;
	}
	public void setLine(ArrayList<String> line) {
		this.line = line;
	}
	public ArrayList<String> getPinterest() {
		return pinterest;
	}
	public void setPinterest(ArrayList<String> pinterest) {
		this.pinterest = pinterest;
	}
	public ArrayList<String> getSnapchat() {
		return snapchat;
	}
	public void setSnapchat(ArrayList<String> snapchat) {
		this.snapchat = snapchat;
	}
	public ArrayList<String> getReddit() {
		return reddit;
	}
	public void setReddit(ArrayList<String> reddit) {
		this.reddit = reddit;
	}
	public ArrayList<String> getQq() {
		return qq;
	}
	public void setQq(ArrayList<String> qq) {
		this.qq = qq;
	}
	public int getYoutubeCount() {
		return youtubeCount;
	}
	public void setYoutubeCount(int youtubeCount) {
		this.youtubeCount = youtubeCount;
	}
	public int getInstagramCount() {
		return instagramCount;
	}
	public void setInstagramCount(int instagramCount) {
		this.instagramCount = instagramCount;
	}
	public int getTiktokCount() {
		return tiktokCount;
	}
	public void setTiktokCount(int tiktokCount) {
		this.tiktokCount = tiktokCount;
	}
	public int getFacebookCount() {
		return facebookCount;
	}
	public void setFacebookCount(int facebookCount) {
		this.facebookCount = facebookCount;
	}
	public int getTwitterCount() {
		return twitterCount;
	}
	public void setTwitterCount(int twitterCount) {
		this.twitterCount = twitterCount;
	}
	public int getLineCount() {
		return lineCount;
	}
	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}
	public int getPinterestCount() {
		return pinterestCount;
	}
	public void setPinterestCount(int pinterestCount) {
		this.pinterestCount = pinterestCount;
	}
	public int getSnapchatCount() {
		return snapchatCount;
	}
	public void setSnapchatCount(int snapchatCount) {
		this.snapchatCount = snapchatCount;
	}
	public int getRedditCount() {
		return redditCount;
	}
	public void setRedditCount(int redditCount) {
		this.redditCount = redditCount;
	}
	public int getQqCount() {
		return qqCount;
	}
	public void setQqCount(int qqCount) {
		this.qqCount = qqCount;
	}
	
}
