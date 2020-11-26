package wsrest;

import org.springframework.data.repository.CrudRepository;

public interface ExemplarRepo extends CrudRepository<Exemplar, Long>{
    Iterable<Exemplar> findByLivroId(Long faculdadeId);
}