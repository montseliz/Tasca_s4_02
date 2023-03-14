package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.dto;

import lombok.*;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;

/**
 * Objecte de transferència de dades entre el client i el servidor.
 * Anotacions de la llibreria lombok, que eviten escriure codi repetitiu.
 * Anotacions @NotBlank i @Min funcionen només quan apliquem el @Valid a la classe FruitController.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FruitDto {

    //@NotBlank
    private String name;

    //@Min(1)
    private int quantityKg;

}
