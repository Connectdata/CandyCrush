package model.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import common.model.dao.HibernateDAO;
import configuration.InfoProject;
@Service("stockageService")
public class StockageService 
{
	
	public boolean uploadFTP(InputStream stream,String entity,String remoteFile) throws IOException
	{
		FTPClient client=new FTPClient();
		try{
			client.connect(InfoProject.getFTPUrl(),21);
			client.login(InfoProject.getFTPUser(), InfoProject.getFTPPass());
			client.enterLocalPassiveMode();
			client.setFileType(FTP.BINARY_FILE_TYPE);
			String remoteFileLocation=InfoProject.getFTPPath()+entity+remoteFile;
			boolean done=client.storeFile("/"+remoteFileLocation, stream);
			stream.close();
			
			
		}
		catch(Exception exception){
			exception.printStackTrace();
			if (client.isConnected()) {
                client.logout();
                client.disconnect();
            }
			return false;
		}
		finally{
			if (client.isConnected())
			{
                
				client.logout();
				client.disconnect();
				
               
            }
			return true;
		}
	}
	

}
