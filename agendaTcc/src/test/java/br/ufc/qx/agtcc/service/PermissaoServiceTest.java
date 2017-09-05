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
import br.ufc.qx.agtcc.exceptions.SaadCampoEmUsoException;
import br.ufc.qx.agtcc.model.entities.Permissao;
import br.ufc.qx.agtcc.repository.Permissoes;
import br.ufc.qx.agtcc.service.PermissaoService;

public class PermissaoServiceTest extends DBunitTest {

	protected static FlatXmlDataSet dataset;

	private final Permissoes permissoes = new Permissoes(em);
	private final PermissaoService permissaoService = new PermissaoService(permissoes);
	private Permissao permissao;

	@BeforeClass
	public static void insertDataSets() throws Exception {
		dataset = new FlatXmlDataSetBuilder().build(new File("src/test/resources/permissao.xml"));
	}

	@Before
	public void cleanDB() {
		tabelas.add("perfil");
		tabelas.add("permissao");
		datasets.add(dataset);
		resetarBancoDeDados(tabelas, datasets);
	}

	@Test
	public void buscarPermissaoPorIdtest() {
		String valor = "alterar_nota";
		Long id = 2L;

		this.permissao = this.permissaoService.buscarPorId(2L);

		assertEquals("Não encontrou o Id correto", id, this.permissao.getId());
		assertEquals("Não encontrou o Id correto", valor, this.permissao.getValor());
	}

	@Test
	public void buscarPermissaoPorIdNaoEncontradotest() {
		this.permissao = this.permissaoService.buscarPorId(12L);
		assertEquals("Deveria ter retornado null.", null, this.permissao);
	}

	@Test
	public void buscarPermissaoPorValorExatoTest() {
		String valor = "inscrever_aluno";
		Long id = 3L;

		List<Permissao> listaPermissoes = this.permissaoService.buscarPorValor(valor);

		this.permissao = listaPermissoes.get(0);
		assertEquals("A quantidade deveria ser 1", 1, listaPermissoes.size());
		assertEquals("Não encontrou o Id correto", id, this.permissao.getId());
		assertEquals("Não encontrou o Id correto", valor, this.permissao.getValor());
	}

	@Test
	public void buscarPermissaoPorValorEncontrandoDuasPermissoesTest() {
		String valor = "alterar";

		List<Permissao> listaPermissoes = this.permissaoService.buscarPorValor(valor);

		assertEquals("A quantidade deveria ser 2", 2, listaPermissoes.size());

		Long id_1 = 2L;
		String valor_1 = "alterar_nota";
		this.permissao = listaPermissoes.get(0);
		assertEquals("Não encontrou o Id correto", id_1, this.permissao.getId());
		assertEquals("Não encontrou o Id correto", valor_1, this.permissao.getValor());

		Long id_2 = 5L;
		String valor_2 = "alterar_titulo";
		this.permissao = listaPermissoes.get(1);
		assertEquals("Não encontrou o Id correto", id_2, this.permissao.getId());
		assertEquals("Não encontrou o Id correto", valor_2, this.permissao.getValor());

	}

	@Test
	public void buscarPermissaoPorValorInexistenteTest() {
		String valor = "permissao de gravacao";
		List<Permissao> listaPermissoes = this.permissaoService.buscarPorValor(valor);
		assertEquals("Deveria ter retornado uma lista vazia.", 0, listaPermissoes.size());
	}

	@Test
	public void listarTodasAsPermissoesTest() {
		List<Permissao> listaPermissoes = this.permissaoService.listarPermissoes();
		assertEquals("Deveria ter retornado uma lista", 5, listaPermissoes.size());
	}

	@Test
	public void listarTodasAsPermissoesPorOrdemAlfabeticaTest() {
		List<Permissao> listaPermissoes = this.permissaoService.listarPermissoesPorOrdemAlfabetica();

		Long id_1 = 2L;
		String valor_1 = "alterar_nota";
		this.permissao = listaPermissoes.get(0);
		assertEquals("Não encontrou o Id correto", id_1, this.permissao.getId());
		assertEquals("Não encontrou o valor correto", valor_1, this.permissao.getValor());

		Long id_2 = 5L;
		String valor_2 = "alterar_titulo";
		this.permissao = listaPermissoes.get(1);
		assertEquals("Não encontrou o Id correto", id_2, this.permissao.getId());
		assertEquals("Não encontrou o valor correto", valor_2, this.permissao.getValor());

		Long id_3 = 4L;
		String valor_3 = "imprimir_declaracao";
		this.permissao = listaPermissoes.get(2);
		assertEquals("Não encontrou o Id correto", id_3, this.permissao.getId());
		assertEquals("Não encontrou o valor correto", valor_3, this.permissao.getValor());

		Long id_4 = 3L;
		String valor_4 = "inscrever_aluno";
		this.permissao = listaPermissoes.get(3);
		assertEquals("Não encontrou o Id correto", id_4, this.permissao.getId());
		assertEquals("Não encontrou o valor correto", valor_4, this.permissao.getValor());

		Long id_5 = 1L;
		String valor_5 = "salvar_tcc";
		this.permissao = listaPermissoes.get(4);
		assertEquals("Não encontrou o Id correto", id_5, this.permissao.getId());
		assertEquals("Não encontrou o valor correto", valor_5, this.permissao.getValor());

	}

