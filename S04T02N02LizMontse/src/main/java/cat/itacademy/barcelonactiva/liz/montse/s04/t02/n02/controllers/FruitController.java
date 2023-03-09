package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n02.controllers;

import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n02.model.dto.FruitDto;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n02.model.dto.Message;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n02.model.services.FruitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Mètodes que es corresponen amb els diferents endpoints de l'API RESTful. Cadascun manipula una sol·licitud HTTP
 * específica i retorna una resposta HTTP.
 */
@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitServices fruitServices;

    @PostMapping("/add")
    public ResponseEntity<Message> addFruit(@RequestBody FruitDto fruitDto) {
        ResponseEntity<Message> validationResult = fruitServices.validateFruitDto(fruitDto);

        if (validationResult.getStatusCode() == HttpStatus.OK) {
            fruitServices.createFruit(fruitDto);
            return new ResponseEntity<>(new Message("Fruit created correctly."), HttpStatus.CREATED);
        } else {
            return validationResult;
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Message> updateFruit(@PathVariable("id") int id, @RequestBody FruitDto fruitDto) {
        ResponseEntity<Message> validationResult = fruitServices.validateFruitDto(fruitDto);
        ResponseEntity<Message> checkId = fruitServices.validateFruitId(id);

        if (checkId.getStatusCode() == HttpStatus.OK) {
            if (validationResult.getStatusCode() == HttpStatus.OK) {
                fruitServices.updateFruitById(id, fruitDto);
                return new ResponseEntity<>(new Message("Fruit updated."), HttpStatus.OK);
            } else {
                return validationResult;
            }
        } else {
            return checkId;
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> deleteFruit(@PathVariable("id") int id) {
        ResponseEntity<Message> checkId = fruitServices.validateFruitId(id);

        if (checkId.getStatusCode() == HttpStatus.OK) {
            fruitServices.deleteFruitById(id);
            return new ResponseEntity<>(new Message("Fruit removed."), HttpStatus.OK);
        } else {
            return checkId;
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getFruitById(@PathVariable("id") int id) {
        ResponseEntity<Message> checkId = fruitServices.validateFruitId(id);

        if (checkId.getStatusCode() == HttpStatus.OK) {
            return new ResponseEntity<>(fruitServices.getFruitById(id), HttpStatus.OK);
        } else {
            return checkId;
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {

        List<Fruit> fruits = fruitServices.fruitsList();
        if (!fruits.isEmpty()) {
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

}
