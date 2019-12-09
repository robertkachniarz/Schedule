package pl.myproject.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.myproject.schedule.model.Lecturer;
import pl.myproject.schedule.repository.LecturerRepository;

import java.util.List;

@Service("lecturerService")
public class LecturerService {
  private LecturerRepository repository;

  @Autowired
    public LecturerService(@Qualifier("lecturerRepository") LecturerRepository lecturerRepository){
      this.repository = lecturerRepository;
  }

  public void saveLecturer(Lecturer lecturer){
      repository.save(lecturer);
  }

  public List<Lecturer> findAll(){
      return repository.findAll();
  }

  public Lecturer findLecturerById(Long id){
      return repository.findLecturerById(id);
  }

  public void deleteLecturer(Lecturer lecturer){
      repository.delete(lecturer);
  }

  public void deleteLecturerById(Long id){
      repository.deleteById(id);
  }

}
