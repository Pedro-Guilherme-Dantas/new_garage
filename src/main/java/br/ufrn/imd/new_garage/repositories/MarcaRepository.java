package br.ufrn.imd.new_garage.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.new_garage.entities.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{
    
}
