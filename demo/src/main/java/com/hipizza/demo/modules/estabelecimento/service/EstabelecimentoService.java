package com.hipizza.demo.modules.estabelecimento.service;

import com.hipizza.demo.modules.estabelecimento.domain.Estabelecimento;
import com.hipizza.demo.modules.login.dto.CreateEstabelecimentoDTO;
import com.hipizza.demo.modules.roles.domain.Role;
import com.hipizza.demo.modules.roles.repository.RoleRepository;
import com.hipizza.demo.projection.EstabelecimentoProjection;
import com.hipizza.demo.modules.estabelecimento.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EstabelecimentoService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private RoleRepository roleRepository;

    public String cadastrarEstabelecimento(CreateEstabelecimentoDTO estabelecimento) {
        var basicRole = roleRepository.findByName(Role.Values.BASIC.name());

        if (basicRole == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Basic role not found");
        }

        var userFromDb = estabelecimentoRepository.findByEmail(estabelecimento.email());
        if (userFromDb.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var newEstabelecimento = new Estabelecimento();
        newEstabelecimento.setNome(estabelecimento.nome());
        newEstabelecimento.setCpf(estabelecimento.cpf());
        newEstabelecimento.setEmail(estabelecimento.email());
        newEstabelecimento.setTelefone(estabelecimento.telefone());
        newEstabelecimento.setEndereco(estabelecimento.endereco());
        newEstabelecimento.setCnpj(estabelecimento.cnpj());
        newEstabelecimento.setRazao_social(estabelecimento.razao_social());
        newEstabelecimento.setAgencia(estabelecimento.agencia());
        newEstabelecimento.setConta_corrente(estabelecimento.conta_corrente());
        newEstabelecimento.setConta_corrente(estabelecimento.conta_corrente());
        newEstabelecimento.setSenha(passwordEncoder.encode(estabelecimento.senha()));
        newEstabelecimento.setMedia_avaliacao(estabelecimento.media_avaliacao());
        newEstabelecimento.setFuncionarios(estabelecimento.funcionarios());
        newEstabelecimento.setCategorias(estabelecimento.categorias());
        newEstabelecimento.setPedidos(estabelecimento.pedidos());
        newEstabelecimento.setPerfilEstabelecimento(estabelecimento.perfilEstabelecimento());
        newEstabelecimento.setRoles(basicRole);

        estabelecimentoRepository.save(newEstabelecimento);

        return "Estabelecimento cadastrado com sucesso.";
    }

    public List<Estabelecimento> listarEstabelecimentos() {
        return estabelecimentoRepository.findAll();
    }

    public List<EstabelecimentoProjection> listarEstabelecimentosProjection() {
        return estabelecimentoRepository.findAllBy();
    }

    public Estabelecimento buscarEstabelecimentoPorId(Long id) {
        return estabelecimentoRepository.findById(id).orElse(null);
    }

    public Estabelecimento atualizarEstabelecimento(Long id, Estabelecimento estabelecimentoAlterado) {

        Estabelecimento estabelecimentoExistente = estabelecimentoRepository.getReferenceById(id);
        atualizarDados(estabelecimentoExistente, estabelecimentoAlterado);
        return estabelecimentoRepository.save(estabelecimentoExistente);

    }

    private void atualizarDados(Estabelecimento estabelecimentoExistente, Estabelecimento estabelecimentoAlterado) {
        estabelecimentoExistente.setAgencia(estabelecimentoAlterado.getAgencia());
        estabelecimentoExistente.setCnpj(estabelecimentoAlterado.getCnpj());
        estabelecimentoExistente.setCpf(estabelecimentoAlterado.getCpf());
        estabelecimentoExistente.setEmail(estabelecimentoExistente.getEmail());
        estabelecimentoExistente.setConta_corrente(estabelecimentoAlterado.getConta_corrente());
        estabelecimentoExistente.setNome(estabelecimentoAlterado.getNome());
        estabelecimentoExistente.setEndereco(estabelecimentoAlterado.getEndereco());
        estabelecimentoExistente.setRazao_social(estabelecimentoAlterado.getRazao_social());
        estabelecimentoExistente.setSenha(estabelecimentoAlterado.getSenha());
        estabelecimentoExistente.setTelefone(estabelecimentoAlterado.getTelefone());
    }
}