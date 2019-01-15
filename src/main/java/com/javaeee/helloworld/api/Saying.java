package com.javaeee.helloworld.api;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Saying {
	private long id;

    @Length(max = 4)
    private String content;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }
    
    /*
    public String Connectio() {
    	String lid = Long.toString(id);
    	Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=erppd", "sa", "123");

            if(conn!=null) {
                System.out.print("Database Successfully connected");
                Statement statement = conn.createStatement();
                String queryString = "select * from dbo.PERSON";
                ResultSet rs = statement.executeQuery(queryString);
                while (rs.next()) {
                   //System.out.println(rs.getString(1));
                   String g = rs.getString(1).trim();
                	if(lid.equals(g)) {
                		return "Saying{" + "name=" + rs.getString(2) + ", address='" + rs.getString(3) + '\'' + '}';
                	}
                }

            }
            else
            	System.out.println("Database not connected");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
    
}
