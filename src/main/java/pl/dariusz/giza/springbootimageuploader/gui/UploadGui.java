package pl.dariusz.giza.springbootimageuploader.gui;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.beans.factory.annotation.Autowired;
import pl.dariusz.giza.springbootimageuploader.ImageUploader;


@Route("upload")
@Theme(value = Lumo.class, variant = Lumo.DARK)
public class UploadGui extends VerticalLayout {

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
}
