package configuration;

import javax.ws.rs.core.MultivaluedMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.sun.jersey.core.util.MultivaluedMapImpl;

import configuration.server.Server;

import configuration.server.ServerLocal;
import configuration.server.ServerLocalHost;
import configuration.server.ServerLocalOVH;
import configuration.server.ServerOVH;
import helper.RestClient;

public class InfoProject {

    public static final boolean SHOW_DEBUG=false;
    
    public static final Server SERVER= new ServerLocal();

    public static final String USER_DEFAULT_PASSWORD = "QSDFGHJKLM123456789";

	public static String getDatabaseUrl(){
        return SERVER.getDb().getIp();
    }
	public static String getJDBCUrl(){
        return "jdbc:"+InfoProject.getDatabaseType()+"://"+InfoProject.getDatabaseUrl()+":3306/"+InfoProject.getDatabaseName();
    }
    public static String getDatabaseUser(){
        return SERVER.getDb().getUser();
    }
    public static String getDatabasePassword(){
        return SERVER.getDb().getPassword();
    }
    public static String getDatabaseType(){
        return SERVER.getDb().getDatabaseType();
    }
    public static String getDatabaseName(){
        return SERVER.getDb().getDatabaseName();
    }
    private static String getOperatorUrl(){
        return SERVER.getUrl("OperatorPlateform/");
    }
    public static String getOperatorUrl(String link){
        if(link.startsWith("/"))link=link.substring(1);
        return getOperatorUrl()+link;
    }
    public static String getFTPPath(){
        return SERVER.getFtp().getPath();
    }
    public static String getFTPUrl(){
        return SERVER.getFtp().getIp();
    }
    public static String getFTPUser(){
        return SERVER.getFtp().getUser();
    }
    public static String getFTPPass(){
        return SERVER.getFtp().getPassword();
    }
    
    
    
    public static String getUrl(String Url)
    {
    	return "http://"+SERVER.getFtp().getIp()+":8080/"+SERVER.getFtp().getStockagePath()+Url;
    }

	

}
