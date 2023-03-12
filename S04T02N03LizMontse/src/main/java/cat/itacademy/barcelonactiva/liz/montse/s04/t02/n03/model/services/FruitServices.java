package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.services;

import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.dto.FruitDto;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.dto.Message;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.exception.FruitNotFoundException;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.exception.FruitValidationException;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.repository.IFruitRepository;
import io.micrometer.common.util.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

/**
 * Tota la lògica de l'aplicació. Per encapsular els mètodes que es necessiten per realitzar tasques
 * específiques del programa. Permet una millor modularitat i reutilització del codi.
 */
@Service
public class FruitServices {

    @Autowired
    private IFruitRepository fruitRepository;

    public List<Fruit> fruitsList() {
        return fruitRepository.findAll();
    }

    public Optional<Fruit> getFruitById(ObjectId id) {
        return fruitRepository.findById(id);
    }

    public void deleteFruitById(ObjectId id) {
        fruitRepository.deleteById(id);
    }

    /**
     * Mètode per validar l'existència de la fruita per id en els mètodes del RestController.
     */
    public ResponseEntity<Message> validateFruitId(ObjectId id, WebRequest request) {
        if (fruitRepository.existsById(id)) {
            return new ResponseEntity<>(new Message(HttpStatus.OK.value(), new Date(), "Fruit id validated successfully.", request.getDescription(false)), HttpStatus.OK);
        } else {
            throw new FruitNotFoundException("ERROR. The id entered does not exist.");
        }
    }

    /**
     * Mètode per validar les dades introduïdes (name i quantityKg) de la fruita en els mètodes del RestController.
     */
    public ResponseEntity<Message> validateFruitDto(FruitDto fruitDto, WebRequest request) {

        if (StringUtils.isBlank(fruitDto.getName())) {
            throw new FruitValidationException("ERROR. The name is required.");
        }
        if (fruitDto.getQuantityKg() <= 0) {
            throw new FruitValidationException("ERROR. Quantity must be greater than 0.");
        }
        return new ResponseEntity<>(new Message(HttpStatus.OK.value(), new Date(), "Fruit validated successfully.", request.getDescription(false)), HttpStatus.OK);
    }

    /**
     * Mètode per encapsular la lògica de crear una fruita en el mètode addFruit del controlador.
     */
    public Fruit createFruit(FruitDto fruitDto) {
        Fruit newFruit = new Fruit(fruitDto.getName(), fruitDto.getQuantityKg());
        return fruitRepository.save(newFruit);
    }

    /**
     * Mètode per encapsular la lògica d'actualitzar una fruita en el mètode updateFruit del controlador.
     */
    public Fruit updateFruitById(ObjectId id, FruitDto fruitDto, WebRequest request) {
        Fruit fruitFromDb = fruitRepository.findById(id).get();
        ResponseEntity<Message> validationResult = validateFruitDto(fruitDto, request);

        if (validationResult.getStatusCode() == HttpStatus.OK) {
            fruitFromDb.setName(fruitDto.getName());
            fruitFromDb.setQuantityKg(fruitDto.getQuantityKg());
            fruitRepository.save(fruitFromDb);
        }
        return fruitFromDb;
    }

}
