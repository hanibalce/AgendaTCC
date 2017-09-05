package br.ufc.qx.agtcc.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Disciplina implements Serializable {

	private static final long serialVersionUID = -6813645492697943604L;

	@Id
    @GeneratedValue
    private Long id;

    private Long idMoodle;

    private Double media;

    private String codigo;

    private String nome;

    private String sigla;

    private Short creditos;

    private Double cargaHoraria;

    private String codigoExterno;

    @OneToMany
    private List<Atividade> atividades;

    @OneToOne
    private Curso curso;

    @OneToMany
    private List<Professor> professor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMoodle() {
        return idMoodle;
    }

    public void setIdMoodle(Long idMoodle) {
        this.idMoodle = idMoodle;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Short getCreditos() {
        return creditos;
    }

    public void setCreditos(Short creditos) {
        this.creditos = creditos;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCodigoExterno() {
        return codigoExterno;
    }

    public void setCodigoExterno(String codigoExterno) {
        this.codigoExterno = codigoExterno;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Professor> getProfessor() {
        return professor;
    }

    public void setProfessor(List<Professor> professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((atividades == null) ? 0 : atividades.hashCode());
        result = prime * result + ((cargaHoraria == null) ? 0 : cargaHoraria.hashCode());
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        result = prime * result + ((codigoExterno == null) ? 0 : codigoExterno.hashCode());
        result = prime * result + ((creditos == null) ? 0 : creditos.hashCode());
        result = prime * result + ((curso == null) ? 0 : curso.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((idMoodle == null) ? 0 : idMoodle.hashCode());
        result = prime * result + ((media == null) ? 0 : media.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((professor == null) ? 0 : professor.hashCode());
        result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
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
        Disciplina other = (Disciplina) obj;
        if (atividades == null) {
            if (other.atividades != null) {
                return false;
            }
        } else if (!atividades.equals(other.atividades)) {
            return false;
        }
        if (cargaHoraria == null) {
            if (other.cargaHoraria != null) {
                return false;
            }
        } else if (!cargaHoraria.equals(other.cargaHoraria)) {
            return false;
        }
        if (codigo == null) {
            if (other.codigo != null) {
                return false;
            }
        } else if (!codigo.equals(other.codigo)) {
            return false;
        }
        if (codigoExterno == null) {
            if (other.codigoExterno != null) {
                return false;
            }
        } else if (!codigoExterno.equals(other.codigoExterno)) {
            return false;
        }
        if (creditos == null) {
            if (other.creditos != null) {
                return false;
            }
        } else if (!creditos.equals(other.creditos)) {
            return false;
        }
        if (curso == null) {
            if (other.curso != null) {
                return false;
            }
        } else if (!curso.equals(other.curso)) {
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
        if (media == null) {
            if (other.media != null) {
                return false;
            }
        } else if (!media.equals(other.media)) {
            return false;
        }
        if (nome == null) {
            if (other.nome != null) {
                return false;
            }
        } else if (!nome.equals(other.nome)) {
            return false;
        }
        if (professor == null) {
            if (other.professor != null) {
                return false;
            }
        } else if (!professor.equals(other.professor)) {
            return false;
        }
        if (sigla == null) {
            if (other.sigla != null) {
                return false;
            }
        } else if (!sigla.equals(other.sigla)) {
            return false;
        }
        return true;
    }

}
