package br.com.alura.leilao.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.alura.leilao.model.Usuario;

@Repository
public class UsuarioDao {

	private EntityManager em;

	@Autowired
	public UsuarioDao(EntityManager em) {
		this.em = em;
	}

	public Usuario buscarPorUsername(String username) {
		return em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :username", Usuario.class)
				.setParameter("username", username)
				.getSingleResult();
	}

	public void deletar(Usuario usuario) {
		em.remove(usuario);
	}

	/*
	 * Essa classe UsuarioDao não tem INSERT e UPDATE. Provavelmente os usuários dessa aplicação são
	 * cadastrados em outros sistema externo, por uma API, ou inserido diretamente em um banco de dados, etc.
	 */

}
