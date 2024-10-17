package lk.ijse.posbackendv2.services;

import lk.ijse.posbackendv2.dto.impl.UserDTO;

public interface UserService {
    void saveUser(UserDTO userDTO);
    public boolean authenticate(String username, String password);
}
