package model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.model.dao.HibernateDAO;
import common.model.dao.HibernateModel;
import model.mapping.BestScore;
import model.mapping.Player;

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
	
	
	public List<BestScore> getTopBestPlayer(int limittop)
	{
		List resp =null;
		
		String query = "";
		
		
		if(limittop==-1)
		{
			query = "SELECT  * FROM bestScore";
		}
		else
		{
			query = "SELECT TOP "+limittop+" * FROM bestScore";
		}
		
		
		
		
		try
		{
			resp = getDAO().executeQuery(query, new BestScore());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return resp;
		
	}
	
	
	public BestScore getPlayerBestScore(long idPlayer)
	{
		BestScore resp = null;
		
		
		try
		{
			BestScore condition = new BestScore();
			condition.setIdPlayer(idPlayer);
			try
			{
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		return resp;
	}

}
