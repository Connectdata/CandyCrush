package common.model.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
public class HibernateDAO
{
    @Autowired
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() 
    {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
//    public List<HibernateModel>findBy(HibernateModel model){
//        Session session=null;
//        List<HibernateModel>list=new ArrayList<HibernateModel>();
//        session=getSessionFactory().getCurrentSession();
//        Criteria crit=session.createCriteria(model.getClass()).add(Example.create(model));
//        list=crit.list();
//        return list;
//    }
    
    public List<HibernateModel>findBy(HibernateModel model,String SQLrestriction){
        Session session=null;
        List<HibernateModel>list=new ArrayList<HibernateModel>();
        session=getSessionFactory().getCurrentSession();
        Criteria crit=session.createCriteria(model.getClass()).add(Example.create(model)).add(Restrictions.sqlRestriction(SQLrestriction));
        list=crit.list();
       
        return list;
    }
    public List<HibernateModel>findAll(HibernateModel model,Order order){
        Session session=null;
        List<HibernateModel>list=new ArrayList<HibernateModel>();
        session=getSessionFactory().getCurrentSession();
        Criteria crit=session.createCriteria(model.getClass()).addOrder(order);
        list=crit.list();
        return list;
    }
    public List<HibernateModel>findAll(HibernateModel model){
        Session session=null;
        List<HibernateModel>list=new ArrayList<HibernateModel>();
        session=getSessionFactory().getCurrentSession();
        Criteria crit=session.createCriteria(model.getClass());
        list=crit.list();
        return list;
    }
    public List<HibernateModel>findAll(HibernateModel model,String SQLrestriction){
        Session session=null;
        List<HibernateModel>list=new ArrayList<HibernateModel>();
        session=getSessionFactory().getCurrentSession();
        Criteria crit=session.createCriteria(model.getClass()).add(Restrictions.sqlRestriction(SQLrestriction));
        list=crit.list();
        return list;
    }
    public HibernateModel findById(HibernateModel model,int id){
        Session session=null;
        HibernateModel m=null;
        session=getSessionFactory().getCurrentSession();
        m=(HibernateModel) session.get(model.getClass(), new Long(id));
        return m;
    }
    public HibernateModel findById(HibernateModel model,long id){
        Session session=null;
        HibernateModel m=null;
        session=getSessionFactory().getCurrentSession();
        m=(HibernateModel) session.get(model.getClass(), new Long(id));
        return m;
    }
    @Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
    public void update(HibernateModel model){
        Session session=null;
        session=getSessionFactory().getCurrentSession();
        session.update(model);
    }
    @Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
    public void save(HibernateModel model){
        Session session=null;
        session=getSessionFactory().getCurrentSession();
        session.save(model);
    }
    @Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
    public void delete(HibernateModel model){
        Session session=null;
        session=getSessionFactory().getCurrentSession();
        session.delete(model);
    }
    public List<HibernateModel>executeQuery(String query,HibernateModel model){
        Session session=null;
        List<HibernateModel>list=new ArrayList<HibernateModel>();
        session=getSessionFactory().getCurrentSession();
        list=session.createSQLQuery(query).addEntity(model.getClass()).list();
        return list;
    }
    
    
    
    public List<Map<String,Object>> executeQuery2(String query){
        Session session=null;
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        session=getSessionFactory().getCurrentSession();
        list=session.createSQLQuery(query).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }
    
    public List<Object[]>executeQuery(String query){
        Session session=null;
        List<Object[]>list=new ArrayList<Object[]>();
        try{
            session=getSessionFactory().getCurrentSession();
            Iterator iterator=session.createSQLQuery(query).list().iterator();
            while(iterator.hasNext()){
                try{
                    Object[]row=(Object[])iterator.next();
                    list.add(row);
                }
                catch(ClassCastException e){
                    try{
                        Integer[]row=(Integer[])iterator.next();
                        list.add(row);
                    }
                    catch(NoSuchElementException noSuch){
                        
                    }
                }
               
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            Integer[]l={1};
            list.add(l);
             
        }
        return list;
    }
    
    
    @Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
    public int executeUpdate(String query)
    {
    	int resp  = -1;
    	Session session  = getSessionFactory().getCurrentSession();
    	Query q = session.createQuery(query);
    	resp = q.executeUpdate();
    	return resp;
    	
    }
    
    
    @Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
    public int executeSQLUpdate(String query)
    {
    	int resp  = -1;
    	Session session  = getSessionFactory().getCurrentSession();
    	Query q = session.createSQLQuery(query);
    	resp = q.executeUpdate();
    	return resp;
    	
    }
    
    public List<Object> executeQueryOneColumn(String query)
    {
    	List<Object> resp = null;
    	Session session = getSessionFactory().getCurrentSession();
    		Query q  = session.createSQLQuery(query);
    		resp = q.list();
    	 
    	return resp;
    	
    	
    }
    
    
    
    public List<HibernateModel> findBy(HibernateModel model)
    {
    	List<HibernateModel> rep = null;
    	
    	Class classe = model.getClass();
    	Field [] fields = classe.getDeclaredFields();
   	
    	HashMap<String, Object> listFields = new HashMap<>();
    	
    	for(Field f:fields)
    	{
    		try
			{
    			f.setAccessible(true);
    			if(f.get(model) != null)
    			{
    				listFields.put(f.getName(), f.get(model));
    			}
				
			} 
    		catch (Exception e)
			{
				
				e.printStackTrace();
			} 
    	}
    	
    	Session session = getSessionFactory().getCurrentSession();
    	try
    	{
    		Criteria crit = session.createCriteria(classe);
    		 crit.add(Restrictions.allEq(listFields));
    		
    		rep = crit.list();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	 
    	
    	return rep;
    	
    }
    
    
    
    
}
