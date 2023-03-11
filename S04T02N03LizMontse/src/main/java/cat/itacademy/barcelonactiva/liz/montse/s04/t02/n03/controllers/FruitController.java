package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.controllers;

import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.dto.FruitDto;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.dto.Message;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.services.FruitServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
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
    public ResponseEntity<?> addFruit(@RequestBody FruitDto fruitDto, WebRequest request) {
        ResponseEntity<Message> validationResult = fruitServices.validateFruitDto(fruitDto, request);

        if (validationResult.getStatusCode() == HttpStatus.OK) {
            fruitServices.createFruit(fruitDto);
            return new ResponseEntity<>(new Message(HttpStatus.CREATED.value(), new Date(), "Fruit created correctly.", request.getDescription(false)), HttpStatus.CREATED);
        } else {
            return validationResult;
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Message> updateFruit(@PathVariable("id") ObjectId id, @RequestBody FruitDto fruitDto, WebRequest request) {
        ResponseEntity<Message> validationResult = fruitServices.validateFruitDto(fruitDto, request);
        ResponseEntity<Message> checkId = fruitServices.validateFruitId(id, request);

        if (checkId.getStatusCode() == HttpStatus.OK) {
            if (validationResult.getStatusCode() == HttpStatus.OK) {
                fruitServices.updateFruitById(id, fruitDto);
                return new ResponseEntity<>(new Message(HttpStatus.OK.value(), new Date(),"Fruit updated correctly.", request.getDescription(false)), HttpStatus.OK);
            } else {
                return validationResult;
            }
        } else {
            return checkId;
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> deleteFruit(@PathVariable("id") ObjectId id, WebRequest request) {
        ResponseEntity<Message> checkId = fruitServices.validateFruitId(id, request);

        if (checkId.getStatusCode() == HttpStatus.OK) {
            fruitServices.deleteFruitById(id);
            return new ResponseEntity<>(new Message(HttpStatus.OK.value(), new Date(), "Fruit removed successfully.", request.getDescription(false)), HttpStatus.OK);
        } else {
            return checkId;
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getFruitById(@PathVariable("id") ObjectId id, WebRequest request) {
        ResponseEntity<Message> checkId = fruitServices.validateFruitId(id, request);

        if (checkId.getStatusCode() == HttpStatus.OK) {
            return new ResponseEntity<>(fruitServices.getFruitById(id), HttpStatus.OK);
        } else {
            return checkId;
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFruits(WebRequest request) {

        List<Fruit> fruits = fruitServices.fruitsList();
        if (!fruits.isEmpty()) {
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message(HttpStatus.NO_CONTENT.value(), new Date(), "There are no fruits introduced yet.", request.getDescription(false)), HttpStatus.NO_CONTENT);
        }

    }


}
