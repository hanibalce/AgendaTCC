package br.ufc.qx.agtcc.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.qx.agtcc.model.entities.Curso;
import br.ufc.qx.agtcc.model.entities.LocalDeDefesa;
import br.ufc.qx.agtcc.model.entities.Matricula;
import br.ufc.qx.agtcc.model.entities.Professor;
import br.ufc.qx.agtcc.model.entities.Turma;
import br.ufc.qx.agtcc.util.Pair;

public class LocaisDeDefesas {

	private EntityManager em;
	private LocalDeDefesa localDeDefesa = new LocalDeDefesa();
	private List<LocalDeDefesa> locaisDeDefesa = new ArrayList<LocalDeDefesa>();

	public LocaisDeDefesas(EntityManager em) {
		super();
		this.em = em;
	}

	
	public void salvar(LocalDeDefesa localDeDefesa) {
		em.persist(localDeDefesa);
		em.flush();
	}

	
	public void atualizar(LocalDeDefesa localDeDefesa) {
		localDeDefesa = em.merge(localDeDefesa);
		em.persist(localDeDefesa);
		em.flush();

	}

	
	public void excluir(LocalDeDefesa localDeDefesa) {
		localDeDefesa = em.merge(localDeDefesa);
		em.remove(localDeDefesa);
		em.flush();

	}

	
	public LocalDeDefesa porId(Long id) {
		this.localDeDefesa = em.find(LocalDeDefesa.class, id);
		return this.localDeDefesa;
	}

	
	public List<LocalDeDefesa> todos() {
		TypedQuery<LocalDeDefesa> query = em.createQuery("from LocalDeDefesa d", LocalDeDefesa.class);
		this.locaisDeDefesa = query.getResultList();
		return this.locaisDeDefesa;
	}

	
	public List<LocalDeDefesa> todosPorCurso(Curso curso) {
		String query = "Select d from LocalDeDefesa d where d.curso = :curso";
		List<Pair<Object, String>> argumentos = new ArrayList<Pair<Object, String>>();
		argumentos.add(new Pair<Object, String>(curso, "curso"));
		this.locaisDeDefesa = this.consulta(query, argumentos);
		return this.locaisDeDefesa;
	}

	
	public List<LocalDeDefesa> porNomeDoLocal(String nomeDolocal, Curso curso) {
		String query = "Select d from LocalDeDefesa d where d.curso = :curso and d.nomeDolocal =:nomeDolocal";
		List<Pair<Object, String>> argumentos = new ArrayList<Pair<Object, String>>();
		argumentos.add(new Pair<Object, String>(curso, "curso"));
		argumentos.add(new Pair<Object, String>(nomeDolocal, "nomeDolocal"));
		this.locaisDeDefesa = this.consulta(query, argumentos);
		return this.locaisDeDefesa;
	}

	
	public List<LocalDeDefesa> porDataDeDefesa(Date dataDefesa, Curso curso) {
		String query = "Select d from LocalDeDefesa d where d.curso = :curso and d.dataDefesa = :dataDefesa";
		List<Pair<Object, String>> argumentos = new ArrayList<Pair<Object, String>>();
		argumentos.add(new Pair<Object, String>(curso, "curso"));
		argumentos.add(new Pair<Object, String>(dataDefesa, "dataDefesa"));
		this.locaisDeDefesa = this.consulta(query, argumentos);
		return this.locaisDeDefesa;
	}

	
	public List<LocalDeDefesa> porDataELocal(Date dataDefesa, String nomeDolocal, Curso curso) {
		String query = "Select d from LocalDeDefesa d where d.curso = :curso and d.dataDefesa = :dataDefesa and d.nomeDolocal like :nomeDolocal";
		List<Pair<Object, String>> argumentos = new ArrayList<Pair<Object, String>>();
		argumentos.add(new Pair<Object, String>(curso, "curso"));
		argumentos.add(new Pair<Object, String>(dataDefesa, "dataDefesa"));
		argumentos.add(new Pair<Object, String>(nomeDolocal, "nomeDolocal"));
		this.locaisDeDefesa = this.consulta(query, argumentos);
		return this.locaisDeDefesa;
	}

	
	public List<LocalDeDefesa> porDataEHora(Date dataDefesa, Date horaDefesa, Curso curso) {
		String query = "Select d from LocalDeDefesa d where d.curso = :curso and d.dataDefesa = :dataDefesa and d.horaDefesa = :horaDefesa";
		List<Pair<Object, String>> argumentos = new ArrayList<Pair<Object, String>>();
		argumentos.add(new Pair<Object, String>(curso, "curso"));
		argumentos.add(new Pair<Object, String>(dataDefesa, "dataDefesa"));
		argumentos.add(new Pair<Object, String>(horaDefesa, "horaDefesa"));
		this.locaisDeDefesa = this.consulta(query, argumentos);
		return this.locaisDeDefesa;
	}

	
	public List<LocalDeDefesa> porDataHoraELocal(Date dataDefesa, Date horaDefesa, String nomeDolocal, Curso curso) {
		String query = "Select d from LocalDeDefesa d where d.curso = :curso and d.dataDefesa = :dataDefesa and d.horaDefesa = :horaDefesa and d.nomeDolocal like :nomeDolocal";
		List<Pair<Object, String>> argumentos = new ArrayList<Pair<Object, String>>();
		argumentos.add(new Pair<Object, String>(curso, "curso"));
		argumentos.add(new Pair<Object, String>(dataDefesa, "dataDefesa"));
		argumentos.add(new Pair<Object, String>(horaDefesa, "horaDefesa"));
		argumentos.add(new Pair<Object, String>(nomeDolocal, "nomeDolocal"));
		this.locaisDeDefesa = this.consulta(query, argumentos);
		return this.locaisDeDefesa;
	}

	
	public List<LocalDeDefesa> porMatricula(Matricula matricula) {
		String query = "Select d from LocalDeDefesa d where :matricula MEMBER OF d.matricula";
		List<Pair<Object, String>> argumentos = new ArrayList<Pair<Object, String>>();
		argumentos.add(new Pair<Object, String>(matricula, "matricula"));
		this.locaisDeDefesa = this.consulta(query, argumentos);
		return this.locaisDeDefesa;
	}

	
	public List<LocalDeDefesa> porProfessor(Professor professor, Curso curso) {
		String query = "Select d from LocalDeDefesa d where :professor MEMBER OF d.professor and d.curso = :curso";
		List<Pair<Object, String>> argumentos = new ArrayList<Pair<Object, String>>();
		argumentos.add(new Pair<Object, String>(professor, "professor"));
		argumentos.add(new Pair<Object, String>(curso, "curso"));
		this.locaisDeDefesa = this.consulta(query, argumentos);
		return this.locaisDeDefesa;
	}

	
	public List<LocalDeDefesa> porTurma(Turma turma) {
		String query = "Select d from LocalDeDefesa d where :turma MEMBER OF d.turma and d.curso = :curso";
		List<Pair<Object, String>> argumentos = new ArrayList<Pair<Object, String>>();
		argumentos.add(new Pair<Object, String>(turma, "turma"));
		argumentos.add(new Pair<Object, String>(turma.getCurso(), "curso"));
		this.locaisDeDefesa = this.consulta(query, argumentos);
		return this.locaisDeDefesa;
	}

	public List<LocalDeDefesa> consulta(String qlString, List<Pair<Object, String>> parametros) {
		TypedQuery<LocalDeDefesa> query = em.createQuery(qlString, LocalDeDefesa.class);

		for (Pair<Object, String> pair : parametros) {
			query.setParameter(pair.right, pair.left);
		}
		this.locaisDeDefesa = query.getResultList();
		return this.locaisDeDefesa;
	}
}
