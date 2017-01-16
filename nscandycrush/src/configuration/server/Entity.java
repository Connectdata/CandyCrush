package configuration.server;

public abstract class Entity
{
    private String ip;
    private String user;
    private String password;
    public Entity(String i,String u,String p){
        setIp(i);
        setUser(u);
        setPassword(p);
    }
    public String getIp()
    {
        return ip;
    }
    private void setIp(String ip){
        this.ip=ip;
    }
    public String getUser()
    {
        return user;
    }
    private void setUser(String user){
        this.user=user;
    }
    public String getPassword()
    {
        return password;
    }
    private void setPassword(String pwd){
        this.password=pwd;
    }
}
