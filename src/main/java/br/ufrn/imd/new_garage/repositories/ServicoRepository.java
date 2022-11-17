package br.ufrn.imd.new_garage.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import br.ufrn.imd.new_garage.entities.EnumStatusServico;
import br.ufrn.imd.new_garage.entities.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

    List<Servico> findByStatusServico(EnumStatusServico statusServico);
}
