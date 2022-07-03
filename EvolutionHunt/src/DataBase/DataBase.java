package DataBase;
import Main.GamePanel;

import java.sql.*;
public class DataBase {

    static Connection c=null;
    static Statement stmt=null;

    public static void save(){
        try{
            Class.forName("org.sqlite.JDBC");
            c=DriverManager.getConnection("jdbc:sqlite:Evolution_Hunt.db");
            stmt= c.createStatement();
            String sql="UPDATE EvolutionHunt set xPlayer =\""+ GamePanel.player.x+"\", " +
                    "yPlayer =\""+ GamePanel.player.y+ "\", "+
                    "Scor =\""+ GamePanel.ui.playTime+ "\", "+
                    "Level =\""+ GamePanel.level+ "\", "+
                    "NrObj =\""+ GamePanel.player.nrObjects + "\", "+
                    "State1 =\""+ GamePanel.Obiecte[0]+ "\", "+
                    "State2 =\""+ GamePanel.Obiecte[1]+ "\", "+
                    "State3 =\""+ GamePanel.Obiecte[2]+ "\" WHERE rowid=1";
            stmt.execute(sql);
            stmt.close();
            c.close();

        }catch (Exception  e){
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
    }
    public static void load(){
        try{
            Class.forName("org.sqlite.JDBC");
            c=DriverManager.getConnection("jdbc:sqlite:Evolution_Hunt.db");
            stmt= c.createStatement();
           ResultSet resultSet=stmt.executeQuery("SELECT * from EvolutionHunt");
           GamePanel.player.x= resultSet.getInt("xPlayer");
           GamePanel.player.y=resultSet.getInt("yPlayer");
           GamePanel.ui.playTime=resultSet.getDouble("Scor");
           GamePanel.level=resultSet.getInt("Level");
            GamePanel.player.nrObjects=resultSet.getInt("NrObj");
            GamePanel.Obiecte[0]=resultSet.getInt("State1");
            GamePanel.Obiecte[1]=resultSet.getInt("State2");
            GamePanel.Obiecte[2]=resultSet.getInt("State3");
           resultSet.close();
           stmt.close();
           c.close();

        }catch (Exception  e){
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
    }

}
