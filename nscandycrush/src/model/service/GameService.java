package model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.model.dao.HibernateDAO;
import model.mapping.GameType;
import model.mapping.LeaderBoard;
import model.mapping.Session;

@Service("gameService")
public class GameService 
{
	
	
	@Autowired
	HibernateDAO hibernateDAO;
	
	@Autowired
	PlayerService playerService;
	
	
	
	
	public int saveSession(Session session)
	{
		int resp = -1;
		
		
		
		try
		{
			
			
			getDAO().save(session);
			resp = 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return resp;
	}
	
	
	public List<GameType> getAllGameType()
	{
		List resp = null;
		
		
		try
		{
			resp = getDAO().findBy(new GameType());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return resp;
	}
	
	public List<LeaderBoard> getAllFirstGame()
	{
		List resp = null;
		
		try
		{
			resp = getDAO().findBy(new LeaderBoard());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return resp;
	}
	
	
	
	
	public HibernateDAO getDAO()
	{
		return hibernateDAO;
	}

}
