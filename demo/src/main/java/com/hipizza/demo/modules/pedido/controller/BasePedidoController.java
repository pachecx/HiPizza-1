package com.hipizza.demo.modules.pedido.controller;

import com.hipizza.demo.modules.pedido.domain.Pedido;
import com.hipizza.demo.modules.pedido.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
@Tag(name = "Controle de pedidos")
public abstract class BasePedidoController {

}