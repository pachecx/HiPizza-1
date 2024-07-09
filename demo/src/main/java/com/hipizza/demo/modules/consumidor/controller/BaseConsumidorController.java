package com.hipizza.demo.modules.consumidor.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Controle de consumidores")
@RequestMapping(value = "/consumidor")
public abstract class BaseConsumidorController {

}
