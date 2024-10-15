package br.org.serratec.h2bancoTrabalhoIndividual.Repository;


//import br.org.serratec.h2bancoTrabalhoIndividual.domain.Livro.Publicacao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.h2bancoTrabalhoIndividual.domain.Publicacao;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
}