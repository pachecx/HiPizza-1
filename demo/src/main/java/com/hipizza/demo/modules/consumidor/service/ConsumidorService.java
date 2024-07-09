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
import java.util.Optional;

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

        Consumidor novoConsumidor = new Consumidor();

        novoConsumidor.setNome(consumidor.nome());
        novoConsumidor.setCpf(consumidor.cpf());
        novoConsumidor.setEmail(consumidor.email());
        novoConsumidor.setSenha(passwordEncoder.encode(consumidor.senha()));
        novoConsumidor.setTelefone(consumidor.telefone());
        novoConsumidor.setCep(consumidor.cep());
        novoConsumidor.setEstado(consumidor.estado());
        novoConsumidor.setCidade(consumidor.cidade());
        novoConsumidor.setRua(consumidor.rua());
        novoConsumidor.setBairro(consumidor.bairro());
        novoConsumidor.setComplemento(consumidor.complemento());
        novoConsumidor.setPonto_referencia(consumidor.pontoReferencia());
        novoConsumidor.setRoles(userRole);

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

    public String excluirConsumidor(Long id){
        Optional<Consumidor> queryResult = consumidorRepository.findById(id);

        if(queryResult.isPresent()){
            consumidorRepository.deleteById(id);
            return "O consumidor foi excluído.";
        }

        else{
            return "O consumidor não foi encontrado ou já foi excluído.";
        }
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
