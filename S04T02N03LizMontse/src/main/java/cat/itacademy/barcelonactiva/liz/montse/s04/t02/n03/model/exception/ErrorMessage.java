package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

/**
 * Anotacions @AllArgsConstructor i @Getter de la llibreria Lombok, que s'utilitzen
 * per generar automàticament el constructor ple i els mètodes getters.
 * Eviten la necessitat d'escriure codi repetitiu.
 */
@AllArgsConstructor
@Getter
public class ErrorMessage {

    private int statusCode;
    private Date timestamp;
    private String textError;
    private String description;

}
