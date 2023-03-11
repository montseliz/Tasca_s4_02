package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Anotacions @NoArgsConstructor, @Getter, @Setter i @ToString de la llibreria Lombok, que s'utilitzen
 * per generar automàticament el constructor buit i els mètodes getters, setters i toString.
 * Eviten la necessitat d'escriure codi repetitiu.
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "fruits")
public class Fruit {

    @Id
    private ObjectId id;
    private String name;
    private int quantityKg;

    public Fruit(String name, int quantityKg) {
        this.name = name;
        this.quantityKg = quantityKg;
    }

}
