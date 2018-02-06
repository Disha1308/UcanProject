package com.ucan.userMgmt.rest;

import javax.inject.Named;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.ucan.sharedLib.URLConstants;
import com.ucan.sharedLib.User;
import com.ucan.userMgmt.service.UserService;

@Named
@Path("/v1.0/")
public class UserRest {
	@Autowired
	UserService userServe;

	
	@GET
	@Path(URLConstants.GET_USER_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("email") String email) {
		System.out.println("in get one db user service");
		User u = userServe.getOneUserService(email);

		return u;

	}
	
	@GET
	@Path(URLConstants.GET_USER_ID_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserbyId(@PathParam("id") long uid) {
		System.out.println("in get one db user service");
		User u = userServe.getOneUserbyIdService(uid);

		return u;

	}


	@POST
	@Path(URLConstants.POST_USER_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public void createUser(@RequestBody User u) {
		System.out.println("in post db user service");
		userServe.createUserService(u);
	}

	@PUT
	@Path(URLConstants.PUT_USER_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateUser(@RequestBody User u, @PathParam("id") long id) {
		System.out.println("in put user db service");
		userServe.updateUserService(u, id);

	}

	@DELETE
	@Path(URLConstants.DELETE_USER_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id") long id) {
		System.out.println("in delete user service");
		userServe.deleteUserService(id);

	}

}
