package com.training;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.bo.PlayerBO;
import com.training.boimpl.PlayerBOImpl;
import com.training.config.AppConfig;
import com.training.exceptions.BuissnesException;
import com.training.pojo.Player;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException, BuissnesException
    {
    	
    	System.out.println("started");
    	ApplicationContext context=
    			//new ClassPathXmlApplicationContext("beans.xml");
    			new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	System.out.println("Welcome to player app");
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println();	
		System.out.println("1.getPlayerById\r\n" + 
				"2.getPlayerByName\r\n" + 
				"3.getPlayerByGender\r\n" + 
				"4.getPlayerByContact\r\n" + 
				"5.getPlayerByTeamname\r\n" + 
				"6.getPlayerByAge\r\n" + 
				"7.getPlayerByDob\r\n" + 
				"8.getPlayerByScore\r\n" + 
				"9.getAllPlayers\r\n" + 
				"10.addPlayer\r\n" + 
				"11.deletePlayer\r\n" + 
				"12.updateScore\r\n" + 
				"13.Exit");
		PlayerBO playerDao=(PlayerBO) context.getBean(PlayerBOImpl.class);
		int choice=sc.nextInt();
	switch(choice) {
	case 1:System.out.println("enter the id ");
		Player p=playerDao.getPlayerById(sc.nextInt());
		System.out.println(p);
		break;
	case 2:System.out.println("enter the name");
	List<Player> players=playerDao.getPlayersByName(sc.next());
	players.forEach((p1)->System.out.println(p1));
	break;
	case 3:System.out.println("enter the gender");
	List<Player> players1=playerDao.getPlayersByGender(sc.next());
	players1.forEach((p1)->System.out.println(p1));
	break;
	case 4:System.out.println("enter the contact");
	Player player2=playerDao.getPlayerByNumber(sc.nextLong());
	System.out.println(player2);
	break;
	case 5:System.out.println("enter the TeamName");
	List<Player> players3=playerDao.getPlayersByTeamname(sc.next());
	players3.forEach((p1)->System.out.println(p1));
	break;
	case 6:System.out.println("enter the age");
	List<Player> players4=playerDao.getPlayersByAge(sc.nextInt());
	players4.forEach((p1)->System.out.println(p1));
	break;
	case 7:System.out.println("enter the dob(dd-MMM-yyyy)");
	String dob=sc.next();
	Date d=new SimpleDateFormat("dd-MMM-yyyy").parse(dob);
	List<Player> players5=playerDao.getPlayersByDob(d);
	players5.forEach((p1)->System.out.println(p1));
	break;
	case 8:System.out.println("enter the score");
	List<Player> players6=playerDao.getPlayersByAge(sc.nextInt());
	players6.forEach((p1)->System.out.println(p1));
	break;
	case 9:System.out.println("list of players");
	List<Player> players7=playerDao.getAllPlayers();
	players7.forEach((p1)->System.out.println(p1));
	break;
	case 10:System.out.println("enter the player details to add");
	Player newPlayer=new Player();
	System.out.println("pid");
	newPlayer.setPid(sc.nextInt());
	System.out.println("name");
	newPlayer.setName(sc.next());
	System.out.println("gender");
	newPlayer.setGender(sc.next());
	System.out.println("phone number");
	newPlayer.setContact(sc.nextLong());
	System.out.println("emails");
	newPlayer.setEmail(sc.next());
	System.out.println("team name");
	newPlayer.setTeamname(sc.next());
	System.out.println("age");
	newPlayer.setAge(sc.nextInt());
	System.out.println("date  dd-MMM-yyyy");
	String dob1=sc.next();
	Date d1=new SimpleDateFormat("dd-MMM-yyyy").parse(dob1);
	
	newPlayer.setDob(d1);
	System.out.println("score");
	newPlayer.setScore(sc.nextLong());
	playerDao.addPlayer(newPlayer);
	break;
	case 11:System.out.println("enter id to delte");
	playerDao.deletePlayer(sc.nextInt());
	break;
	case 12:System.out.println("update the score by id");
	playerDao.updateScore(sc.nextInt(), sc.nextLong());
	break;
	case 13: System.out.println("bye bye");
	sc.close();
		System.exit(0);
	}
	
	}while(true);
	}
    
}
