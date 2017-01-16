package controller.api;

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
import model.mapping.BestScore;
import model.mapping.Player;
import model.service.PlayerService;

@Controller
public class ActionPlayer
{
	@Autowired
	PlayerService playerService;
	
	@RequestMapping(value=API.PLAYER,method=RequestMethod.POST)
	public @ResponseBody ResponseEntity createUser(@RequestParam(required=true)String nom,@RequestParam(required=false)String prenom,@RequestParam(required=false)String email,@RequestParam(required=false)String telephone,@RequestParam(required=false)String login,@RequestParam(required=false)String password,@RequestParam(required=false)Integer point) 
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
	public @ResponseBody ResponseEntity BestUser(@RequestParam(required = false)Integer limit)
	{
		
		if(limit == null)
		{
			limit = -1;
		}
		
		List<BestScore> resp = playerService.getTopBestPlayer(limit);
		
		
		if(resp !=null)
		{
			return new ResponseEntity<List<BestScore>>(resp,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<BestScore>>(resp,HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
}
