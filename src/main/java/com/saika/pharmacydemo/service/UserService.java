/**
 * 
 */
package com.saika.pharmacydemo.service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.saika.pharmacydemo.model.Pharmacy;
import com.saika.pharmacydemo.model.Refill;
import com.saika.pharmacydemo.model.User;

/**
 * @author vinodbottu
 *
 */

public interface UserService {

	@Path("/registerUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User createUser(User user);

	@Path("/users")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers();

	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") String id);

	@PUT
	@Path("/users/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(User user, @PathParam("id") String id);

	@GET
	@Path("/findusers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserByLastName(@QueryParam("lastName") String lastName);

	@GET
	@Path("/finduser")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserByFirstName(@QueryParam("firstName") String firstName);

	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("id") String id);

	@GET
	@Path("/pharmacies")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pharmacy> getPharmacies();

	@GET
	@Path("pharmacies/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pharmacy getPharmacyById(@PathParam("id") String id);

	@GET
	@Path("pharmacies/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pharmacy getPharmacyByName(@PathParam("name") String name);

	@POST
	@Path("/pharmacies")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Pharmacy addPharmacy(Pharmacy pharmacy);

	@GET
	@Path("/refill/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Refill getRefillById(@PathParam("id") String id);

	@GET
	@Path("/refills")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Refill> getAllRefills();

	@GET
	@Path("/refills/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Refill> getRefillByUserId(String userId);

}
