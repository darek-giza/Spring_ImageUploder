package pl.dariusz.giza.springbootimageuploader.gui;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import org.springframework.stereotype.Component;
import pl.dariusz.giza.springbootimageuploader.MainView;


@Route("default")
@Component
public class DefaultView extends MainView implements View {

    public DefaultView() {
        Label label = new Label("This is the defaultView");
        add(label);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
