package br.ufrn.imd.new_garage.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.new_garage.entities.Moto;

public interface MotoRepository extends JpaRepository<Moto, Long>{
    List<Moto> findAllByClienteId(Long clienteId);
}
