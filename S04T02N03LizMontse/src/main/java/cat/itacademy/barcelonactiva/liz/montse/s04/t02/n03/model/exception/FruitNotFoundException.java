package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.exception;

import java.io.Serial;

public class FruitNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FruitNotFoundException(String message) {
        super(message);
    }

}
