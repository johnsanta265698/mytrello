package co.com.mytrello.repository.domain;
import co.com.mytrello.repository.domain.support.Entities;

import javax.persistence.*;

@Entity
@Table(name = "tareas")
public class Tarea extends Entities {


    @Column(name = "titulo", nullable = false, length = 80)
    private String titulo;
    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lista_id_fk", referencedColumnName = "id")
    private Lista lista;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
