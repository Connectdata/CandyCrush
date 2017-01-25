package model.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.ViewResolversBeanDefinitionParser;

import com.fasterxml.jackson.annotation.JsonValue;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;

import common.model.dao.HibernateDAO;
import common.model.dao.HibernateModel;
import helper.DateHelper;
import model.mapping.BestScore;
import model.mapping.Player;
import model.mapping.PlayerRankGame;

@Service("playerService")
public class PlayerService 
{
	@Autowired
	HibernateDAO hibernateDAO;

	public HibernateDAO getDAO() 
	{
		return hibernateDAO;
	}
	
	
	
	public int savePlayer(Player player)
	{
		int ret = -1;
		try
		{
			getDAO().save(player);
			ret = 1;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public int savePlayers(List<Player> players)
	{
		int ret = -1;
		
		for (Player player : players) 
		{
			
			try
			{
				getDAO().save(player);
				ret = 1;
			}
			catch(Exception e)
			{
				ret = -1;
				e.printStackTrace();
			}
			
		}
		
		
		return ret;
	}
	
	
	public List<Player> getPlayer(Player playerCondition)
	{
		List  resp = null;
		
		
		try
		{
			resp = getDAO().findBy(playerCondition);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return resp;
	}
	
	
	public List<PlayerRankGame> getTopBestPlayer(int limittop,long idgametype)
	{
		List<Map<String,Object>> resp = null;
		
		String query = "";
		
		
		if(limittop==-1)
		{
			query =  "SELECT	@curRank \\:= @curRank + 1 AS rank,t.* FROM	( SELECT h.*, player.nom,player.prenom,player.email,player.telephone,player.idFacebook from (select o.* from (select * from session where idGameType="+idgametype+") o left JOIN (select * from session where idGameType="+idgametype+") b ON o.idPlayer = b.idPlayer  AND o.score < b.score WHERE b.score is NULL) h inner join player on h.idPlayer = player.idPlayer) t,(SELECT @curRank \\:= 0) r ORDER BY  t.score DESC";
		}
		else
		{
			query =  "SELECT limit "+limittop+"	@curRank \\:= @curRank + 1 AS rank,t.* FROM	( SELECT h.*, player.nom,player.prenom,player.email,player.telephone,player.idFacebook from (select o.* from (select * from session where idGameType="+idgametype+") o left JOIN (select * from session where idGameType="+idgametype+") b ON o.idPlayer = b.idPlayer  AND o.score < b.score WHERE b.score is NULL) h inner join player on h.idPlayer = player.idPlayer) t,(SELECT @curRank \\:= 0) r ORDER BY  t.score DESC";
		}
		
		List<PlayerRankGame> pR =null ;
		
		
		try
		{
			 resp = getDAO().executeQuery2(query);
				

			pR = new ArrayList<>();
			for(int i = 0 ; i<resp.size() ; i ++ )
			{
				PlayerRankGame tmpP = new PlayerRankGame();
				
				
				
				tmpP.setDate(resp.get(i).get("date").toString());
				tmpP.setScore(new Integer(resp.get(i).get("score").toString()));
				tmpP.setIdPlayer(new Long(resp.get(i).get("idPlayer").toString()));
				tmpP.setIdGameType(new Long(resp.get(i).get("idGameType").toString()));
				tmpP.setIdSession(new Long(resp.get(i).get("idSession").toString()));
				try
				{
					tmpP.setIdFacebook(resp.get(i).get("idFacebook").toString());
				}catch(Exception e){}
				try
				{
					tmpP.setTelephone(resp.get(i).get("telephone").toString());
				}catch(Exception e){}
				try
				{
					tmpP.setPrenom(resp.get(i).get("prenom").toString());
				}catch(Exception e){}
				try
				{
					tmpP.setEmail(resp.get(i).get("email").toString());
				}catch(Exception e){}
				
				tmpP.setRank(new Double(resp.get(i).get("rank").toString()).intValue());
				
				
				tmpP.setNom(resp.get(i).get("nom").toString());
				
				
				pR.add(tmpP);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("HAHAHAHA "+resp);
		
		return pR;
		
	}
	
	
	public PlayerRankGame getPlayerBestScoreInSpecificGame(long idPlayer,long idgametype)
	{
		
		Map<String,Object> resp = null;
		
		PlayerRankGame rp = null;
		
		String query = " SELECT * FROM (SELECT	@curRank \\:= @curRank + 1 AS rank,t.* FROM	( SELECT h.*, player.nom,player.prenom,player.email,player.telephone,player.idFacebook from (select o.* from (select * from session where idGameType="+idgametype+") o left JOIN (select * from session where idGameType="+idgametype+") b ON o.idPlayer = b.idPlayer  AND o.score < b.score WHERE b.score is NULL) h inner join player on h.idPlayer = player.idPlayer) t,(SELECT @curRank \\:= 0) r ORDER BY  t.score DESC) w Where w.idPlayer="+idPlayer;
		
		
		try
		{
			resp = getDAO().executeQuery2(query).get(0);
			PlayerRankGame tmpP = new PlayerRankGame();

			tmpP.setDate(resp.get("date").toString());
			tmpP.setScore(new Integer(resp.get("score").toString()));
			tmpP.setIdPlayer(new Long(resp.get("idPlayer").toString()));
			tmpP.setIdGameType(new Long(resp.get("idGameType").toString()));
			tmpP.setIdSession(new Long(resp.get("idSession").toString()));
			try
			{
				tmpP.setIdFacebook(resp.get("idFacebook").toString());
			}catch(Exception e){}
			try
			{
				tmpP.setTelephone(resp.get("telephone").toString());
			}catch(Exception e){}
			try
			{
				tmpP.setPrenom(resp.get("prenom").toString());
			}catch(Exception e){}
			try
			{
				tmpP.setEmail(resp.get("email").toString());
			}catch(Exception e){}
			
			tmpP.setRank(new Double(resp.get("rank").toString()).intValue());
			
			
			tmpP.setNom(resp.get("nom").toString());
			rp = tmpP;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rp;		
		
	}
	
	public Player addPlayerPoint(long idplayer,int toadd)
	{
		Player resp = null;
		
		try
		{
			Player p = new Player();
			p.setIdPlayer(idplayer);
			
			p = (Player)getDAO().findBy(p).get(0);
			
			p.setPoint(p.getPoint()+toadd);
			getDAO().update(p);
			resp = p;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return resp;
	}
	
	public Player takePlayerPoint(long idplayer,int totake)
	{
		Player resp=null;
		
		try
		{
			Player p = new Player();
			p.setIdPlayer(idplayer);
			p = (Player)getDAO().findAll(p).get(0);
			if(p.getPoint()>=totake)
			{
				p.setPoint(p.getPoint()-totake);
				getDAO().update(p);
				
			}
			resp = p;
		}
		catch(Exception e)
		{
			
		}
		
		
		return resp;
	}
	

}
