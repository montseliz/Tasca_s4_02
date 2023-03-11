package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.repository;

import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.domain.Fruit;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Per gestionar la persistència amb MongoDB.
 */
@Repository
public interface IFruitRepository extends MongoRepository<Fruit, ObjectId> {

}
