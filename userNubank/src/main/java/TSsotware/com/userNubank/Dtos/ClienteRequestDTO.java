package TSsotware.com.userNubank.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteRequestDTO {
    @NotBlank
    private String nome;

}
