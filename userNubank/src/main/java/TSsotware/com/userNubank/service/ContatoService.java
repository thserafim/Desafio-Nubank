package TSsotware.com.userNubank.service;


import TSsotware.com.userNubank.Dtos.ClienteResponseDTO;
import TSsotware.com.userNubank.Dtos.ContatoRequestDTO;
import TSsotware.com.userNubank.model.Cliente;
import TSsotware.com.userNubank.model.Contato;
import TSsotware.com.userNubank.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ContatoService {
    private final ClienteRepository clienteRepository;

    public ClienteResponseDTO adicionarContato(String clienteId, ContatoRequestDTO dto){

        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente nao encontrado"));
        Contato contato = new Contato();
        contato.setTipo(dto.getTipo());
        contato.setValor(dto.getValor());

        cliente.getContatos().add(contato);
        Cliente atualizado = clienteRepository.save(cliente);

        return new ClienteResponseDTO(atualizado.getId(), atualizado.getNome(), atualizado.getContatos());
    }

    public List<Contato> listarContatos (String clienteId){
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente nao encontrado"));

        return cliente.getContatos();
    }
}
