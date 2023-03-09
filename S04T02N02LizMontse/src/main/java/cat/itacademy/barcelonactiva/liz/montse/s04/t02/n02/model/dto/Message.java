package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n02.model.dto;

/**
 * Paquet on es creen les classes que es limiten a ser objectes de transferència de dades entre el client i el servidor.
 */
public class Message {

    private String messageBody;

    public Message (String message) {
        this.messageBody = message;
    }

    public String getMessage() {
        return messageBody;
    }

    public void setMessage(String message) {
        this.messageBody = message;
    }

}
