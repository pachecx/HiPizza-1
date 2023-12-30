package com.hipizza.demo.service;

import com.hipizza.demo.domain.Categoria;
import com.hipizza.demo.domain.ItemPedido;
import com.hipizza.demo.domain.Pedido;
import com.hipizza.demo.domain.Produto;
import com.hipizza.demo.repository.PedidoRepository;
import com.hipizza.demo.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;


    public void cadastrarPedido(Pedido pedido) {
        calcularValorTotal(pedido);
        pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public void excluirPedidoPorId(Long id) {
        pedidoRepository.deleteById(id);
    }

    public void calcularValorTotal(Pedido pedido) {
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (ItemPedido itemPedido : pedido.getItensPedido()) {
            Produto produto = produtoRepository.findById(itemPedido.getProduto().getId()).orElse(null);

            BigDecimal valorUnitario = produto.getValor_unitario();
            BigDecimal valorPromocao = produto.getValor_promocao();

            if (valorPromocao != null) {
                // Calcular quantidade * valor unitário (do valor promocional)
                BigDecimal valorItem = valorPromocao.multiply(BigDecimal.valueOf(itemPedido.getQuantidade()));

                // Somar o valor do item ao valor total do pedido
                valorTotal = valorTotal.add(valorItem);
            } else {
                //calcula do valor sem promoção
                BigDecimal valorItem = valorUnitario.multiply(BigDecimal.valueOf(itemPedido.getQuantidade()));
                valorTotal = valorTotal.add(valorItem);
            }
        }

        pedido.setValor_total(valorTotal);
    }


}
