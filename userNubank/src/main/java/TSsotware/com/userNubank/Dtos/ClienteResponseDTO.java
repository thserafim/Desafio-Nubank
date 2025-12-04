package TSsotware.com.userNubank.Dtos;

import TSsotware.com.userNubank.model.Contato;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ClienteResponseDTO {

    private String id;
    private String nome;
    private List<Contato> contatos;

}
