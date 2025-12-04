package TSsotware.com.userNubank.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContatoRequestDTO {
    @NotBlank
    private String tipo;

    @NotBlank
    private String valor;
}
