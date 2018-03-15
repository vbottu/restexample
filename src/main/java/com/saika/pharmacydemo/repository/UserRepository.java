/**
 * 
 */
package com.saika.pharmacydemo.repository;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.saika.pharmacydemo.model.User;

/**
 * @author vinodbottu
 *
 */
@Service
public interface UserRepository extends JpaRepository<User, String> {
	public List<User> findByFirstName(String firstName);

	public List<User> findByLastName(String lastName);

	public User findUserById(String id);

	public Response deleteUserById(String id);

}
