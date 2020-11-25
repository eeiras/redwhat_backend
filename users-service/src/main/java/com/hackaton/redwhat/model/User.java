package com.hackaton.redwhat.model;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;


@MongoEntity(collection = "users")
public class User extends PanacheMongoEntity {

	private String userId;
	
	private int points;
	
	private int level;
	
	//private List<Content> viewedContents;
	
	private int age;

	public String getUserId() {
		return userId;
	}
	
	// entity methods
    public static User findByUserId(String userId) {
        return find("userId", userId).firstResult();
    }
    
    public static void deleteByUserId(String userId) {
        delete("userId", userId);
    }

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	//public List<Content> getViewedContents() {
	//	return viewedContents;
	//}

	//public void setViewedContents(List<Content> viewedContents) {
	//	this.viewedContents = viewedContents;
	//}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", points=" + points + ", level=" + level + ", viewedContents="
				//+ viewedContents 
				+ ", age=" + age + "]";
	}

}
