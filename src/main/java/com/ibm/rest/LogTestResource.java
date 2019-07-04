/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.rest;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author mfigueroa
 */
@Path("logTest")
public class LogTestResource {

    @Context
    private UriInfo context;
    private static final Logger LOGGER = Logger.getLogger(LogTestResource.class.getName());

    /**
     * Creates a new instance of LogTestResource
     */
    public LogTestResource() {
    }

    /**
     * Retrieves representation of an instance of com.ibm.rest.LogTestResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getJson")
    @Produces("application/json")
    public Response getJson(@QueryParam("documentNumber")String documentNumber,@QueryParam("name")String name) {
        String requestTest="Param documentNumber= "+documentNumber+", param name= "+name;
        String responseText="¡DATOS INCORRECTOS!";
        Response.Status status=Response.Status.BAD_REQUEST;
        
        LOGGER.log(Level.INFO, "Request: "+requestTest);       
        
        if(!"".equals(documentNumber) && !"".equals(name) && documentNumber!=null && name !=null)
        {
            responseText="¡DATOS RECIBIDOS!";
            status=Response.Status.OK;
        }
                        
        JsonObjectBuilder jsonObjectBuilder=  Json.createObjectBuilder();
        jsonObjectBuilder.add("response", responseText);
        JsonObject jsonObject= jsonObjectBuilder.build();
        LOGGER.log(Level.INFO, "Response: "+ responseText);
        return Response.status(status).entity(jsonObject.toString())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, HEAD, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type,X-Requested-With,accept,Origin,Access-Control-Allow-Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization,Cookie")
                .build();
    }

    /**
     * PUT method for updating or creating an instance of LogTestResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
