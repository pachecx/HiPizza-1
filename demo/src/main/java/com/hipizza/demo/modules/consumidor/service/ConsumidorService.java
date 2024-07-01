package com.hipizza.demo.modules.consumidor.service;

import com.hipizza.demo.modules.consumidor.domain.Consumidor;
import com.hipizza.demo.modules.consumidor.repository.ConsumidorRepository;
import com.hipizza.demo.modules.login.dto.ConsumidorDTO;
import com.hipizza.demo.modules.roles.domain.Role;
import com.hipizza.demo.modules.roles.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ConsumidorService {
    @Autowired
    private ConsumidorRepository consumidorRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public void cadastrarConsumidor(ConsumidorDTO consumidor) {

        var userRole = roleRepository.findByName(Role.Values.USER.name());

        if (userRole == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User role not found");
        }

        var userFromDb = consumidorRepository.findByEmail(consumidor.email());
        if (userFromDb.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        Consumidor novoConsumidor = new Consumidor(
                consumidor.nome(),
                consumidor.cpf(),
                consumidor.email(),
                passwordEncoder.encode(consumidor.senha()),
                consumidor.telefone(),
                consumidor.cep(),
                consumidor.estado(),
                consumidor.cidade(),
                consumidor.rua(),
                consumidor.bairro(),
                consumidor.complemento(),
                consumidor.pontoReferencia(),
                userRole
        );

        consumidorRepository.save(novoConsumidor);
    }

    public List<Consumidor> listarConsumidores() {
        return consumidorRepository.findAll();
    }


    public Consumidor buscarConsumidorPorId(Long id) {
        return consumidorRepository.findById(id).orElse(null);
    }

    public Consumidor atualizarConsumidor(Long id, Consumidor consumidorAlterado) {

        Consumidor consumidorExistente = consumidorRepository.getReferenceById(id);
        atualizarDados(consumidorExistente, consumidorAlterado);
        return consumidorRepository.save(consumidorExistente);

    }

    private void atualizarDados(Consumidor consumidorExistente, Consumidor consumidorAlterado) {
        consumidorExistente.setCpf(consumidorAlterado.getCpf());
        consumidorExistente.setEmail(consumidorAlterado.getEmail());
        consumidorExistente.setBairro(consumidorAlterado.getBairro());
        consumidorExistente.setCep(consumidorAlterado.getCep());
        consumidorExistente.setCidade(consumidorAlterado.getCidade());
        consumidorExistente.setEstado(consumidorAlterado.getEstado());
        consumidorExistente.setTelefone(consumidorAlterado.getTelefone());
        consumidorExistente.setSenha(consumidorAlterado.getSenha());
        consumidorExistente.setPonto_referencia(consumidorAlterado.getPonto_referencia());
        consumidorExistente.setRua(consumidorAlterado.getRua());
        consumidorExistente.setNome(consumidorAlterado.getNome());
        consumidorExistente.setComplemento(consumidorAlterado.getComplemento());
    }
}
