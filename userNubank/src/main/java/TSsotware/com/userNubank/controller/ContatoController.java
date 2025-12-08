package TSsotware.com.userNubank.controller;


import TSsotware.com.userNubank.Dtos.ClienteResponseDTO;
import TSsotware.com.userNubank.Dtos.ContatoRequestDTO;
import TSsotware.com.userNubank.service.ContatoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contatos")
@RequiredArgsConstructor

public class ContatoController {

    private final ContatoService service;
    @PostMapping("/{clienteId}")
    public ResponseEntity<ClienteResponseDTO> adicionar(
            @PathVariable String clienteId,
            @RequestBody @Valid ContatoRequestDTO dto
            ){
        return ResponseEntity.ok(service.adicionarContato(clienteId, dto));
    }
}
