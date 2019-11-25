package pl.dariusz.giza.springbootimageuploader.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dariusz.giza.springbootimageuploader.model.Image;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {

}
