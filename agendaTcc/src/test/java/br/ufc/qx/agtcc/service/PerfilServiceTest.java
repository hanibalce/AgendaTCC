package br.ufc.qx.agtcc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.List;

import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufc.qx.agtcc.DBunitTest;
import br.ufc.qx.agtcc.exceptions.SaadCampoDuplicadoException;
import br.ufc.qx.agtcc.model.entities.Perfil;
import br.ufc.qx.agtcc.model.entities.Permissao;
import br.ufc.qx.agtcc.repository.Perfis;
import br.ufc.qx.agtcc.repository.Permissoes;
import br.ufc.qx.agtcc.service.PerfilService;
import br.ufc.qx.agtcc.service.PermissaoService;

public class PerfilServiceTest extends DBunitTest {
	protected static FlatXmlDataSet dataset;

	private final Perfis perfis = new Perfis(em);
	private final PerfilService perfilService = new PerfilService(perfis);
	private Perfil perfil;

	private final Permissoes permissoes = new Permissoes(em);
	private final PermissaoService permissaoService = new PermissaoService(permissoes);

	@BeforeClass
	public static void insertDataSets() throws Exception {
		dataset = new FlatXmlDataSetBuilder().build(new File("src/test/resources/perfil.xml"));
	}

	@Before
	public void cleanDB() {
		tabelas.add("perfil");
		tabelas.add("permissao");
		tabelas.add("perfil_permissao");
		datasets.add(dataset);
		resetarBancoDeDados(tabelas, datasets);
	}

	@Test(expected = SaadCampoDuplicadoException.class)
	public void salvarPerfilRepetidoTest() throws Exception {
		String nome = "aluno";
		this.perfil = new Perfil(nome);
		List<Permissao> permissoes = this.permissaoService.listarPermissoes();

		em.getTransaction().begin();
		this.perfilService.salvar(perfil, permissoes);
		em.getTransaction().commit();

		fail("Deveria ter lançado uma exceção de campo duplicado.");
	}

	@Test
	public void salvarPerfilTest() throws Exception {
		String nome = "suporte_pedagogico";
		this.perfil = new Perfil(nome);
		List<Permissao> permissoes = this.permissaoService.listarPermissoes();

		em.getTransaction().begin();
		this.perfilService.salvar(perfil, permissoes);
		em.getTransaction().commit();

		List<Perfil> perfis = this.perfilService.buscarPorNome(nome);
		assertEquals(1, perfis.size());

		this.perfil = perfis.get(0);
		assertEquals(nome, this.perfil.getNome());
	}

	@Test
	public void buscarPerfilPorNomeExatoTest() throws Exception {
		String nome = "aluno";
		List<Perfil> perfis = this.perfilService.buscarPorNome(nome);

		assertEquals(1, perfis.size());
		this.perfil = perfis.get(0);
		assertEquals(nome, this.perfil.getNome());

	}
}