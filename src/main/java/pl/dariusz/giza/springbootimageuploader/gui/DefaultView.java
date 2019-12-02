package pl.dariusz.giza.springbootimageuploader.gui;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import org.springframework.stereotype.Component;


@Route("default")
@Component
public class DefaultView extends VerticalLayout implements View {

    public DefaultView() {
        Label label = new Label("This is the defaultView");
        add(label);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
