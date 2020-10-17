/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;
import java.util.concurrent.ExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;



/**
 *
 * @author user
 */
@Path("test")
public class test {

    private ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();
    @GET
    @Path("/getdata")
    @Produces(MediaType.APPLICATION_JSON)
    public void getDataInJSON(@Suspended
    final AsyncResponse asyncResponse)
            {
        executorService.submit(new Runnable() { 
            public void run() {
                asyncResponse.resume(doGetDataInJSON());
            }
        });
            }

    private String doGetDataInJSON() {
        return "Test";
    }
    
    
    
}
