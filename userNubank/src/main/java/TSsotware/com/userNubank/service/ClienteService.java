package TSsotware.com.userNubank.service;

import TSsotware.com.userNubank.Dtos.ClienteRequestDTO;
import TSsotware.com.userNubank.Dtos.ClienteResponseDTO;
import TSsotware.com.userNubank.model.Cliente;
import TSsotware.com.userNubank.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor

public class ClienteService {

    private final ClienteRepository repository;

    public ClienteResponseDTO salvar (ClienteRequestDTO dto){
        Cliente c = new Cliente();
        c.setNome(dto.getNome());
        Cliente salvo = repository.save(c);
        return new ClienteResponseDTO(salvo.getId(),salvo.getNome(), salvo.getContatos());

    }

    public List<ClienteResponseDTO> listarTodos() {
        return repository.findAll().stream().map(c -> new ClienteResponseDTO(
                c.getId(),
                c.getNome(),
                c.getContatos()
        ))
                .collect(Collectors.toList());
    }


    public Cliente buscarPorId (String id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente não encontrado"));
    }

    public ClienteResponseDTO buscarPorIdDTO(String id) {
        Cliente cliente = buscarPorId(id);
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getContatos());
    }
}
