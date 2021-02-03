package com.rodrigo.projetos.xbrain.repositories;

import com.rodrigo.projetos.xbrain.repositories.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    @Transactional(readOnly = true)
    void deleteByCodigo(Integer codigo);

    @Transactional(readOnly = true)
    Optional<Cliente> findByCodigo(Integer codigo);
}
