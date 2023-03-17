package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n01.model.domain;

import jakarta.persistence.*;

/**
 * Classe que representa la taula de la base de dades. El paquet domain s'utilitza per encapsular les classes que
 * representen els objectes de domini d'una aplicació.
 */
@Entity
@Table(name = "Fruits")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "quantityKg")
    private int quantityKg;

    protected Fruit() {
    }

    public Fruit(String name, int quantityKg) {
        this.name = name;
        this.quantityKg = quantityKg;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityKg() {
        return quantityKg;
    }

    public void setQuantityKg(int quantityKg) {
        this.quantityKg = quantityKg;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantityKg=" + quantityKg +
                '}';
    }
}
