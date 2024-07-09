package com.hipizza.demo.modules.perfilEstabelecimento.controller;

import com.hipizza.demo.modules.perfilEstabelecimento.domain.PerfilEstabelecimento;
import com.hipizza.demo.modules.perfilEstabelecimento.service.PerfilEstabelecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Controle de perfis de estabelecimento")
@RequestMapping(value = "/perfil-estabelecimento")
public abstract class BasePerfilEstabelecimentoController {

}
