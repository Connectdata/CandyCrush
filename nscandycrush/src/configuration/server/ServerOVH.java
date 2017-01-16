package configuration.server;

public class ServerOVH extends Server
{
    @Override
    public void setIp()
    {
        this.ip="178.33.230.123";
    }
    @Override
    public void setDb()
    {
        this.db=new Database(getIp(),"sa",",8v3rS5N(b");
    }

    @Override
    public void setFtp()
    {
       this.ftp=new FTP(getIp(),"nsplatformftp","8L)2esR[");
    }
}
