package com.hipizza.demo.modules.categoria.controller;

import com.hipizza.demo.modules.categoria.domain.Categoria;
import com.hipizza.demo.modules.categoria.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Controle de categorias")
@RequestMapping(value = "/categoria")
public abstract class BaseCategoriaController {

}
