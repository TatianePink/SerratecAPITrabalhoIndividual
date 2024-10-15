package br.org.serratec.h2bancoTrabalhoIndividual.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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
	


