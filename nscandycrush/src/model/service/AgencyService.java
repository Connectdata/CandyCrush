package model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.model.dao.HibernateDAO;
import model.mapping.AgencyContent;

@Service("agencyService")
public class AgencyService 
{
	@Autowired
	HibernateDAO hibernateDAO;
	
	
	
	public List<AgencyContent> GetAllAgencyHasThisPrize(long idprize)
	{
		List resp = null;
		
		
		try
		{
			String query = "select * from agencycontent where idprize="+idprize+" and number>=0";
			
			resp = getDAO().executeQuery(query,new AgencyContent());
			
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
