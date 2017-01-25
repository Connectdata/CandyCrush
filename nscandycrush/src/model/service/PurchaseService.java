package model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.model.dao.HibernateDAO;
import model.mapping.Bonus;
import model.mapping.Player;
import model.mapping.PlayerBonus;
import model.mapping.Purchase;

@Service("purchaseService")
public class PurchaseService 
{
	@Autowired
	HibernateDAO hibernateDAO;
	@Autowired
	PlayerService playerService;
	@Autowired
	BonusService bonusService;
	
	
	
	
	public Purchase buying(long idplayer,long idbonus,int number)
	{
		
		Purchase resp = null;
		
		
		try
		{
			Player p = new Player();
			p.setIdPlayer(idplayer);
			p = playerService.getPlayer(p).get(0);
			
			Bonus b = new Bonus();
			b.setIdBonus(idbonus);
			b = (Bonus) getDAO().findBy(b).get(0);
			
			
			int tPrice = b.getPrice()*number;
			System.out.println("TOTAL PRICE "+tPrice);
			
			if(p.getPoint()>=tPrice)
			{
				System.out.println("HOAAAA");
				resp = new Purchase();
				
				p.setPoint(p.getPoint()-tPrice);
				getDAO().update(p);
				
				resp.setIdPlayer(p.getIdPlayer());
				resp.setIdBonus(idbonus);
				resp.setNumber(number);
				resp.setTotalPrice(tPrice);
				bonusService.addPlayerBonus(idplayer, idbonus, number);
				getDAO().save(resp);
				
				
				
			}
			
			
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
