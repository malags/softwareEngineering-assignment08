package usi.inf.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import usi.inf.database.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	User findByName(String name);
	
	List<User> findByBestFriendName(String name);
	
	List<User> findByAddress(String address);
}
