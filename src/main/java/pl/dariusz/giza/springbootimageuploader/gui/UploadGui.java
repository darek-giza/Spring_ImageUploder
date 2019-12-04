package pl.dariusz.giza.springbootimageuploader.gui;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dariusz.giza.springbootimageuploader.ImageUploader;
import pl.dariusz.giza.springbootimageuploader.MainView;

@Component
@Route("upload")
@Theme(value = Lumo.class, variant = Lumo.DARK)
public class UploadGui extends MainView implements View {

    private ImageUploader imageUploader;

    @Autowired
    public UploadGui(ImageUploader imageUploader) {
        this.imageUploader = imageUploader;

        Label label = new Label("IMAGE ADDED SUCCESSFULLY");
        TextField textField = new TextField();
        Button button = new Button("upload");
        button.addClickListener(clickEvent -> {

            String uploadImage = imageUploader.uploadFile(textField.getValue());
            Image image = new Image(uploadImage, "FALIED !!!");
            add(label);
            add(image);
        });
        add(textField);
        add(button);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
