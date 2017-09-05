package br.ufc.qx.agtcc.model.entities;

import javax.persistence.*;

import br.ufc.qx.agtcc.model.enums.TipoLogradouro;

import java.io.Serializable;

@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1687586344519410824L;

	@Id
    @GeneratedValue
    private long id;

    private String endereco;

    private Integer numero;

    private String complemento;

    private String bairro;

    private String municipio;

    private String uf;

    private Integer cep;

    private String googleAdress;

    private Double latitude;

    private Double longitude;

    @Column(name = "tipo_logradouro")
    @Enumerated(EnumType.STRING)
    private TipoLogradouro logradouro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getGoogleAdress() {
        return googleAdress;
    }

    public void setGoogleAdress(String googleAdress) {
        this.googleAdress = googleAdress;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public TipoLogradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(TipoLogradouro logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
        result = prime * result + ((cep == null) ? 0 : cep.hashCode());
        result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        result = prime * result + ((googleAdress == null) ? 0 : googleAdress.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
        result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
        Endereco other = (Endereco) obj;
        if (bairro == null) {
            if (other.bairro != null) {
                return false;
            }
        } else if (!bairro.equals(other.bairro)) {
            return false;
        }
        if (cep == null) {
            if (other.cep != null) {
                return false;
            }
        } else if (!cep.equals(other.cep)) {
            return false;
        }
        if (complemento == null) {
            if (other.complemento != null) {
                return false;
            }
        } else if (!complemento.equals(other.complemento)) {
            return false;
        }
        if (endereco == null) {
            if (other.endereco != null) {
                return false;
            }
        } else if (!endereco.equals(other.endereco)) {
            return false;
        }
        if (googleAdress == null) {
            if (other.googleAdress != null) {
                return false;
            }
        } else if (!googleAdress.equals(other.googleAdress)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (latitude == null) {
            if (other.latitude != null) {
                return false;
            }
        } else if (!latitude.equals(other.latitude)) {
            return false;
        }
        if (logradouro != other.logradouro) {
            return false;
        }
        if (longitude == null) {
            if (other.longitude != null) {
                return false;
            }
        } else if (!longitude.equals(other.longitude)) {
            return false;
        }
        if (municipio == null) {
            if (other.municipio != null) {
                return false;
            }
        } else if (!municipio.equals(other.municipio)) {
            return false;
        }
        if (numero == null) {
            if (other.numero != null) {
                return false;
            }
        } else if (!numero.equals(other.numero)) {
            return false;
        }
        if (uf == null) {
            if (other.uf != null) {
                return false;
            }
        } else if (!uf.equals(other.uf)) {
            return false;
        }
        return true;
    }

}
