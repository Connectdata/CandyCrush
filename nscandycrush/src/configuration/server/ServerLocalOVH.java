package configuration.server;

public class ServerLocalOVH extends Server
{
    @Override
    public void setIp()
    {
        this.ip="localhost";
    }
    @Override
    public void setDb()
    {
        this.db=new Database("178.33.230.123","sa",",8v3rS5N(b");
    }

    @Override
    public void setFtp()
    {
       this.ftp=new FTP("178.33.230.123","nsplatformftp","8L)2esR[");
    }
}
