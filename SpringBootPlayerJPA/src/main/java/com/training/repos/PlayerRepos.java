package com.training.repos;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.pojo.Player;

@Repository
public interface PlayerRepos extends CrudRepository<Player, Integer>{
	
	public List<Player> findByGender(String gender);
	public List<Player> findByName(String name);
	public List<Player> findByAge(int age);
	public Player findByContact(long contact);
	public Player findByEmail(String email);
	public List<Player> findByTeamname(String teamname);
	public List<Player> findByDob(String dob);
	//@Query(value = "", nativeQuery = true)
	public Player findByGenderAndContact(String gender,long contact);
	
	

}
