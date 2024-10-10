package lk.ijse.posbackendv2.customStatusCode;


import lk.ijse.posbackendv2.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectedCustomerErrorStatus implements CustomerStatus {
    private int statusCode;
    private String statusMessage;
}
