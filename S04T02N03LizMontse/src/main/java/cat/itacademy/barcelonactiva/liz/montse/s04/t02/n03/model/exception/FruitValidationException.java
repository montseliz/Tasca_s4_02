package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.exception;

import java.io.Serial;

public class FruitValidationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FruitValidationException(String message) {
        super(message);
    }

}
