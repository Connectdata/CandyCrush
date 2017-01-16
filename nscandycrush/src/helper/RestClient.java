package helper;

import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.RequestWriter;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.mail.util.BASE64EncoderStream;

import configuration.InfoProject;
import sun.misc.BASE64Encoder;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

public class RestClient
{
	public static final String urlOperator = "http://localhost:8080/OperatorPlateform/api/user";
	public static final String urlLocalHost = "http://localhost:8080/OperatorPlateform/api/user";
	public static final String urlUses = urlLocalHost;
	
	public static String sendRequestPost(String url, HashMap<String, String> postKeyValues, String headerKey, String headerValue)
	{
		try {
			
			
			String[] s= {"application/json"};
			Client client = Client.create();
			WebResource webResource2 = client.resource(url);
			
			Form f = new Form();
			
			Set<String>keys = postKeyValues.keySet();
			
			for(String key:keys)
			{
				f.add(key, postKeyValues.get(key));
			}
			
			ClientResponse response2 = (ClientResponse) webResource2.accept(s).header(headerKey, headerValue).post(ClientResponse.class, f);
		
			
			if (response2.getStatus() != 200)
			{
				String resp = ""+response2.getStatus();
				//throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
				return resp;
			}
 
			String response = (String) response2.getEntity(String.class);
			
			//JSONObject output = (JSONObject)JSONValue.parse(response);
			
			return response;
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static String sendRequestGet(String url, MultivaluedMap<String, String> params, String headerKey, String headerValue)
	{
		try {
			
			//MediaType[] m = {new MediaType("application/json","")};
			String[] s= {"application/json"};
			Client client = Client.create();
			WebResource webResource2 = client.resource(url);
			
//			MultivaluedMap<String, String> params = new MultivaluedMapImpl();
//			for (int i=0; i<param.length;i++)
//			{
//				params.add(param[i], valueParam[i]);
//			}
			
			ClientResponse response2 = (ClientResponse) webResource2.queryParams(params).accept(s).header(headerKey, headerValue).get(ClientResponse.class);
			
			if (response2.getStatus() != 200)
			{
				//throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
				return null;
			}
			
			String response = (String) response2.getEntity(String.class);
			
			//JSONObject output = (JSONObject)JSONValue.parse(response);
			
			return response;
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static String sendRequestGet(String url, String headerKey, String headerValue)
	{
		try {
			
			//MediaType[] m = {new MediaType("application/json","")};
			MediaType[] m = {new MediaType("application/json","")};
			String[] s= {"application/json"};
			Client client = Client.create();
			WebResource webResource2 = client.resource(url);
		
			
			ClientResponse response2 = (ClientResponse) webResource2.accept(s).header(headerKey, headerValue).get(ClientResponse.class);
		
			
			if (response2.getStatus() != 200)
			{
				return null;
			}
 
			String response = (String) response2.getEntity(String.class);
			
			//JSONObject output = (JSONObject)JSONValue.parse(response);
			
			return response;
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String sendRequestGet(String url)
	{
		try {
			
			//MediaType[] m = {new MediaType("application/json","")};
			MediaType[] m = {new MediaType("application/json","")};
			String[] s= {"application/json"};
			Client client = Client.create();
			WebResource webResource2 = client.resource(url);
		
			
			ClientResponse response2 = (ClientResponse) webResource2.accept(s).get(ClientResponse.class);
		
			
			if (response2.getStatus() != 200)
			{
				return null;
			}
 
			String response = (String) response2.getEntity(String.class);
			
			//System.out.println(response);
			//JSONArray output = (JSONArray)JSONValue.parse(response);
			
			return response;
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	/*
	 * @author Rindra Loïc
	 * methode qui appelle le webservice d'authentification
	 * @return l'id du joueur si l'auhtentification réussit, sinon -1
	 */
	public static int authenticate (String mailCrypt){
		String url= InfoProject.getOperatorUrl("/api/user");
		//mailCrypt = crypt(mailCrypt);
		
		String playerString= sendRequestGet(url,"Authorization",mailCrypt);
		int idPlayer=-1;
		if (playerString != null)
		{
			JSONObject player = (JSONObject)JSONValue.parse(playerString);
			long test = (long)player.get("idplayer");
			idPlayer = (int)test;
		}
		System.out.println("Player = "+idPlayer);
		return idPlayer;

	}
	
//	public static PlayerPoker authenticate (String mailCrypt, int forSurcharge){
//		String url= urlOperator;
//		//mailCrypt = crypt(mailCrypt);
//		
//		JSONObject player=sendRequestGet(url,"Authorization",mailCrypt);
//		PlayerPoker p = new PlayerPoker();
//		
//		if (player != null)
//		{
//			long id = (long)player.get("idplayer");
//			int idPlayer = (int)id;
//			String userName = (String) player.get("username");
//			String email = (String) player.get("email");
//			
//			p.setIdPlayer(idPlayer);
//			p.setUserName(userName);
//			p.setEmail(email);
//			
//			System.out.println("Player = "+p.getUserName()+" "+p.getEmail());
//			
//			return p;
//		}
//		
//		return null;
//
//	}
	
	
	public static JSONObject getPlayer(String mailCrypt)
	{
		
		String url= InfoProject.getOperatorUrl("/api/user");
		//mailCrypt = crypt(mailCrypt);
		
		String playerString = sendRequestGet(url,"Authorization",mailCrypt);
		JSONObject player = null;
		
		if (playerString != null)
		{
			player = (JSONObject)JSONValue.parse(playerString);
		}
		
		return player;
		
	}
	
	
	
	public static String crypt(String lol)
	{
		String toEncode = lol;
		String encode = new BASE64Encoder().encode(toEncode.getBytes(StandardCharsets.UTF_8));
		
		encode = "basic "+encode;
		return encode;
	}
}
