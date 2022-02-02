package AuthenticationAPI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import AuthenticationAPI.model.User;
import AuthenticationAPI.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
	
	@PostMapping("/users/register")
	public ResponseEntity<?> register(@Valid @RequestBody User user) {
		boolean registered = userService.contains(user);

		if (registered) {
			System.out.println("User " + user.getUsername() + " already exists!");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		userService.create(user);
		System.out.println(user + " was created!");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/users/login")
	public ResponseEntity<?> login(@Valid @RequestBody User user) {
		boolean logged = userService.login(user);

		if (logged) {
			System.out.println(user + " was logged!");
			return new ResponseEntity<>(HttpStatus.OK);
		}
		System.out.println("Incorrect credentials for " + user.getUsername());
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}