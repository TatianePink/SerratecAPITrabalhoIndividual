package br.org.serratec.h2bancoTrabalhoIndividual.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.org.serratec.h2bancoTrabalhoIndividual.Repository.LivroRepository;
//import br.org.serratec.h2bancoTrabalhoIndividual.domain.Livro.Publicacao;

import br.org.serratec.h2bancoTrabalhoIndividual.domain.Livro;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	  private LivroRepository livroRepository;

    @GetMapping
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

	
    
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
      	Optional<Livro> livroOpt = livroRepository.findById(id); 
              	return livroOpt.isPresent() 
			    ? ResponseEntity.ok(livroOpt.get()) 
			    : ResponseEntity.notFound().build();  
    }

    


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro criarLivro(@Valid @RequestBody Livro livro) {
        return livroRepository.save(livro);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @Valid @RequestBody Livro livro) {
        if (!livroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        livro.setId(id); 
        Livro livroAtualizado = livroRepository.save(livro); 
        return ResponseEntity.ok(livroAtualizado); 
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
    	if (!livroRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		livroRepository.deleteById(id);
		return ResponseEntity.noContent().build();
    

	}

}
