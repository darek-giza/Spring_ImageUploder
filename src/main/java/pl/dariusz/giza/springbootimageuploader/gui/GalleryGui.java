package pl.dariusz.giza.springbootimageuploader.gui;

import com.vaadin.flow.router.Route;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dariusz.giza.springbootimageuploader.MainView;
import pl.dariusz.giza.springbootimageuploader.model.Image;
import pl.dariusz.giza.springbootimageuploader.repository.ImageRepo;

import java.util.List;

@Component
@Route("gallery")
public class GalleryGui extends MainView implements View {


    private ImageRepo imageRepo;

    @Autowired
    public GalleryGui(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;

        List<Image> all = imageRepo.findAll();

        all.stream().forEach(e->{
            com.vaadin.flow.component.html.Image image=
                    new com.vaadin.flow.component.html.Image(e.getImageAddress(),"EMPTY");
            add(image);
        });

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
