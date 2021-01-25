package com.devops.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devops.demo.model.User;
import com.devops.demo.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){		
		List<User> users = this.userRepository.findAll();		
        if(users.isEmpty())
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);        	
        return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/tutorials/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
	  Optional<User> userFound = this.userRepository.findById(id);
      if (userFound.isPresent()) {
	    return new ResponseEntity<>(userFound.get(), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
	  try {	
		User _user = this.userRepository.save(new User(user.getFirstName(),user.getLastName(),user.getEmail()));
		return new ResponseEntity<>(_user, HttpStatus.CREATED);
	  }catch(Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);  
	  }		
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
	  Optional<User> userFound = this.userRepository.findById(id);
	  if (userFound.isPresent()) {
	    User _user = userFound.get();
	    _user.setFirstName(user.getFirstName());
	    _user.setLastName(user.getLastName());
	    _user.setEmail(user.getEmail());
	    return new ResponseEntity<>(this.userRepository.save(_user), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
	
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
	  Optional<User> userFound = this.userRepository.findById(id);
	  if (userFound.isPresent()) {
	      this.userRepository.deleteById(id);
		  return new ResponseEntity<>(HttpStatus.OK);
	  } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
    }
}
