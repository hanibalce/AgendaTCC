package br.ufc.qx.agtcc.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import br.ufc.qx.agtcc.model.enums.TipoDocumento;

@Entity
public class Documento implements Serializable {

	private static final long serialVersionUID = -2746961689694742723L;

	@Id
	@GeneratedValue
	private Long id;

	private String descricao;

	private String nome;

	private String diretorio;

	@Column(name = "tipo_documento")
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDeDocumento;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataEntrega;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiretorio() {
		return diretorio;
	}

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

	public TipoDocumento getTipoDeDocumento() {
		return tipoDeDocumento;
	}

	public void setTipoDeDocumento(TipoDocumento tipoDeDocumento) {
		this.tipoDeDocumento = tipoDeDocumento;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEntrega == null) ? 0 : dataEntrega.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((diretorio == null) ? 0 : diretorio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipoDeDocumento == null) ? 0 : tipoDeDocumento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		if (dataEntrega == null) {
			if (other.dataEntrega != null)
				return false;
		} else if (!dataEntrega.equals(other.dataEntrega))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (diretorio == null) {
			if (other.diretorio != null)
				return false;
		} else if (!diretorio.equals(other.diretorio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipoDeDocumento == null) {
			if (other.tipoDeDocumento != null)
				return false;
		} else if (!tipoDeDocumento.equals(other.tipoDeDocumento))
			return false;
		return true;
	}

}
