package lk.ijse.posbackendv2.dto.impl;

import lk.ijse.posbackendv2.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements UserStatus {
    private String userName;
    private String userEmail;
    private String password;
}