	@Test
	public void listarTodasAsPermissoesPorOrdemIdInversaTest() {
		List<Permissao> listaPermissoes = this.permissaoService.listarPermissoesPorOrdemIdInversa();

		Long id_2 = 5L;
		String valor_2 = "alterar_titulo";
		this.permissao = listaPermissoes.get(0);
		assertEquals("Não encontrou o Id correto", id_2, this.permissao.getId());
		assertEquals("Não encontrou o valor correto", valor_2, this.permissao.getValor());

		Long id_1 = 2L;
		String valor_1 = "alterar_nota";
		this.permissao = listaPermissoes.get(3);
		assertEquals("Não encontrou o Id correto", id_1, this.permissao.getId());
		assertEquals("Não encontrou o valor correto", valor_1, this.permissao.getValor());

		Long id_3 = 4L;
		String valor_3 = "imprimir_declaracao";
		this.permissao = listaPermissoes.get(1);
		assertEquals("Não encontrou o Id correto", id_3, this.permissao.getId());
		assertEquals("Não encontrou o valor correto", valor_3, this.permissao.getValor());

		Long id_4 = 3L;
		String valor_4 = "inscrever_aluno";
		this.permissao = listaPermissoes.get(2);
		assertEquals("Não encontrou o Id correto", id_4, this.permissao.getId());
		assertEquals("Não encontrou o valor correto", valor_4, this.permissao.getValor());

		Long id_5 = 1L;
		String valor_5 = "salvar_tcc";
		this.permissao = listaPermissoes.get(4);
		assertEquals("Não encontrou o Id correto", id_5, this.permissao.getId());
		assertEquals("Não encontrou o valor correto", valor_5, this.permissao.getValor());

	}

	@Test
	public void salvarNovaPermissaoTest() {
		this.permissao = new Permissao("zzzzzzzzzzzzz");

		try {
			em.getTransaction().begin();
			this.permissaoService.salvar(this.permissao);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Não deveria ter dado erro ao salvar permissao.");
		}

		String valor = "zzzzzzzzzzzzz";
		List<Permissao> listaPermissoes = this.permissaoService.buscarPorValor(valor);
		this.permissao = listaPermissoes.get(0);

		assertEquals("Não encontrou o valor correto", valor, this.permissao.getValor());
	}

	@Test
	public void salvarPermissaoComNomeJaExistenteTest() {
		this.permissao = new Permissao("alterar_titulo");
		try {
			em.getTransaction().begin();
			permissaoService.salvar(this.permissao);
			em.getTransaction().commit();
		} catch (SaadCampoDuplicadoException e) {
			em.getTransaction().rollback();
			assertEquals("O campo \"alterar_titulo\" está duplicado.", e.getMessage());
			return;
		}
		fail("Deveria ter lançado SaadCampoDuplicadoExeception");
	}

	@Test
	public void alterarValorDePermissaoExistenteTest() throws SaadCampoDuplicadoException {
		long id = 1L;
		this.permissao = permissaoService.buscarPorId(id);
		this.permissao.setValor("enviar_tcc");

		em.getTransaction().begin();
		permissaoService.salvar(this.permissao);
		em.getTransaction().commit();

		this.permissao = this.permissaoService.buscarPorId(id);
		assertEquals("Não encontrou o Id correto", "enviar_tcc", this.permissao.getValor());
	}

	@Test
	public void excluirPermissaoTest() throws Exception {
		long id = 1L;
		this.permissao = permissaoService.buscarPorId(id);

		em.getTransaction().begin();
		permissaoService.excluir(permissao);
		em.getTransaction().commit();

		this.permissao = this.permissaoService.buscarPorId(id);
		assertEquals(null, this.permissao);
	}

	@Test
	public void excluirPermissaoPorValorTest() throws Exception {
		String valor = "alterar_nota";
		em.getTransaction().begin();
		permissaoService.excluir(valor);
		em.getTransaction().commit();

		boolean resultado = this.permissaoService.buscarPorValor(valor).isEmpty();
		assertEquals("A permissão deveria ter sido apagada.", true, resultado);
	}

	@Test
	public void excluirPermissaoUtilizadaPorValorTest() throws Exception {
		try {
			em.getTransaction().begin();
			permissaoService.excluir("alterar_titulo");
			em.getTransaction().commit();
		} catch (SaadCampoEmUsoException e) {
			em.getTransaction().rollback();
			assertEquals("O campo \"alterar_titulo\" está sendo utilizado.", e.getMessage());
			return;
		}
		fail("Deveria ter lançado SaadCampoEmUsoExeception");
	}

	@Test
	public void excluirPermissaoUtilizadaTest() throws Exception {
		long id = 4L;
		this.permissao = permissaoService.buscarPorId(id);
		try {
			em.getTransaction().begin();
			permissaoService.excluir(this.permissao);
			em.getTransaction().commit();
		} catch (SaadCampoEmUsoException e) {
			em.getTransaction().rollback();
			assertEquals("O campo \"imprimir_declaracao\" está sendo utilizado.", e.getMessage());
			return;
		}
		fail("Deveria ter lançado SaadCampoEmUsoExeception");
	}
}
