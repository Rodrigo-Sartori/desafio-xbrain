package com.rodrigo.projetos.xbrain.repositories;

import com.rodrigo.projetos.xbrain.repositories.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    @Transactional(readOnly = true)
    void deleteByCodigo(Integer codigo);
}
