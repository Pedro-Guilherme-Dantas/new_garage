package br.ufrn.imd.new_garage.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.new_garage.entities.Moto;

public interface MotoRepository extends JpaRepository<Moto, Long>{
    
}
