package com.hipizza.demo.modules.funcionario.controller;
import com.hipizza.demo.modules.funcionario.service.FuncionarioService;
import com.hipizza.demo.modules.funcionario.domain.Funcionario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
@Tag(name = "Controle de funcionários")
public abstract class BaseFuncionarioController {

}
