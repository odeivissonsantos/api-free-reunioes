package com.odeivissonsantos.freereunioes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odeivissonsantos.freereunioes.models.Convidado;

@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, Integer> {

}
