package br.ufc.qx.agtcc.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.ufc.qx.agtcc.model.enums.*;

import java.io.Serializable;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 863969702519313932L;

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private List<Matricula> matriculas;

	@Column(name = "profissao")
	@Enumerated(EnumType.STRING)
	private Profissao profissao;

	@Column(name = "nacionalidade")
	@Enumerated(EnumType.STRING)
	private Nacionalidade nacionalidade;

	@Column(name = "genero", nullable = false)
	@Enumerated(EnumType.STRING)
	private Genero genero;

	private String nomeSocial;

	private String identidade;

	private String orgaoExpedidor;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private List<Telefone> telefones;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Endereco endereco;

	@Column(name = "tratamento", nullable = false)
	@Enumerated(EnumType.STRING)
	private FormaTratamento tratamento;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataDeNascimento;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public Nacionalidade getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(Nacionalidade nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
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

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public FormaTratamento getTratamento() {
		return tratamento;
	}

	public void setTratamento(FormaTratamento tratamento) {
		this.tratamento = tratamento;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDeNascimento == null) ? 0 : dataDeNascimento.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identidade == null) ? 0 : identidade.hashCode());
		result = prime * result + ((matriculas == null) ? 0 : matriculas.hashCode());
		result = prime * result + ((nacionalidade == null) ? 0 : nacionalidade.hashCode());
		result = prime * result + ((nomeSocial == null) ? 0 : nomeSocial.hashCode());
		result = prime * result + ((orgaoExpedidor == null) ? 0 : orgaoExpedidor.hashCode());
		result = prime * result + ((profissao == null) ? 0 : profissao.hashCode());
		result = prime * result + ((telefones == null) ? 0 : telefones.hashCode());
		result = prime * result + ((tratamento == null) ? 0 : tratamento.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
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
		Aluno other = (Aluno) obj;
		if (dataDeNascimento == null) {
			if (other.dataDeNascimento != null) {
				return false;
			}
		} else if (!dataDeNascimento.equals(other.dataDeNascimento)) {
			return false;
		}
		if (endereco == null) {
			if (other.endereco != null) {
				return false;
			}
		} else if (!endereco.equals(other.endereco)) {
			return false;
		}
		if (genero != other.genero) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (identidade == null) {
			if (other.identidade != null) {
				return false;
			}
		} else if (!identidade.equals(other.identidade)) {
			return false;
		}
		if (matriculas == null) {
			if (other.matriculas != null) {
				return false;
			}
		} else if (!matriculas.equals(other.matriculas)) {
			return false;
		}
		if (nacionalidade != other.nacionalidade) {
			return false;
		}
		if (nomeSocial == null) {
			if (other.nomeSocial != null) {
				return false;
			}
		} else if (!nomeSocial.equals(other.nomeSocial)) {
			return false;
		}
		if (orgaoExpedidor == null) {
			if (other.orgaoExpedidor != null) {
				return false;
			}
		} else if (!orgaoExpedidor.equals(other.orgaoExpedidor)) {
			return false;
		}
		if (profissao != other.profissao) {
			return false;
		}
		if (telefones == null) {
			if (other.telefones != null) {
				return false;
			}
		} else if (!telefones.equals(other.telefones)) {
			return false;
		}
		if (tratamento != other.tratamento) {
			return false;
		}
		if (usuario == null) {
			if (other.usuario != null) {
				return false;
			}
		} else if (!usuario.equals(other.usuario)) {
			return false;
		}
		return true;
	}

}
