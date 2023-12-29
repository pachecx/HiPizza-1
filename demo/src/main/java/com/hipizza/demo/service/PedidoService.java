package com.hipizza.demo.service;

import com.hipizza.demo.domain.Categoria;
import com.hipizza.demo.domain.Pedido;
import com.hipizza.demo.domain.Produto;
import com.hipizza.demo.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public void cadastrarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public void excluirPedidoPorId(Long id) {
        pedidoRepository.deleteById(id);
    }

}
