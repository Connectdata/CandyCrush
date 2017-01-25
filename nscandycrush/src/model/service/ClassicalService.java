package model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.model.dao.HibernateDAO;
import common.model.dao.HibernateModel;

@Service("classicalService")
public class ClassicalService 
{
	
	@Autowired
	HibernateDAO hibernateDAO;
	
	
	
	
	public int save(HibernateModel model)
	{
		int resp = - 1;
		
		
		try
		{
			getDAO().save(model);
			resp = 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return resp;
	}
	
	public int update(HibernateModel model)
	{
		int resp = -1;
		
		
		
		try
		{
			getDAO().update(model);
			resp = 1;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return resp;
	}
	
	
	public int delete(HibernateModel model)
	{
		int resp = - 1 ;
		
		
		try
		{
			getDAO().delete(model);
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
