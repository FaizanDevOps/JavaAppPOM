package org.qritrim.qivrtrack.model;

import lombok.*;

@Data
public class FeedsData {
	private int id;
	private String feedsId;
	private int influencerId;
	private int networkId;
	private String description;
	private String title;
	private String channelTitle;
	private String[] category;
	private String publishAt;
	private int viewCount;
	private int likeCount;
	private int dislikeCount;
	private int favoriteCount;
	private int commentCount;
	private String location;
	private String[] hashtags;
	private String[] mentions;
	private String type;
	private String displayUrl;
	private String videoUrl;
	private String isVideo;
	private int engagementRate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFeedsId() {
		return feedsId;
	}
	public void setFeedsId(String feedsId) {
		this.feedsId = feedsId;
	}
	public int getInfluencerId() {
		return influencerId;
	}
	public void setInfluencerId(int influencerId) {
		this.influencerId = influencerId;
	}
	public int getNetworkId() {
		return networkId;
	}
	public void setNetworkId(int networkId) {
		this.networkId = networkId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChannelTitle() {
		return channelTitle;
	}
	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}
	public String[] getCategory() {
		return category;
	}
	public void setCategory(String[] category) {
		this.category = category;
	}
	public String getPublishAt() {
		return publishAt;
	}
	public void setPublishAt(String publishAt) {
		this.publishAt = publishAt;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getDislikeCount() {
		return dislikeCount;
	}
	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}
	public int getFavoriteCount() {
		return favoriteCount;
	}
	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String[] getHashtags() {
		return hashtags;
	}
	public void setHashtags(String[] hashtags) {
		this.hashtags = hashtags;
	}
	public String[] getMentions() {
		return mentions;
	}
	public void setMentions(String[] mentions) {
		this.mentions = mentions;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDisplayUrl() {
		return displayUrl;
	}
	public void setDisplayUrl(String displayUrl) {
		this.displayUrl = displayUrl;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getIsVideo() {
		return isVideo;
	}
	public void setIsVideo(String isVideo) {
		this.isVideo = isVideo;
	}
	public int getEngagementRate() {
		return engagementRate;
	}
	public void setEngagementRate(int engagementRate) {
		this.engagementRate = engagementRate;
	}
	
	
	

}
