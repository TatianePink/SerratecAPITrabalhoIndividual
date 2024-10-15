package br.org.serratec.h2bancoTrabalhoIndividual.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.org.serratec.h2bancoTrabalhoIndividual.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
