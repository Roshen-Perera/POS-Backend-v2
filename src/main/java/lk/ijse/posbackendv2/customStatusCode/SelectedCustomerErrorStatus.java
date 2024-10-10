package lk.ijse.POSBackendV2.customStatusCode;


import lk.ijse.POSBackendV2.dto.CustomerStatus;
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
