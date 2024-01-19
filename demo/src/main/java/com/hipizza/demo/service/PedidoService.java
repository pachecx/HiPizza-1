package com.hipizza.demo.service;

import com.hipizza.demo.domain.*;
import com.hipizza.demo.repository.EstabelecimentoRepository;
import com.hipizza.demo.repository.PedidoRepository;
import com.hipizza.demo.repository.PerfilEstabelecimentoRepository;
import com.hipizza.demo.repository.ProdutoRepository;
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

    @Autowired
    private PerfilEstabelecimentoRepository perfilEstabelecimentoRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;


    public void cadastrarPedido(Pedido pedido) {
        calcularValorTotal(pedido);
        pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> getPedidosPorConsumidor(Long idConsumidor) {
        return pedidoRepository.findByConsumidorId(idConsumidor);
    }

    public List<Pedido> getPedidosPorEstabelecimento(Long idEstabelecimento) {
        return pedidoRepository.findByEstabelecimentoId(idEstabelecimento);
    }

    public void excluirPedidoPorId(Long id) {
        pedidoRepository.deleteById(id);
    }

    public void calcularValorTotal(Pedido pedido) {
        Estabelecimento estabelecimento = estabelecimentoRepository.findById(
                pedido.getEstabelecimento().getId()).orElse(null);

        PerfilEstabelecimento perfilEstabelecimento = perfilEstabelecimentoRepository.findById(
                estabelecimento.getPerfilEstabelecimento().getId()).orElse(null);

        BigDecimal valorTotal = BigDecimal.ZERO;
        BigDecimal valorEntrega = perfilEstabelecimento.getValor_entrega();

        valorTotal = valorTotal.add(valorEntrega);//somando com valor da entrega
        for (ItemPedido itemPedido : pedido.getItensPedido()) {
            Produto produto = produtoRepository.findById(itemPedido.getProduto().getId()).orElse(null);

            BigDecimal valorUnitario = produto.getValor_unitario();

            // Calcular quantidade * valor unitário
            BigDecimal valorItem = valorUnitario.multiply(BigDecimal.valueOf(itemPedido.getQuantidade()));

            // Somar o valor do item ao valor total do pedido
            valorTotal = valorTotal.add(valorItem);

        }

        pedido.setValor_total(valorTotal);
    }
    public Pedido atualizarPedido(Long id, Pedido pedidoAlterado) {

        Pedido pedidoExistente = pedidoRepository.getReferenceById(id);
        atualizarDados(pedidoExistente, pedidoAlterado);
        calcularValorTotal(pedidoExistente);
        return pedidoRepository.save(pedidoExistente);

    }
    private void atualizarDados(Pedido pedidoExistente, Pedido pedidoAlterado) {
        pedidoExistente.setForma_pagamento(pedidoAlterado.getForma_pagamento());
        pedidoExistente.setObservacao(pedidoAlterado.getObservacao());
        pedidoExistente.setStatus(pedidoAlterado.getStatus());
        //pedidoExistente.setItensPedido(pedidoAlterado.getItensPedido());
    }

}