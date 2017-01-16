package configuration.server;

public class Database extends Entity
{
    private String databaseType;
    private String databaseName;
    public Database(String ip,String user,String password){
        super(ip,user,password);
        setDatabaseType("sqlserver");
        setDatabaseName("candycrush");
    }
    public String getDatabaseType()
    {
        return databaseType;
    }
    private void setDatabaseType(String databaseType)
    {
        this.databaseType = databaseType;
    }
    public String getDatabaseName()
    {
        return databaseName;
    }
    private void setDatabaseName(String databaseName)
    {
        this.databaseName = databaseName;
    }
}
