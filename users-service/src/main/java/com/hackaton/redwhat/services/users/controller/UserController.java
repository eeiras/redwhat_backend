package com.hackaton.redwhat.services.users.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hackaton.redwhat.services.users.model.User;
import com.hackaton.redwhat.services.users.service.UsersService;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @Inject
    UsersService usersService;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(@Valid User user) {
        LOGGER.info("User add: {}", user);
        
        try {
            if (user == null) {
                return Response.status(400).entity("User not provided").build();
            }
            User userCreated = usersService.addUser(user);
            return Response.ok(userCreated).build();
        }
        catch (Exception e){
            return Response.serverError().build();
        }
    }

    @Path("/{userId}")
    @GET
    public Response getUserById(@PathParam("userId") String userId) {
        LOGGER.info("User get: id={}", userId);
        return Response.ok(usersService.getUser(userId)).build();
    }
    
    @Path("/{userId}")
    @PATCH
    public Response updateUserById(@PathParam("userId") String userId, @Valid User user) {
        LOGGER.info("User update: id={}", user);
        return Response.ok(usersService.updateUser(userId, user)).build();
    }
    
    @Path("/contents/{userId}")
    @POST
    public Response addContentViewedById(@PathParam("userId") String userId, @Valid Integer contentId) {
        LOGGER.info("Add Content viewed: id={}", contentId);
        return Response.ok(usersService.addViewedContentUser(userId, contentId)).build();
    }
    
    @Path("/{userId}")
    @DELETE
    public Response deleteUserById(@PathParam("userId") String userId) {
    	LOGGER.info("Delete add: {}", userId);
    	return Response.ok(usersService.delete(userId)).build();
    }
        
}
