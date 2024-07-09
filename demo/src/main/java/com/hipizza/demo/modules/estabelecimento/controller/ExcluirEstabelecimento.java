package com.hipizza.demo.modules.estabelecimento.controller;

import com.hipizza.demo.modules.estabelecimento.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcluirEstabelecimento extends BaseEstabelecimentoController{

    @Autowired
    private EstabelecimentoService estabelecimentoService;

   //Inserir método de exclusão de um estabelecimento por parte do suporte.
}
