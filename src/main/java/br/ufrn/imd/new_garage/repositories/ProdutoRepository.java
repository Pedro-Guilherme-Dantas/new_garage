package br.ufrn.imd.new_garage.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.new_garage.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
