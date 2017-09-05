package br.ufc.qx.agtcc.model.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import br.ufc.qx.agtcc.model.enums.StatusTcc;

import java.io.Serializable;

@Entity
public class Tcc implements Serializable {

	private static final long serialVersionUID = -6155942593408364964L;

	@Id
    @GeneratedValue
    private Long id;

    private String titulo;

    @Lob
    @Column(length = 3000)
    private String resumo;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tcc_palavraschaves")
    private List<String> palavrasChaves = new ArrayList<>();

    @OneToOne
    private Matricula matriculaAluno;

    @OneToOne
    private Professor orientador;

    @Column(name = "status_tcc", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTcc status;

    @OneToOne
    private Curso curso;

    @OneToOne
    private Defesa defesa;

    @OneToMany
    private List<Documento> documentos;

    @OneToMany
    private Collection<Professor> bancaDeDefesa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public List<String> getPalavrasChaves() {
        return palavrasChaves;
    }

    public void setPalavrasChaves(List<String> palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    public Matricula getMatricula() {
        return matriculaAluno;
    }

    public void setMatricula(Matricula matricula) {
        this.matriculaAluno = matricula;
    }

    public Professor getOrientador() {
        return orientador;
    }

    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }

    public StatusTcc getStatus() {
        return status;
    }

    public void setStatus(StatusTcc status) {
        this.status = status;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Defesa getDefesa() {
        return defesa;
    }

    public void setDefesa(Defesa defesa) {
        this.defesa = defesa;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public Collection<Professor> getBancaDeDefesa() {
        return bancaDeDefesa;
    }

    public void setBancaDeDefesa(Collection<Professor> bancaDeDefesa) {
        this.bancaDeDefesa = bancaDeDefesa;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bancaDeDefesa == null) ? 0 : bancaDeDefesa.hashCode());
        result = prime * result + ((curso == null) ? 0 : curso.hashCode());
        result = prime * result + ((defesa == null) ? 0 : defesa.hashCode());
        result = prime * result + ((documentos == null) ? 0 : documentos.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((matriculaAluno == null) ? 0 : matriculaAluno.hashCode());
        result = prime * result + ((orientador == null) ? 0 : orientador.hashCode());
        result = prime * result + ((palavrasChaves == null) ? 0 : palavrasChaves.hashCode());
        result = prime * result + ((resumo == null) ? 0 : resumo.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
        Tcc other = (Tcc) obj;
        if (bancaDeDefesa == null) {
            if (other.bancaDeDefesa != null) {
                return false;
            }
        } else if (!bancaDeDefesa.equals(other.bancaDeDefesa)) {
            return false;
        }
        if (curso == null) {
            if (other.curso != null) {
                return false;
            }
        } else if (!curso.equals(other.curso)) {
            return false;
        }
        if (defesa == null) {
            if (other.defesa != null) {
                return false;
            }
        } else if (!defesa.equals(other.defesa)) {
            return false;
        }
        if (documentos == null) {
            if (other.documentos != null) {
                return false;
            }
        } else if (!documentos.equals(other.documentos)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (matriculaAluno == null) {
            if (other.matriculaAluno != null) {
                return false;
            }
        } else if (!matriculaAluno.equals(other.matriculaAluno)) {
            return false;
        }
        if (orientador == null) {
            if (other.orientador != null) {
                return false;
            }
        } else if (!orientador.equals(other.orientador)) {
            return false;
        }
        if (palavrasChaves == null) {
            if (other.palavrasChaves != null) {
                return false;
            }
        } else if (!palavrasChaves.equals(other.palavrasChaves)) {
            return false;
        }
        if (resumo == null) {
            if (other.resumo != null) {
                return false;
            }
        } else if (!resumo.equals(other.resumo)) {
            return false;
        }
        if (status != other.status) {
            return false;
        }
        if (titulo == null) {
            if (other.titulo != null) {
                return false;
            }
        } else if (!titulo.equals(other.titulo)) {
            return false;
        }
        return true;
    }

}
