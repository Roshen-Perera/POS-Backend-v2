package lk.ijse.posbackendv2.customStatusCode;


import lk.ijse.posbackendv2.dto.CustomerStatus;
import lk.ijse.posbackendv2.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectedUserErrorStatus implements UserStatus {
    private int statusCode;
    private String statusMessage;
}
