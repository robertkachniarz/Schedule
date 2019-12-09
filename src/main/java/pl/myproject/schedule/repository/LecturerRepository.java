package pl.myproject.schedule.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.myproject.schedule.model.Lecturer;

import java.util.List;

@Repository("lecturerRepository")
public interface LecturerRepository extends CrudRepository<Lecturer, Long> {
    @Override
    <S extends Lecturer> S save(S s);

    List<Lecturer> findAll();
    Lecturer findLecturerById(Long id);

    void deleteById(Long id);

    @Override
    void delete(Lecturer lecturer);

}
