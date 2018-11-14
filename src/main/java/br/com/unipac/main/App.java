package br.com.unipac.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.unipac.dominio.Produto;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ControleEstoquePU");
		EntityManager em = emf.createEntityManager();

		Produto produto = new Produto();
		produto.setNome("Tennis");
		produto.setMarca("mizuno");

		inserindoProduto(em, produto);

		SelecionarProduto(em);
	}

	private static void SelecionarProduto(EntityManager em) {
		Query query = em.createQuery("FROM Produto p");
		List<Produto> produtos = query.getResultList();
		for (Produto produto2 : produtos) {
			System.out.println(produto2.toString());
		}
	}

	private static void inserindoProduto(EntityManager em, Produto produto) {
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}
}
