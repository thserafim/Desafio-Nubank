package TSsotware.com.userNubank.repository;


import TSsotware.com.userNubank.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository <Cliente, String> {
}
