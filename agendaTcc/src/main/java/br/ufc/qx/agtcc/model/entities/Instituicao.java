package br.ufc.qx.agtcc.model.entities;


import javax.persistence.*;

import br.ufc.qx.agtcc.model.enums.TipoInstituicao;

import java.io.Serializable;

@Entity
public class Instituicao implements Serializable {

	private static final long serialVersionUID = 4051331821950381308L;

	@Id
    private Long id;

    @Column(unique = true)
    private String sigla;

    private String descricao;

    @Column(unique = true)
    private String cnpj;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

    @Column(name = "tipo_instituicao", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoInstituicao tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TipoInstituicao getTipo() {
        return tipo;
    }

    public void setTipo(TipoInstituicao tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
        Instituicao other = (Instituicao) obj;
        if (cnpj == null) {
            if (other.cnpj != null) {
                return false;
            }
        } else if (!cnpj.equals(other.cnpj)) {
            return false;
        }
        if (descricao == null) {
            if (other.descricao != null) {
                return false;
            }
        } else if (!descricao.equals(other.descricao)) {
            return false;
        }
        if (endereco == null) {
            if (other.endereco != null) {
                return false;
            }
        } else if (!endereco.equals(other.endereco)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (sigla == null) {
            if (other.sigla != null) {
                return false;
            }
        } else if (!sigla.equals(other.sigla)) {
            return false;
        }
        if (tipo != other.tipo) {
            return false;
        }
        return true;
    }
}
