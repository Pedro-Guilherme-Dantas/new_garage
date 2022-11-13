package br.ufrn.imd.new_garage.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.new_garage.entities.ProdutoServico;

public interface ProdutoServicoRepository extends JpaRepository<ProdutoServico, Long>{
    
}
