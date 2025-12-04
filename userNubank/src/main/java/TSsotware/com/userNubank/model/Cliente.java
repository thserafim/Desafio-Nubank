package TSsotware.com.userNubank.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "clientes")

public class Cliente {

    @Id
    private String id;
    private String nome;
    private List<Contato> contatos = new ArrayList<>();
}
