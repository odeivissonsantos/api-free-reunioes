package com.odeivissonsantos.freereunioes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odeivissonsantos.freereunioes.models.SalaModel;

@Repository
public interface SalaRepository extends JpaRepository<SalaModel, Long> {

}
