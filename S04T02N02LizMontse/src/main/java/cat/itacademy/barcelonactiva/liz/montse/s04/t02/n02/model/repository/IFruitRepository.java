package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n02.model.repository;

import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n02.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Per gestionar la persistència amb la base de dades.
 */
@Repository
public interface IFruitRepository extends JpaRepository<Fruit, Integer> {

}
