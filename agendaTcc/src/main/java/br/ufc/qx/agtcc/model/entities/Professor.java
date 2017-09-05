package br.ufc.qx.agtcc.model.entities;

import java.util.*;
import javax.persistence.*;

import br.ufc.qx.agtcc.model.enums.*;

import java.io.Serializable;

@Entity
public class Professor implements Serializable {

	private static final long serialVersionUID = -8740211792761807927L;

	@Id
	@GeneratedValue
	private Long id;

	@Lob
	private Byte[] assinatura;

	@Column(nullable = true)
	private String identidade;

	@Column(nullable = true)
	private String orgaoExpedidor;

	@Column(name = "profissao")
	@Enumerated(EnumType.STRING)
	private Profissao profissao;

	@Column(name = "titulacao", nullable = false)
	@Enumerated(EnumType.STRING)
	private TitulacaoAcademica titulacaoAcademica;

	@Column(name = "tratamento", nullable = false)
	@Enumerated(EnumType.STRING)
	private FormaTratamento tratamento;

	@ManyToMany(mappedBy = "professores")
	private List<Curso> cursos;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte[] getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(Byte[] assinatura) {
		this.assinatura = assinatura;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public TitulacaoAcademica getTitulacaoAcademica() {
		return titulacaoAcademica;
	}

	public void setTitulacaoAcademica(TitulacaoAcademica titulacaoAcademica) {
		this.titulacaoAcademica = titulacaoAcademica;
	}

	public FormaTratamento getTratamento() {
		return tratamento;
	}

	public void setTratamento(FormaTratamento tratamento) {
		this.tratamento = tratamento;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 71 * hash + Objects.hashCode(this.id);
		hash = 71 * hash + Arrays.deepHashCode(this.assinatura);
		hash = 71 * hash + Objects.hashCode(this.identidade);
		hash = 71 * hash + Objects.hashCode(this.orgaoExpedidor);
		hash = 71 * hash + Objects.hashCode(this.profissao);
		hash = 71 * hash + Objects.hashCode(this.titulacaoAcademica);
		hash = 71 * hash + Objects.hashCode(this.tratamento);
		hash = 71 * hash + Objects.hashCode(this.cursos);
		hash = 71 * hash + Objects.hashCode(this.usuario);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Professor other = (Professor) obj;
		if (!Objects.equals(this.identidade, other.identidade)) {
			return false;
		}
		if (!Objects.equals(this.orgaoExpedidor, other.orgaoExpedidor)) {
			return false;
		}
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (!Arrays.deepEquals(this.assinatura, other.assinatura)) {
			return false;
		}
		if (this.profissao != other.profissao) {
			return false;
		}
		if (this.titulacaoAcademica != other.titulacaoAcademica) {
			return false;
		}
		if (this.tratamento != other.tratamento) {
			return false;
		}
		if (!Objects.equals(this.cursos, other.cursos)) {
			return false;
		}
		return Objects.equals(this.usuario, other.usuario);
	}

}
