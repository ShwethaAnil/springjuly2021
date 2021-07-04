package com.training.controllers;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.training.bo.PlayerBO;
import com.training.exceptions.BuissnesException;
import com.training.exceptions.RecordNotFoundException;
import com.training.pojo.Player;

//@Controller//--retrun view
@CrossOrigin(value="*")
@RestController
public class PlayerController {
	
	@Autowired
	private PlayerBO playerBO;
	
	@RequestMapping(value = "/players", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPlayers() throws BuissnesException{
		return ResponseEntity.ok().body(playerBO.getAllPlayers());
	}
	
	@RequestMapping(value="/player/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)//pathvaribale
	public ResponseEntity<?> getMessage(@PathVariable("id")int id) throws BuissnesException, RecordNotFoundException {
		return ResponseEntity.ok().body(playerBO.getPlayerById(id));
	}
	
	@RequestMapping(value="/players/{gender}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)//pathvaribale
	public ResponseEntity<?> getByGender(@PathVariable("gender")String gender) throws BuissnesException, RecordNotFoundException {
		return ResponseEntity.ok().body(playerBO.getPlayersByGender(gender));
	}
	
	@RequestMapping(value="/player", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createPlayer(@RequestBody Player p) throws BuissnesException{
		final URI location=MvcUriComponentsBuilder.fromController(getClass())
						.path("/player/{id}")
						.buildAndExpand(p.getPid())
						.toUri();
		playerBO.addPlayer(p);
		return ResponseEntity.created(location).body(p);
	}
	@RequestMapping(value="/player/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)//pathvaribale
	public ResponseEntity<?> deletPlayer(@PathVariable("id")int id) throws BuissnesException, RecordNotFoundException {
		playerBO.deletePlayer(id);
		return ResponseEntity.ok().build();
	}


}
