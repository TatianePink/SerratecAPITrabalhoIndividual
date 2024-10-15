package br.org.serratec.h2bancoTrabalhoIndividual.domain;

import java.util.Objects;

import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@RequestMapping("/livro")
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(length = 50)
	@NotBlank(message = "O título é obrigatório")
	@Size(min = 2, max = 50, message = "O título é obrigatório {min} e {max} letras")
	private  String titulo;
    
    @Column
	private Integer qtdPaginas;
    
   @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publicacao_id") 
    private Publicacao publicacao;
	

	 public Livro(Long id,
			@NotBlank(message = "O título é obrigatório") @Size(min = 2, max = 50, message = "O título é obrigatório {min} e {max} letras") String titulo,
			Integer qtdPaginas, Publicacao publicacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.qtdPaginas = qtdPaginas;
		this.publicacao = publicacao;
	}



	public Livro() {}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Integer getQtdPaginas() {
		return qtdPaginas;
	}


	public void setQtdPaginas(Integer qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}

	  public Publicacao getPublicacao() {
	        return publicacao;
	    }

	    public void setPublicacao(Publicacao publicacao) {
	        this.publicacao = publicacao;
	    }

	@Override
	public int hashCode() {
		return Objects.hash(id, qtdPaginas, titulo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id) && Objects.equals(qtdPaginas, other.qtdPaginas)
				&& Objects.equals(titulo, other.titulo);
	}
	

	/*
	
@Entity
public class Publicacao {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long publicacao_id;
   
   @NotBlank(message = "O autor é obrigatório")
	@Size(min = 2, max = 50, message = "O autor é obrigatório {min} e {max} letras")
   private String autor;

@Column
   private String dataPublicacao;
   
   @Column 
   private String editora;

   
   
	public Publicacao( String autor, String dataPublicacao, String editora) {
		super();
	
		this.autor = autor;
		this.dataPublicacao = dataPublicacao;
		this.editora = editora;
	}
	
	   public Publicacao() {}

	public Long getPublicacaoId() {
		return publicacao_id;
	}

	public void setPublicacaoId(Long publicacao_id) {
		this.publicacao_id = publicacao_id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

}
*/

	
}



