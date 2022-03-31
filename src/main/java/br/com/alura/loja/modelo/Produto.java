package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// indica para o jpa que essa classe é uma entidade e existe uma tabela no banco de dados que ela representa
@Entity
@Table(name = "produtos") // qndo o nome da tabela é diferente da classe produtos != Produto 
public class Produto {

//	O JPA já sabe que os atributos são as colunas no banco de dados
/*	Se for preciso, caso o nome da coluna seja diferente do atributo, usar a anotação @Column(name = "nome-no-banco") 
 * em cima do atributo desejado */
	
	@Id // indica que o id é gerado pelo banco de dados primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // informa como o valor é gerado, de acordo com o banco
	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private LocalDate dataCadastro = LocalDate.now();

	@ManyToOne
	private Categoria categoria;
	
	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public BigDecimal getPreco() {
		return this.preco;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
}
