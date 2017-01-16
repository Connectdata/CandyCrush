package controller.api;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import configuration.InfoProject;
import helper.DateHelper;
import model.mapping.BestScore;
import model.mapping.Player;
import model.mapping.Session;
import model.service.ClassicalService;
import model.service.GameService;
import model.service.PlayerService;

@Controller
public class ActionPlayer
{
	@Autowired
	PlayerService playerService;
	@Autowired
	GameService gameService;
	@Autowired
	ClassicalService classicalService;
	
	@RequestMapping(value=API.PLAYER,method=RequestMethod.POST)
	public @ResponseBody ResponseEntity createUser(@RequestParam(required=true)String nom,@RequestParam(required=false)String prenom,@RequestParam(required=false)String email,@RequestParam(required=false)String telephone,@RequestParam(required=false)String login,@RequestParam(required=false)String password,@RequestParam(required=false)String idfacebook) 
	{
		Player tmpPlayer = new Player();
		
		
		
		
		
		
		tmpPlayer.setNom(nom);
		if(prenom!=null)
		{
			tmpPlayer.setPrenom(prenom);
		}
		if(email !=null)
		{
			tmpPlayer.setEmail(email);
		}
		if(telephone!=null)
		{
			tmpPlayer.setTelephone(telephone);
		}
		if(login!=null)
		{
			tmpPlayer.setLogin(login);
		}
		else
		{
			tmpPlayer.setLogin(tmpPlayer.getNom());
		}
		if(password!=null)
		{
			tmpPlayer.setPassword(password);
		}
		else
		{
			tmpPlayer.setPassword(InfoProject.USER_DEFAULT_PASSWORD);
		}
		
		if(idfacebook!= null)
		{
			tmpPlayer.setIdFacebook(idfacebook);
		}
		
		tmpPlayer.setPoint(0);
		
		int status = playerService.savePlayer(tmpPlayer);
				
		if(status>=1)
		{
			tmpPlayer = playerService.getPlayer(tmpPlayer).get(0);
			return new ResponseEntity<Player>(tmpPlayer,HttpStatus.CREATED);
			
		}
		else
		{
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}
		
		
	}
	
	
	
	
	@RequestMapping(value=API.PLAYER_EDIT,method=RequestMethod.POST)
	public @ResponseBody ResponseEntity editUser(@RequestParam(required=true)Long idplayer,@RequestParam(required=false)String nom,@RequestParam(required=false)String prenom,@RequestParam(required=false)String email,@RequestParam(required=false)String telephone,@RequestParam(required=false)String login,@RequestParam(required=false)String password,@RequestParam(required=false)String idfacebook) 
	{
		Player tmpPlayer = new Player();
		
		
		tmpPlayer.setIdPlayer(idplayer);
		
		
		tmpPlayer = playerService.getPlayer(tmpPlayer).get(0);
		
		
		if(nom !=null)
		{
			tmpPlayer.setNom(nom);
		}
		
		
		
		if(prenom!=null)
		{
			tmpPlayer.setPrenom(prenom);
		}
		
		
		if(email !=null)
		{
			tmpPlayer.setEmail(email);
		}
		
		
		
		if(telephone!=null)
		{
			tmpPlayer.setTelephone(telephone);
		}
		
		
		
		if(login!=null)
		{
			tmpPlayer.setLogin(login);
		}
		
		
		if(password!=null)
		{
			tmpPlayer.setPassword(password);
		}
		
		
		
		if(idfacebook!= null)
		{
			tmpPlayer.setIdFacebook(idfacebook);
		}
		
		int status = classicalService.update(tmpPlayer);
				
		if(status>=1)
		{
			tmpPlayer = playerService.getPlayer(tmpPlayer).get(0);
			return new ResponseEntity<Player>(tmpPlayer,HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}
		
		
	}
	
	
	@RequestMapping(value=API.PLAYER_LIST)
	public @ResponseBody ResponseEntity allUser()
	{
		Player tmpPlayer = new Player();
		
		
		List<Player> resp = null;
		
		
	
		resp = playerService.getPlayer(tmpPlayer);
		
		if(resp!=null)
		{
			return new ResponseEntity<List<Player>>(resp,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}
		
		
		
	}
	
	
	@RequestMapping(value=API.PLAYERS_BEST_SCORE)
	public @ResponseBody ResponseEntity<LeaderBoardScore> BestUser(@RequestParam(required = true)Long idplayer,@RequestParam(required = false)Integer limit)
	{
		
		if(limit == null)
		{
			limit = -1;
		}
		
		List<BestScore> resp = playerService.getTopBestPlayer(limit);
		BestScore pBS = playerService.getPlayerBestScore(idplayer);
		
		LeaderBoardScore leaderboard = new LeaderBoardScore(resp, pBS);
		return new ResponseEntity<LeaderBoardScore>(leaderboard,HttpStatus.OK);
		
		
		
	}
	
	
	
	public class LeaderBoardScore
	{
		private List<BestScore> topPlayers;
		private BestScore player;
		public List<BestScore> getTopPlayers() {
			return topPlayers;
		}
		public void setTopPlayers(List<BestScore> topPlayers) {
			this.topPlayers = topPlayers;
		}
		public BestScore getPlayer() {
			return player;
		}
		public void setPlayer(BestScore player) {
			this.player = player;
		}
		public LeaderBoardScore(List<BestScore> topPlayers, BestScore player) {
			super();
			this.topPlayers = topPlayers;
			this.player = player;
		}
		@Override
		public String toString() {
			return "LeaderBoardScore [topPlayers=" + topPlayers + ", players=" + player + "]";
		}
		
		
		
		
	}
	
	
	
	@RequestMapping(value=API.PLAYER_SESSION,method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Player> createSession(@RequestParam(required=true)Long idplayer,@RequestParam(required=true)String date,@RequestParam(required=true)Integer score) 
	{
		
		
		
		System.out.println("DATE : "+date);
		
		Session session =  new Session();
		try {
			session.setDate(DateHelper.getDate(date));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		session.setIdPlayer(idplayer);
		session.setScore(score);
		
		
		System.out.println("Session : "+session.toString());
		
		
		int ret =  gameService.saveSession(session);
		
		
		if(ret == 1)
		{
		
			Player p = playerService.addPlayerPoint(idplayer, score);
			return new ResponseEntity<Player>(p,HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
		
		
	}
	
	
}
