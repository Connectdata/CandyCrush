package configuration.server;

public class ServerLocal extends Server
{
	@Override
    public void setIp()
    {
        this.ip="localhost";
    }
    @Override
    public void setDb()
    {
        this.db=new Database("192.168.137.10","sa","Azerty+1234");
    }

    @Override
    public void setFtp()
    {
       this.ftp=new FTP("192.168.137.10","hery","hery");
    }
}
