package usi.inf.database.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import usi.inf.database.model.User;
import usi.inf.database.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/update")
	public String updateUser(User user) {
		userRepository.delete(userRepository.findByName(user.getName()));
		userRepository.save(user);
		return "home";
	}
	
	@PostMapping("/delete")
	public String deleteUser(String userName) {
		userRepository.delete(userRepository.findByName(userName));
		return "home";
	}
	
	@PostMapping("/getUserByName")
	public @ResponseBody User getUserByName(String name) {
		System.out.println(name);
		if(name == null)
			return null;
		return userRepository.findByName(name);
	}
	
	//multiple users can have the same address
	@PostMapping("/getUserByAddress")
	public @ResponseBody List<User> getUserByAddress(String address) {
		System.out.println(address);
		if(address == null)
			return new ArrayList<>();
		return userRepository.findByAddress(address);
	}
	
	//multiple users can have the same best friend
	@PostMapping("/getUserByFriendName")
	public @ResponseBody List<User> getUserByFriendName(String name) {
		System.out.println(name);
		if(name == null)
			return new ArrayList<>();
		return userRepository.findByBestFriendName(name);
	}
	
	@PostMapping("/registration")
	public String createNewUser(@ModelAttribute("userForm") User user) {
		userRepository.save(user);
		System.out.println("created user: " + user.getName());
		return "login";
	} 
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}
	
	@GetMapping("/")
	public String t() {
		return "login";
	}
	
	@PostMapping("/addFriend")
	public String addFriend(HttpSession session, String friendName) {
		//
		System.out.println(session.getAttribute("user"));
		System.out.println(friendName);
		User friend = userRepository.findByName(friendName);
		User thisUser = (User) session.getAttribute("user");
		System.out.println(thisUser);
		thisUser.setBest_friend_name(friend);
		
		System.out.println("old user:" + thisUser);
		userRepository.save(thisUser);
		System.out.println("user changed to "+ thisUser);
		
		
		
		session.setAttribute("user", thisUser);
		return "home";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, User username) {

		User user = userRepository.findByName(username.getName());
		if(user == null)
			return "login";
		session.setAttribute("user", user);
		return "home";
	}

}
