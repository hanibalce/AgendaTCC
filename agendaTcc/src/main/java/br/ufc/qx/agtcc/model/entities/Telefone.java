package br.ufc.qx.agtcc.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.ufc.qx.agtcc.model.enums.Operadora;

import java.io.Serializable;

@Entity
public class Telefone implements Serializable {

	private static final long serialVersionUID = 7659366634651070088L;

	@Id
    @GeneratedValue
    private Long id;

    private Short ddi;

    private Short ddd;

    @Column(name = "operadora", nullable = false)
    @Enumerated(EnumType.STRING)
    private Operadora operadora;

    private Short numero;

    @Column(name = "fixo", columnDefinition = "BIT", length = 1)
    private boolean fixo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getDdi() {
        return ddi;
    }

    public void setDdi(Short ddi) {
        this.ddi = ddi;
    }

    public Short getDdd() {
        return ddd;
    }

    public void setDdd(Short ddd) {
        this.ddd = ddd;
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }

    public Short getNumero() {
        return numero;
    }

    public void setNumero(Short numero) {
        this.numero = numero;
    }

    public boolean isFixo() {
        return fixo;
    }

    public void setFixo(boolean fixo) {
        this.fixo = fixo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
        result = prime * result + ((ddi == null) ? 0 : ddi.hashCode());
        result = prime * result + (fixo ? 1231 : 1237);
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        result = prime * result + ((operadora == null) ? 0 : operadora.hashCode());
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
        Telefone other = (Telefone) obj;
        if (ddd == null) {
            if (other.ddd != null) {
                return false;
            }
        } else if (!ddd.equals(other.ddd)) {
            return false;
        }
        if (ddi == null) {
            if (other.ddi != null) {
                return false;
            }
        } else if (!ddi.equals(other.ddi)) {
            return false;
        }
        if (fixo != other.fixo) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (numero == null) {
            if (other.numero != null) {
                return false;
            }
        } else if (!numero.equals(other.numero)) {
            return false;
        }
        if (operadora != other.operadora) {
            return false;
        }
        return true;
    }

}
