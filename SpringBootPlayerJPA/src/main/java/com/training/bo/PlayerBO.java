package com.training.bo;



import java.util.Date;
import java.util.List;

import com.training.exceptions.BuissnesException;
import com.training.exceptions.RecordNotFoundException;
import com.training.pojo.Player;



public interface PlayerBO {
	public Player getPlayerById(int id) throws BuissnesException,RecordNotFoundException;
	public List<Player> getPlayersByGender(String gender) throws BuissnesException;
	public List<Player> getPlayersByAge(int age) throws BuissnesException;
	public Player getPlayerByEmail(String email) throws BuissnesException;
	public Player getPlayerByNumber(Long contact) throws BuissnesException;
	public List<Player> getPlayersByTeamname(String teamname) throws BuissnesException;
	public List<Player> getPlayersByName(String name) throws BuissnesException;
	public List<Player> getPlayersByDob(String dob) throws BuissnesException;
	public void addPlayer(Player p)throws BuissnesException;
	public void deletePlayer(int id);
	public void updateScore(int id, long score);
	public List<Player> getAllPlayers()throws BuissnesException;
	

}
