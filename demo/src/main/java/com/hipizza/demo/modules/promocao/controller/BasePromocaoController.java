package com.hipizza.demo.modules.promocao.controller;

import com.hipizza.demo.modules.promocao.domain.Promocao;
import com.hipizza.demo.modules.promocao.service.PromocaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/promocao")
@Tag(name = "Controle de promoções")
public abstract class BasePromocaoController {

}
