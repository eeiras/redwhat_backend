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

import com.hackaton.redwhat.model.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Inject
	UsersService usersService;

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addUser(@Valid ToDo user) {
//        LOGGER.info("User add: {}", user);
//        usersService.addUser(user);
//        try {
//            if (user == null) {
//                return Response.status(400).entity("User not provided").build();
//            }
//            return Response.ok(usersService.addUser(user)).build();
//        }
//        catch (Exception e){
//            return Response.serverError().build();
//        }
//    }

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
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@Path("/{id}")
	@GET
	public Response getUserById(@PathParam("id") String id) {
		LOGGER.info("User get: id={}", id);
		return Response.ok(usersService.getUser(id)).build();
	}

//    @Path("/{id}")
//    @PATCH
//    public Response updateUserById(@PathParam("id") String id, @Valid ToDo user) {
//        LOGGER.info("User update: id={}", user);
//        return Response.ok(usersService.updateUser(user)).build();
//    }

	@Path("/{id}")
	@PATCH
	public Response updateUserById(@PathParam("id") String id, @Valid User user) {
		LOGGER.info("User update: id={}", user);
		return Response.ok(usersService.updateUser(user)).build();
	}

	@Path("/{id}")
	@DELETE
	public Response deleteUserById(@PathParam("id") String user_id) {
		LOGGER.info("Delete add: {}", user_id);
		return Response.ok(usersService.delete(user_id)).build();
	}

	@Path("/test/map")
	@GET
	public Response getTestMap() {
		LOGGER.info("User getTestMap");

		return Response.ok(
				"[{\"latitude\":40.717079,\"longitude\":-74.00116,\"size\":6,\"tooltip\":\"Qué es La Bolsa?\",\"fill\":\"#000\"},{\"latitude\":33.145235,\"longitude\":-83.811834,\"size\":7,\"tooltip\":\"¿De donde viene el dinero?\"},{\"latitude\":37.792032,\"longitude\":-122.394613,\"size\":4,\"tooltip\":\"Super Ahorrador\"},{\"latitude\":26.93508,\"longitude\":-80.851766,\"size\":9,\"tooltip\":\"¿Qué es banca?\"},{\"latitude\":36.331308,\"longitude\":-83.33605,\"size\":4,\"tooltip\":\"Tu oficina\"},{\"latitude\":36.269356,\"longitude\":-76.587477,\"size\":8,\"tooltip\":\"Economía Familiar\"},{\"latitude\":30.700644,\"longitude\":-95.145249,\"size\":6,\"tooltip\":\"¿Qué es ahorrar?\"},{\"latitude\":34.546708,\"longitude\":-90.211471,\"size\":5,\"tooltip\":\"Aprendiendo a ahorrar\"},{\"latitude\":32.628599,\"longitude\":-103.675115,\"size\":5,\"tooltip\":\"Tu Cuenta\"},{\"latitude\":40.456692,\"longitude\":-83.522688,\"size\":5,\"tooltip\":\"Tu gestor\"},{\"latitude\":33.84463,\"longitude\":-118.157483,\"size\":6,\"tooltip\":\"Tunel de inversión\"}]")
				.build();
	}

//    @Path("/points/{id}")
//    @PATCH
//    @Consumes(MediaType.TEXT_PLAIN)
//    public Response updateUserPointsById(@PathParam("id") String user_id, @Valid String points) {
//        LOGGER.info("User points update: {}", user_id);
//        return Response.ok(usersService.updatePoints(user_id, points)).build();
//    }
//    
//    @Path("/profile/{id}")
//    @PATCH
//    public Response updateUserProfileById(@PathParam("id") String user_id, @Valid String profile) {
//        LOGGER.info("User profile update: {}", user_id);
//        return Response.ok(usersService.updateProfile(user_id, profile)).build();
//    }
//    
//    @Path("/level/{id}")
//    @PATCH
//    public Response updateUserLevelById(@PathParam("id") String user_id, @Valid String level) {
//        LOGGER.info("User level update: {}", user_id);
//        return Response.ok(usersService.updateLevel(user_id, level)).build();
//    }
//    
//    @Path("/content/{id}")
//    @PATCH
//    public Response updateUserContentById(@PathParam("id") String user_id, @Valid String contentId) {
//        LOGGER.info("User content update: {}", user_id);
//        return Response.ok(usersService.updateContent(user_id, contentId)).build();
//    }
}
