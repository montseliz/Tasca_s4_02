package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n01.model.repository.IFruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Mètodes que es corresponen amb els diferents endpoints de l'API RESTful. Cadascun manipula una sol·licitud HTTP
 * específica i retorna una resposta HTTP.
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private IFruitRepository fruitRepository;

    //region POST
    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit newFruit) {
        try {
            Fruit savedFruit = fruitRepository.save(new Fruit(newFruit.getName(), newFruit.getQuantityKg()));
            return new ResponseEntity<>(savedFruit, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
     //endregion POST

    //region PUT
    @PutMapping("/update/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable(required = true) int id, @RequestBody Fruit fruitToUpdate) {
        Optional<Fruit> fruitData = fruitRepository.findById(id);

        if (fruitData.isPresent()) {
            Fruit fruitFromDb = fruitData.get();
            fruitFromDb.setName(fruitToUpdate.getName());
            fruitFromDb.setQuantityKg(fruitToUpdate.getQuantityKg());
            return new ResponseEntity<>(fruitRepository.save(fruitFromDb), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //endregion PUT

    //region DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruit(@PathVariable(required = true) int id) {
        Optional<Fruit> fruitData = fruitRepository.findById(id);
        if (fruitData.isPresent()) {
            try {
                fruitRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //endregion DELETE

    //region GET
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable(required = true) int id) {
        Optional<Fruit> fruitData = fruitRepository.findById(id);

        if (fruitData.isPresent()) {
            return new ResponseEntity<>(fruitData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {

        try {
            List<Fruit> fruits = fruitRepository.findAll();
            if (!fruits.isEmpty()) {
                return new ResponseEntity<>(fruits, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //endregion GET
}
