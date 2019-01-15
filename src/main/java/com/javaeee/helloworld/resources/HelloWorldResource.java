package com.javaeee.helloworld.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.javaeee.helloworld.api.Saying;

@Path("/HelloWorld")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
	private final String template;
    private final String defaultName;
    private final String defaultAddr;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName, String defaultAddr) {
        this.template = template;
        this.defaultName = defaultName;
        this.defaultAddr = defaultAddr;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name, @QueryParam("addr") Optional<String> addr) {
    	String value = String.format(template, name.orElse(defaultName), addr.orElse(defaultAddr));
    	/*Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=erppd", "sa", "123");

            if(conn!=null) {
                System.out.println("Database Successfully connected");
                Statement statement = conn.createStatement();
                String queryString = "select * from dbo.PERSON";
                ResultSet rs = statement.executeQuery(queryString);
                while (rs.next()) {
                   //System.out.println(rs.getString(1));
                   String g = rs.getString(2).trim();
                	if(defaultName.equals(g)) {
                		value = String.format(template, name.orElse(defaultName), addr.orElse(rs.getString(3)));
                		return new Saying(Long.parseLong(rs.getString(1)),value);
                	}
                	else
                		continue;
                }
            }
            else {
            	System.out.println("Database not connected");
            	//return new Saying(counter.incrementAndGet(), value);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        return new Saying(counter.incrementAndGet(), value);
    }

}
