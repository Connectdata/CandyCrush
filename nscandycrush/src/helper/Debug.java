package helper;

import configuration.InfoProject;

public class Debug
{
    public static void write(String s){
        if(InfoProject.SHOW_DEBUG)System.out.println(s);
    }
    public static void write(Object o){
        if(InfoProject.SHOW_DEBUG)System.out.println(o);
    }
}
