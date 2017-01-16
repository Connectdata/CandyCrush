package configuration.server;

public class ServerLocalHost extends Server
{
    @Override
    public void setIp()
    {
        this.ip="localhost";
    }
    @Override
    public void setDb()
    {
        this.db=new Database("localhost","sa","Azerty+1234");
    }

    @Override
    public void setFtp()
    {
       this.ftp=new FTP("192.168.1.211","hery","hery");
    }
}
