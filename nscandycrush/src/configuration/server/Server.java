package configuration.server;

public abstract class Server
{
    protected String ip;
    protected Database db;
    protected FTP ftp;
    
    public Server(){
        setIp();
        setDb();
        setFtp();
    }
    public String getIp()
    {
        return ip;
    }
    public abstract void setIp();
    public Database getDb()
    {
        return db;
    }
    public abstract void setDb();
    public FTP getFtp()
    {
        return ftp;
    }
    public abstract void setFtp();
    
    public String getUrl(String link){
        return "http://"+getIp()+":8080/"+link;
    }
}
