package lk.ijse.posbackendv2.controller;

import lk.ijse.posbackendv2.dto.impl.UserDTO;
import lk.ijse.posbackendv2.exception.DataPersistException;
import lk.ijse.posbackendv2.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    static Logger logger =  LoggerFactory.getLogger(UserController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(@RequestBody UserDTO orderDTO) {
        try {
            userService.saveUser(orderDTO);
            logger.info("User saved");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody UserDTO userDTO) {
        boolean isAuthenticated = userService.authenticate(userDTO.getUserName(), userDTO.getPassword());
        if (isAuthenticated) {
            logger.info("User logged in");
            return "Access granted";  // If credentials are correct, grant access
        } else {
            logger.info("User not authenticated");
            return "Invalid username or password";  // If credentials are incorrect, deny access
        }
    }
}
