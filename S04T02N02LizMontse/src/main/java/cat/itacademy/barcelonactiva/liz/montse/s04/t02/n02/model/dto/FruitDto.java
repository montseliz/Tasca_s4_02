package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n02.model.dto;

/**
 * Objecte de transferència de dades entre el client i el servidor.
 */
public class FruitDto {

    private String name;

    private int quantityKg;

    public FruitDto() {
    }

    public FruitDto(String name, int quantityKg) {
        this.name = name;
        this.quantityKg = quantityKg;
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
        return "FruitDto{" +
                "name='" + name + '\'' +
                ", quantityKg=" + quantityKg +
                '}';
    }
}
