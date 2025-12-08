package TSsotware.com.userNubank.controller;

import TSsotware.com.userNubank.Dtos.ClienteRequestDTO;
import TSsotware.com.userNubank.Dtos.ClienteResponseDTO;
import TSsotware.com.userNubank.model.Contato;
import TSsotware.com.userNubank.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClienteController {

    public final ClienteService service;


    @PostMapping("/cliente")
    public ResponseEntity<ClienteResponseDTO> salvarCliente(@RequestBody @Valid ClienteRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }


    @PostMapping("/clientes")
    public ResponseEntity<ClienteResponseDTO> salvar(@RequestBody @Valid ClienteRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping("/clientes")
    public List<ClienteResponseDTO> listar(){
        return service.listarTodos();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable String id){
        return ResponseEntity.ok(service.buscarPorIdDTO(id));
    }

    @GetMapping("/clientes/{id}/contatos")
    public List<Contato> listarContatos(@PathVariable String id){
        return service.buscarPorId(id).getContatos();
    }
}
