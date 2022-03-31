package br.com.alura.loja.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {	
		
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);		
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin(); // qndo o transaction type é resource local, tem que se iniciar a transação, comitar e fechar
		
		em.persist(celulares);	
		
		em.getTransaction().commit();
		em.close();
		
	}
}
