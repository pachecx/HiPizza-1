package com.hipizza.demo.modules.produto.controller;

import com.hipizza.demo.modules.produto.domain.Produto;
import com.hipizza.demo.modules.produto.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
@Tag(name = "Controle de produtos")
public abstract class BaseProdutoController {

}
