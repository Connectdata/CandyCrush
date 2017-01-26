package model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.model.dao.HibernateDAO;
import model.mapping.Prize;

@Service("prizeService")
public class PrizeService 
{
	@Autowired
	HibernateDAO hibernateDAO;
		
		
	public List<Prize> getAllPrize()
	{
		List resp = null;
		
		try
		{
			resp = getDAO().findBy(new Prize());
		}
		catch(Exception e)
		{
			e.printStackTrace();		}
		
		
		return resp;
	}
	
	
	
	
		
	public HibernateDAO getDAO()
	{
		return hibernateDAO;
	}
		

}
