package com.gabriel.suplementos.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gabriel.suplementos.models.Suplemento;


public interface SuplementoRepository extends GenericRepository<Suplemento, Long> {
    


    @Query(value = "SELECT suplemento from Suplemento suplemento where suplemento.nome like :nome ", nativeQuery = true)
    public Suplemento buscaSuplementoNome(@Param("nome") String nome);

}
