package TSsotware.com.userNubank.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Contato {

    private String id = UUID.randomUUID().toString();
    private String tipo;
    private String valor;
}
