package com.training.boimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.training.bo.PlayerBO;
import com.training.dao.PlayerDao;
import com.training.exceptions.BuissnesException;
import com.training.exceptions.RecordNotFoundException;
import com.training.pojo.Player;

@Service
public class PlayerBOImpl implements PlayerBO {
	
	@Autowired
	PlayerDao playerDao;
	
	
	
//	public void setPlayerDao(PlayerDao playerDao) {
//		this.playerDao = playerDao;
//	}

	public PlayerBOImpl() {
		//playerDao=new PlayerDaoImpl();
	}
	
	
	public Player getPlayerById(int id) throws BuissnesException,RecordNotFoundException {
		Player player = null;
		
		if (id > 1 && id < 16) {
			try {
			player = playerDao.getPlayerById(id);
			}catch(EmptyResultDataAccessException e) {
				throw new RecordNotFoundException("Requested Id not present");
			}
		} else {
			throw new BuissnesException("Entered ID is invalid");
		}
		return player;
	}

	
	public List<Player> getPlayersByGender(String gender) throws BuissnesException {
		List<Player> playerList = null;
		if (gender != null && gender.matches("[mMfF]{1}")) {
			// code for dao
			playerList = playerDao.getPlayerByGender(gender);
		} else {
			throw new BuissnesException("Enter gender " + gender + " is invalid [mMfF]");
		}
		return playerList;
	}

	
	public List<Player> getPlayersByAge(int age) throws BuissnesException {
		List<Player> playerList = null;
		// code for dao
		if (age > 16 && age < 48) {
			playerList = playerDao.getPlayerByAge(age);
		} else {
			throw new BuissnesException("Entered age " + age + " is invalid");
		}
		return playerList;
	}

	
	public Player getPlayerByEmail(String email) throws BuissnesException {
		Player player = null;
		if (email != null && email.matches(
				"[a-zA-Z0-9]{4,15}@gmail.com")) {
			player = playerDao.getPlayerByEmail(email);
		} else {
			throw new BuissnesException("Entered email " + email + " is invalid");
		}
		return player;
	}

	
	public Player getPlayerByNumber(Long contact) throws BuissnesException {
		Player player = null;
		if (contact >1L) {
			
			
			player = playerDao.getPlayerByContact(contact);
		} else {
			throw new BuissnesException("Entered number is invalid");
		}

		return player;
	}

	
	public List<Player> getPlayersByTeamname(String teamname) throws BuissnesException {
		List<Player> playerList = null;
		if (teamname != null && teamname.matches("[A-Z]{1,}")) {
			
			playerList = playerDao.getPlayerByTeamname(teamname);
		} else {
			throw new BuissnesException("Entered Teamname " + teamname + " is invalid");
		}
		return playerList;
	}

	
	public List<Player> getPlayersByName(String name) throws BuissnesException {
		List<Player> playerList = null;
		if (name != null && name.matches("[a-zA-Z]{3,10}")) {
			
			playerList = playerDao.getPlayerByName(name);
		} else {
			throw new BuissnesException("Entered Name " + name + " is invalid");
		}
		return playerList;
	}

	
	public List<Player> getPlayersByDob(Date dob) throws BuissnesException {
		List<Player> playerList = null;
		if (dob != null) {
			playerList = playerDao.getPlayerByDob(dob);
		} else {
			throw new BuissnesException("Entered Name " + dob + " is invalid");
		}
		return playerList;
	}
	
	
	public void addPlayer(Player p)throws BuissnesException {
		if((p.getPid() >1)  &&  (p.getPid()< 16) ){
			if(p.getName().matches("[A-Za-z]{3,10}")) {
				if(p.getGender().matches("[MmFf]{1}")) {
					if(p.getContact()> 1L) {
						if(p.getEmail().matches("[a-zA-Z0-9]{4,15}@gmail.com")) {
							playerDao.addPlayer(p);
						}else {
							throw new BuissnesException("Invalid email");
						}
					}else {
						throw new BuissnesException("Invalid contact");
					}
				}else {
					throw new BuissnesException("Invalid gender");
				}
				
			}else {
				throw new BuissnesException("Invalid name");
			}
		}else {
			throw new BuissnesException("Id is invalid");
		}
		
	
	}

//	
//	public void addPlayer(Player p)throws BuissnesException {
//		if(((p.getPid() >1)  &&  (p.getPid()< 16) )
//		&& (p.getName().matches("[A-Za-z]{3,10}")) &&
//			(p.getGender().matches("[MmFf]{1}")) &&
//			(p.getContact()> 1L)&& 
//	(p.getEmail().matches("[a-zA-Z0-9]{4,15}@gmail.com"))
//			&& (p.getTeamname().matches("[A-Z]{1,}"))
//			&& ((p.getAge()> 16) && (p.getAge()<42))
//			&& (p.getDob()!=null)) {
//		playerDao.addPlayer(p);
//		}else {
//			throw new BuissnesException("Problem with input");
//		}
//	}

	
	public int deletePlayer(int id) {
		return playerDao.deletePlayer(id);
	}

	
	public int updateScore(int id, long score) {
		
		return playerDao.updateScore(id, score);
	}

	
	public List<Player> getAllPlayers() throws BuissnesException {
		
		return playerDao.getAllPlayers();
	}

}
