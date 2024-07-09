package com.hipizza.demo.modules.avaliacao.controller;
import com.hipizza.demo.modules.avaliacao.domain.Avaliacao;
import com.hipizza.demo.modules.avaliacao.service.AvaliacaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/avaliacao")
@Tag(name = "Controle de avaliações")
public abstract class BaseAvaliacaoController {

}
