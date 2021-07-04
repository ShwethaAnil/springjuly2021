package com.training.daoimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.dao.PlayerDao;
import com.training.exceptions.BuissnesException;
import com.training.pojo.Player;

@Repository
public class PlayerDaoImpl implements PlayerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Player getPlayerById(int id)throws BuissnesException {
		return jdbcTemplate.queryForObject("select * from player where pid=?",  new BeanPropertyRowMapper<Player>(Player.class),id);
		
	}
	
	public List<Player> getPlayerByName(String name) {
		return jdbcTemplate.query("select * from player where name='"+name+"'", new BeanPropertyRowMapper<Player>(Player.class));
	}
	
	public List<Player> getPlayerByGender(String gender) {
		return jdbcTemplate.query("select * from player where gender='"+gender+"'", new BeanPropertyRowMapper<Player>(Player.class));
	}
	
	public Player getPlayerByContact(long contact) {
		return jdbcTemplate.queryForObject("select * from player where contact='"+contact+"'", new BeanPropertyRowMapper<Player>(Player.class));
	}
	
	public List<Player> getPlayerByTeamname(String teamname) {
		return jdbcTemplate.query("select * from player where teamname='"+teamname+"'", new BeanPropertyRowMapper<Player>(Player.class));
	}
	
	public List<Player> getPlayerByAge(int age) {
		return jdbcTemplate.query("select * from player where age='"+age+"'", new BeanPropertyRowMapper<Player>(Player.class));
	}
	
	public List<Player> getPlayerByDob(Date dob) throws BuissnesException {
		return jdbcTemplate.query("select * from player where dob='"+dob+"'", new BeanPropertyRowMapper<Player>(Player.class));
	}
	
	public List<Player> getPlayerByScore(int score) {
		return jdbcTemplate.query("select * from player where score='"+score+"'", new BeanPropertyRowMapper<Player>(Player.class));
	}
	
	public List<Player> getAllPlayers() {
		return jdbcTemplate.query("select * from player", new BeanPropertyRowMapper<Player>(Player.class));
	}
	
	public void addPlayer(Player p) {
		java.util.Date dob=p.getDob();
		java.sql.Date dob1=new java.sql.Date(dob.getTime());
		jdbcTemplate.update("insert into player values(?,?,?,?,?,?,?,?,?)",p.getPid(),p.getName(),p.getGender(),p.getContact(),p.getEmail(),
				p.getTeamname(),p.getAge(),dob1,p.getScore());
		
	}
	
	public int deletePlayer(int id) {
		return jdbcTemplate.update("delete from player where pid='"+id+"'");
	}
	
	public int updateScore(int id, long score) {
		return jdbcTemplate.update("update player set score='"+score+"' where pid='"+id+"'");
		
	}
	
	public Player getPlayerByEmail(String email) {
		return jdbcTemplate.queryForObject("select * from player where email='"+email+"'", new BeanPropertyRowMapper<Player>(Player.class));
	}
	
}
