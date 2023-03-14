package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.controllers;

import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.dto.FruitDto;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.dto.Message;
import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.services.FruitServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Fruits Management System.", description = "API operations pertaining to fruits database.")
public class FruitController {

    @Autowired
    private FruitServices fruitServices;

    @PostMapping("/add")
    @Operation(summary = "Create a new fruit.", description = "Adds a new fruit into the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Fruit created correctly.", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = FruitDto.class))})})
    public ResponseEntity<Message> addFruit(@Parameter(description = "The fruit to be added.", required = true) @RequestBody FruitDto fruitDto, WebRequest request) {
        ResponseEntity<Message> validationResult = fruitServices.validateFruitDto(fruitDto, request);

        if (validationResult.getStatusCode() == HttpStatus.OK) {
            fruitServices.createFruit(fruitDto);
            return new ResponseEntity<>(new Message(HttpStatus.CREATED.value(), new Date(), "Fruit created correctly.", request.getDescription(false)), HttpStatus.CREATED);
        } else {
            return validationResult;
        }

    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update a fruit.", description = "Updates an existing fruit in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fruit updated correctly.", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = FruitDto.class))})})
    public ResponseEntity<Message> updateFruit(@Parameter(description = "The id of the fruit to be updated.", required = true) @PathVariable("id") ObjectId id,
                                               @Parameter(description = "The updated fruit data.", required = true) @RequestBody FruitDto fruitDto, WebRequest request) {
        ResponseEntity<Message> checkId = fruitServices.validateFruitId(id, request);

        if (checkId.getStatusCode() == HttpStatus.OK) {
            fruitServices.updateFruitById(id, fruitDto, request);
            return new ResponseEntity<>(new Message(HttpStatus.OK.value(), new Date(),"Fruit updated correctly.", request.getDescription(false)), HttpStatus.OK);
        } else {
            return checkId;
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a fruit.", description = "Deletes an existing fruit from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fruit removed successfully.", content = @Content)})
    public ResponseEntity<Message> deleteFruit(@Parameter(description = "The id of the fruit to be removed.", required = true) @PathVariable("id") ObjectId id, WebRequest request) {
        ResponseEntity<Message> checkId = fruitServices.validateFruitId(id, request);

        if (checkId.getStatusCode() == HttpStatus.OK) {
            fruitServices.deleteFruitById(id);
            return new ResponseEntity<>(new Message(HttpStatus.OK.value(), new Date(), "Fruit removed successfully.", request.getDescription(false)), HttpStatus.OK);
        } else {
            return checkId;
        }
    }

    @GetMapping("/getOne/{id}")
    @Operation(summary = "Get a fruit by its ID.", description = "Retrieves a fruit from the database by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fruit retrieved successfully.", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = FruitDto.class))})})
    public ResponseEntity<?> getFruitById(@Parameter(description = "The id of the fruit to retrieve.", required = true) @PathVariable("id") ObjectId id, WebRequest request) {
        ResponseEntity<Message> checkId = fruitServices.validateFruitId(id, request);

        if (checkId.getStatusCode() == HttpStatus.OK) {
            return new ResponseEntity<>(fruitServices.getFruitById(id), HttpStatus.OK);
        } else {
            return checkId;
        }
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all fruits.", description = "Returns a list with all the fruits stored in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of fruits returned successfully.", content = {@Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = FruitDto.class)))}),
            @ApiResponse(responseCode = "204", description = "There are no fruits introduced yet.", content = @Content)})
    public ResponseEntity<?> getAllFruits(WebRequest request) {

        List<Fruit> fruits = fruitServices.fruitsList();
        if (!fruits.isEmpty()) {
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message(HttpStatus.NO_CONTENT.value(), new Date(), "There are no fruits introduced yet.", request.getDescription(false)), HttpStatus.NO_CONTENT);
        }

    }


}
