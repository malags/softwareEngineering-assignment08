package usi.inf.database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String address;
	
	@ManyToOne
	private User bestFriend;

	public User() {}
	
	public User(String name, String address, User bestFriend) {
		this.name = name;
		this.address = address;
		this.bestFriend = bestFriend;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getBestFriend() {
		return bestFriend;
	}

	public void setBest_friend_name(User best_friend_name) {
		this.bestFriend = best_friend_name;
	}
	
	@Override
	public String toString() {
		return "User(name: "+name + ", address: " + address + ", bestFriend: "+ bestFriend+")";
		
	}
	
	
}
