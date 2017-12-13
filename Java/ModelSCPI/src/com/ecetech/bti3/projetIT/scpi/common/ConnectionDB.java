package com.ecetech.bti3.projetIT.scpi.common;
/**
 * 
 * @author Taha RIDENE
 */
//~--- JDK imports ------------------------------------------------------------

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDB {
  
  private static final String dbPath   = "jdbc:mysql://localhost:3306/scpi"; //Num de port mysql 3306, 8889 sous mac
  private static final String user     = "root";
  private static final String password = "root";
  private static Connection   con      = null;
  private static Statement    stm      = null;
  private static ResultSet    res      = null;
  private static int          erreur;

  public static Exception DBConnexion() {
      try {
          Class.forName("com.mysql.jdbc.Driver").newInstance();
          con = DriverManager.getConnection(dbPath, user, password);
          stm = con.createStatement();

          return null;
      } catch (Exception e) {
          System.out.println("ERROR in Connexion to " + dbPath + " :" + e.getMessage());

          return e;
      }
  }

  public static int DBClose() 
  {
      try {
          stm.close();
          con.close();
      } catch (Exception e) {
          System.out.println("ERROR in Connexion closure to " + dbPath + " : " + e.getMessage());
      }

      return erreur;
  }

  public static Connection getCon() {
      return con;
  }

  public static void setCon(Connection con) {
      ConnectionDB.con = con;
  }

  public static Statement getStm() {
      return stm;
  }

  public static void setStm(Statement stm) {
	  ConnectionDB.stm = stm;
  }

  public static ResultSet getRes() {
      return res;
  }

  public static void setRes(ResultSet res) {
	  ConnectionDB.res = res;
  }
}


//~ Formatted by Jindent --- http://www.jindent.com
