package com.rodrigo.projetos.xbrain.repositories;

import com.rodrigo.projetos.xbrain.repositories.domain.Pedido;
import com.rodrigo.projetos.xbrain.repositories.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
