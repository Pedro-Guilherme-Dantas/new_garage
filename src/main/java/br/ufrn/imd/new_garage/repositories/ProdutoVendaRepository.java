package br.ufrn.imd.new_garage.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.new_garage.entities.ProdutoVenda;

public interface ProdutoVendaRepository extends JpaRepository<ProdutoVenda, Long>{
    
}
