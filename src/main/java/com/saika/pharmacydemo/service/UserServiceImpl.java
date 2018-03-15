/**
 * 
 */
package com.saika.pharmacydemo.service;

import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.saika.pharmacydemo.model.Pharmacy;
import com.saika.pharmacydemo.model.Refill;
import com.saika.pharmacydemo.model.User;
import com.saika.pharmacydemo.repository.PharmacyRepository;
import com.saika.pharmacydemo.repository.RefillRepository;
import com.saika.pharmacydemo.repository.UserRepository;

/**
 * @author vinodbottu
 *
 */
@Controller

@Path("/")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userrepository;

	@Autowired
	private PharmacyRepository pharmacyrepository;

	@Autowired
	private RefillRepository refillrepository;
	@Autowired
	private User userObj;

	@Override
	public User createUser(User user) {
		user = userrepository.save(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> usersList = userrepository.findAll();
		return usersList;
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserById(String id) {
		if (null != id && !id.isEmpty()) {
			userObj = userrepository.findUserById(id);
			return userObj;
		}
		return null;
	}

	@Override
	public List<User> getUserByLastName(String lastName) {
		if (null != lastName && !lastName.isEmpty()) {
			return userrepository.findByLastName(lastName);
		}
		return null;
	}

	@Override
	public List<User> getUserByFirstName(String firstName) {
		if (null != firstName && !firstName.isEmpty()) {
			return userrepository.findByFirstName(firstName);
		}
		return null;
	}

	@Override
	public User updateUser(User user, String id) {
		userObj = getUserById(id);
		if (null != userObj) {
			userObj.setStreet(user.getStreet());
			userObj.setCity(user.getCity());
			userObj.setState(user.getState());
			userObj.setCountry(user.getCountry());
			userObj.setZipCode(user.getZipCode());
			userObj.setEmail(user.getEmail());

			return userrepository.save(userObj);
		}
		return userObj;
	}

	@Override
	@Modifying
	@Transactional
	public Response deleteUser(String id) {
		if (id != null && !id.isEmpty()) {
			Response rsp = userrepository.deleteUserById(id);
			return rsp;
		}
		return Response.status(Response.Status.NOT_FOUND).entity("Patient with provided id not found").build();
	}

	@Override
	public List<Pharmacy> getPharmacies() {
		return pharmacyrepository.findAll();
	}

	@Override
	public Pharmacy getPharmacyById(String id) {
		if (null != id && !id.isEmpty()) {
			return pharmacyrepository.findOne(id);
		}
		return null;
	}

	@Override
	public Pharmacy getPharmacyByName(String name) {
		if (null != name && !name.isEmpty()) {
			return pharmacyrepository.findByName(name);
		}
		return null;
	}

	@Override
	public Pharmacy addPharmacy(Pharmacy pharmacy) {
		if (null != pharmacy) {
			return pharmacyrepository.save(pharmacy);
		}
		return null;
	}

	@Override
	public Refill getRefillById(String id) {
		if (null != id && !id.isEmpty()) {
			return refillrepository.findOne(id);
		}
		return null;
	}

	@Override
	public List<Refill> getAllRefills() {
		return refillrepository.findAll();
	}

	@Override
	public List<Refill> getRefillByUserId(String userId) {
		if (null != userId && !userId.isEmpty()) {
			return refillrepository.findByUserId(userId);
		}
		return null;
	}

}
