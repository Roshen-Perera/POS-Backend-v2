package lk.ijse.posbackendv2.services.impl;

import jakarta.transaction.Transactional;
import lk.ijse.posbackendv2.dao.UserDAO;
import lk.ijse.posbackendv2.dto.impl.UserDTO;
import lk.ijse.posbackendv2.entity.impl.User;
import lk.ijse.posbackendv2.exception.UserNotFoundException;
import lk.ijse.posbackendv2.services.UserService;
import lk.ijse.posbackendv2.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveUser(UserDTO userDTO) {
        User saveUser = userDAO.save(mapping.toUserEntity(userDTO));
        if (saveUser == null) {
            throw new UserNotFoundException("User not found");
        }
    }

    public boolean authenticate(String userName, String password) {
        // Look for the user by username in the database
        Optional<User> userOptional = userDAO.findByUserName(userName);

        if (userOptional.isPresent()) {
            // Compare the provided password with the stored password (plain text comparison)
            User user = userOptional.get();
            return password.equals(user.getPassword());
        }
        return false;  // If the user does not exist
    }
}


