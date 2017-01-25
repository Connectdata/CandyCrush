package model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.model.dao.HibernateDAO;
import model.mapping.Bonus;
import model.mapping.PlayerBonus;
import model.mapping.PlayerBonusFull;

@Service("bonusService")
public class BonusService 
{
	@Autowired
	HibernateDAO hibernateDAO;
	
	public List<PlayerBonusFull> getPlayerBonus(long idPlayer)
	{
		
		List resp= null;
		
		try 
		{
			PlayerBonusFull condition = new PlayerBonusFull();
			condition.setIdPlayer(idPlayer);
			resp = getDAO().findBy(condition);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return resp;
	}
	
	
	public PlayerBonusFull getPlayerBonus(long idplayer,long idbonus)
	{
		PlayerBonusFull resp = null;
		
		
		try
		{
			PlayerBonusFull condition = new PlayerBonusFull();
			condition.setIdPlayer(idplayer);
			condition.setIdBonus(idbonus);
			
			resp = (PlayerBonusFull)getDAO().findBy(condition).get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return resp;
	}
	
	
	
	public PlayerBonus takePlayerBonus(long idplayer,long idbonus)
	{
		PlayerBonus resp = null;
		
		PlayerBonus pb = new PlayerBonus();
		pb.setIdPlayer(idplayer);
		pb.setIdBonus(idbonus);
		
		try
		{
			pb = (PlayerBonus) getDAO().findBy(pb).get(0);
			
			
			if(pb.getNumber()>0)
			{
				pb.setNumber(pb.getNumber()-1);
				getDAO().update(pb);
				
			}
			resp = pb;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return resp;
		
	}
	
	
	
	public PlayerBonus addPlayerBonus(long idplayer,long idbonus,int number)
	{
		PlayerBonus resp = null;
		
		try
		{
			PlayerBonus condition = new PlayerBonus();
			condition.setIdPlayer(idplayer);
			condition.setIdBonus(idbonus);
			
			PlayerBonus rbdd = null;
			try
			{
				rbdd = (PlayerBonus) getDAO().findBy(condition).get(0);
				
			}
			catch(Exception e){e.printStackTrace();}
			
			if(rbdd ==null)
			{
				condition.setNumber(number);
				getDAO().save(condition);
				resp = condition;
			}
			else
			{
				rbdd.setNumber(rbdd.getNumber()+number);
				getDAO().update(rbdd);
				resp = rbdd;
			}
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return resp;
		
		
	}
	
	
	public List<Bonus> getBonus(long idbonus)
	{
		List resp = null;
		
		Bonus condition = new Bonus();
		if(idbonus>0)
		{
			condition.setIdBonus(idbonus);
			
		}
		
		
		try
		{
			resp =  getDAO().findBy(condition);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return resp;
	}
	
	
	HibernateDAO getDAO()
	{
		return hibernateDAO;
	}
	

}
