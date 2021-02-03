package com.rodrigo.projetos.xbrain.repositories;

import com.rodrigo.projetos.xbrain.repositories.domain.Entrega;
import com.rodrigo.projetos.xbrain.repositories.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {

}
