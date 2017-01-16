package configuration.server;

public class FTP extends Entity
{
    private String path;
    private String stockagePath;
    public FTP(String ip,String user,String password){
        super(ip,user,password);
        setPath("platform/sakafomalagasy/");
        setStockagePath("storage/platform/sakafomalagasy/");
    }
    public String getPath()
    {
        return path;
    }
    private void setPath(String path)
    {
        this.path = path;
    }
    public String getStockagePath()
    {
        return stockagePath;
    }
    private void setStockagePath(String stockagePath)
    {
        this.stockagePath = stockagePath;
    }
}
