package br.ufc.qx.agtcc.model.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Curso implements Serializable {

	private static final long serialVersionUID = 5873904911105568047L;

	@Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nome;

    private String descricao;

    @Column(name = "ativo", columnDefinition = "BIT", length = 1)
    private Boolean ativo;

    private Double mediaDeAprovacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataDeInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataDeTermino;

    @OneToOne
    private BDMoodle bdMoodle;

    private Long idMoodle;

    @ManyToMany
    @JoinTable(name = "curso_instituicao", joinColumns = {
        @JoinColumn(name = "curso_id")}, inverseJoinColumns = {
        @JoinColumn(name = "instituicao_id")})
    private List<Instituicao> institutosDeEnsino;

    @ManyToMany
    @JoinTable(name = "curso_professor", joinColumns = {
        @JoinColumn(name = "curso_id")}, inverseJoinColumns = {
        @JoinColumn(name = "professor_id")})
    private List<Professor> professores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Double getMediaDeAprovacao() {
        return mediaDeAprovacao;
    }

    public void setMediaDeAprovacao(Double mediaDeAprovacao) {
        this.mediaDeAprovacao = mediaDeAprovacao;
    }

    public Date getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(Date dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public Date getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeTermino(Date dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
    }

    public BDMoodle getBdMoodle() {
        return bdMoodle;
    }

    public void setBdMoodle(BDMoodle bdMoodle) {
        this.bdMoodle = bdMoodle;
    }

    public Long getIdMoodle() {
        return idMoodle;
    }

    public void setIdMoodle(Long idMoodle) {
        this.idMoodle = idMoodle;
    }

    public List<Instituicao> getInstitutosDeEnsino() {
        return institutosDeEnsino;
    }

    public void setInstitutosDeEnsino(List<Instituicao> institutosDeEnsino) {
        this.institutosDeEnsino = institutosDeEnsino;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
        result = prime * result + ((bdMoodle == null) ? 0 : bdMoodle.hashCode());
        result = prime * result + ((dataDeInicio == null) ? 0 : dataDeInicio.hashCode());
        result = prime * result + ((dataDeTermino == null) ? 0 : dataDeTermino.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((idMoodle == null) ? 0 : idMoodle.hashCode());
        result = prime * result + ((institutosDeEnsino == null) ? 0 : institutosDeEnsino.hashCode());
        result = prime * result + ((mediaDeAprovacao == null) ? 0 : mediaDeAprovacao.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((professores == null) ? 0 : professores.hashCode());
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
        Curso other = (Curso) obj;
        if (ativo == null) {
            if (other.ativo != null) {
                return false;
            }
        } else if (!ativo.equals(other.ativo)) {
            return false;
        }
        if (bdMoodle == null) {
            if (other.bdMoodle != null) {
                return false;
            }
        } else if (!bdMoodle.equals(other.bdMoodle)) {
            return false;
        }
        if (dataDeInicio == null) {
            if (other.dataDeInicio != null) {
                return false;
            }
        } else if (!dataDeInicio.equals(other.dataDeInicio)) {
            return false;
        }
        if (dataDeTermino == null) {
            if (other.dataDeTermino != null) {
                return false;
            }
        } else if (!dataDeTermino.equals(other.dataDeTermino)) {
            return false;
        }
        if (descricao == null) {
            if (other.descricao != null) {
                return false;
            }
        } else if (!descricao.equals(other.descricao)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (idMoodle == null) {
            if (other.idMoodle != null) {
                return false;
            }
        } else if (!idMoodle.equals(other.idMoodle)) {
            return false;
        }
        if (institutosDeEnsino == null) {
            if (other.institutosDeEnsino != null) {
                return false;
            }
        } else if (!institutosDeEnsino.equals(other.institutosDeEnsino)) {
            return false;
        }
        if (mediaDeAprovacao == null) {
            if (other.mediaDeAprovacao != null) {
                return false;
            }
        } else if (!mediaDeAprovacao.equals(other.mediaDeAprovacao)) {
            return false;
        }
        if (nome == null) {
            if (other.nome != null) {
                return false;
            }
        } else if (!nome.equals(other.nome)) {
            return false;
        }
        if (professores == null) {
            if (other.professores != null) {
                return false;
            }
        } else if (!professores.equals(other.professores)) {
            return false;
        }
        return true;
    }
}
