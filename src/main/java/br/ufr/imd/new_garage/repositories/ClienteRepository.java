package br.ufr.imd.new_garage.repositories;
import br.ufr.imd.new_garage.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
