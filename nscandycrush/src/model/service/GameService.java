package model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.model.dao.HibernateDAO;
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
	
	
	
	public HibernateDAO getDAO()
	{
		return hibernateDAO;
	}

}
