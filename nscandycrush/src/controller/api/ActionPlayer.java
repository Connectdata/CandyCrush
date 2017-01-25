package controller.api;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import model.mapping.PlayerBonus;
import model.mapping.PlayerBonusFull;
import model.mapping.PlayerRankGame;
import model.mapping.Session;
import model.service.BonusService;
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
	@Autowired
	BonusService bonusService;
	
	@RequestMapping(value=API.PLAYER,method=RequestMethod.POST)
	public @ResponseBody ResponseEntity createUser(@RequestParam(required=true)String nom,@RequestParam(required=false)String prenom,@RequestParam(required=false)String email,@RequestParam(required=false)String telephone,@RequestParam(required=false)String login,@RequestParam(required=false)String password,@RequestParam(required=false)String idfacebook) 
	{
		Player tmpPlayer = new Player();
		
		
		
		
		
		
		tmpPlayer.setNom(nom);
		if(prenom!=null && prenom != "")
		{
			tmpPlayer.setPrenom(prenom);
		}
		if(email !=null && email != "")
		{
			tmpPlayer.setEmail(email);
		}
		if(telephone!=null && telephone != "")
		{
			tmpPlayer.setTelephone(telephone);
		}
		if(login!=null && login != "")
		{
			tmpPlayer.setLogin(login);
		}
		else
		{
			tmpPlayer.setLogin(tmpPlayer.getNom());
		}
		if(password!=null && password != "")
		{
			tmpPlayer.setPassword(password);
		}
		else
		{
			tmpPlayer.setPassword(InfoProject.USER_DEFAULT_PASSWORD);
		}
		
		if(idfacebook!= null && idfacebook != "")
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
		
		
		if(nom !=null && nom != "")
		{
			tmpPlayer.setNom(nom);
		}
		
		
		
		if(prenom!=null && prenom != "")
		{
			tmpPlayer.setPrenom(prenom);
		}
		
		
		if(email !=null &&  email!= "")
		{
			tmpPlayer.setEmail(email);
		}
		
		
		
		if(telephone!=null&& telephone!= "")
		{
			tmpPlayer.setTelephone(telephone);
		}
		
		
		
		if(login!=null && login != "")
		{
			tmpPlayer.setLogin(login);
		}
		
		
		if(password!=null && password != "")
		{
			tmpPlayer.setPassword(password);
		}
		
		
		
		if(idfacebook!= null && idfacebook != "")
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
	public @ResponseBody ResponseEntity<LeaderBoardScore> BestUser(@RequestParam(required = true)Long idplayer,@RequestParam(required = true)Long idgametype,@RequestParam(required = false)Integer limit)
	{
		
		if(limit == null)
		{
			limit = -1;
		}
		
		List<PlayerRankGame> resp = playerService.getTopBestPlayer(limit,idgametype);
		PlayerRankGame pBS = playerService.getPlayerBestScoreInSpecificGame(idplayer,idgametype);
		
		LeaderBoardScore leaderboard = new LeaderBoardScore(resp, pBS);
		return new ResponseEntity<LeaderBoardScore>(leaderboard,HttpStatus.OK);
		
		
		
	}
	
		
	
	@RequestMapping(value=API.PLAYER_SESSION,method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Player> createSession(@RequestParam(required=true)Long idplayer,@RequestParam(required=true)Integer score) 
	{
		
		
		
		
		
		Session session =  new Session();
		
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
	

	
	@RequestMapping(value=API.PLAYER_BONUS,method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<PlayerBonusFull>> getAllPlayerBonus(@RequestParam(required=true)Long idplayer) 
	{
		
		
		
		List<PlayerBonusFull> resp = bonusService.getPlayerBonus(idplayer);
		
		return new ResponseEntity<List<PlayerBonusFull>>(resp,HttpStatus.OK);

	}
	
	
	@RequestMapping(value=API.PLAYER_BONUS_USE,method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<PlayerBonus> useBonus(@RequestParam(required = true)Long idplayer,@RequestParam(required = true)Long idbonus)
	{
		
		
		PlayerBonus resp = bonusService.takePlayerBonus(idplayer, idbonus);
		
		
		if(resp!=null)
		{
			return new ResponseEntity<PlayerBonus>(resp,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
	
	
	public class LeaderBoardScore
	{
		private List<PlayerRankGame> topPlayers;
		private PlayerRankGame player;
		public List<PlayerRankGame> getTopPlayers() {
			return topPlayers;
		}
		public void setTopPlayers(List<PlayerRankGame> topPlayers) {
			this.topPlayers = topPlayers;
		}
		public PlayerRankGame getPlayer() {
			return player;
		}
		public void setPlayer(PlayerRankGame player) {
			this.player = player;
		}
		public LeaderBoardScore() {
			super();
		}
		@Override
		public String toString() {
			return "LeaderBoardScore [topPlayers=" + topPlayers + ", player=" + player + "]";
		}
		public LeaderBoardScore(List<PlayerRankGame> topPlayers, PlayerRankGame player) {
			super();
			this.topPlayers = topPlayers;
			this.player = player;
		}
		
		
		
		
		
		
	}
	
	
}
