package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

/**
 * Objecte de transferència de dades entre el client i el servidor.
 * Anotacions de la llibreria lombok, que eviten escriure codi repetitiu.
 */
@AllArgsConstructor
@Getter
public class Message {

    private int statusCode;
    private Date timestamp;
    private String textMessage;
    private String description;

}
