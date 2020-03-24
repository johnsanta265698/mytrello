package co.com.mytrello.repository.domain;
import co.com.mytrello.repository.domain.support.Entities;

import javax.persistence.*;

@Entity
@Table(name = "listas")
public class Lista extends Entities {

    @Column(name = "nombre", nullable = false, length = 80)
    private String nombreLista;

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }
}
