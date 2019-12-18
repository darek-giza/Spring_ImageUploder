package pl.dariusz.giza.springbootimageuploader;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

public class MyUIServlet extends UI {


    @Override
    protected void init(VaadinRequest request) {
        setContent((Component) new MainView());
    }

    @WebServlet(urlPatterns = "/*", name = "MyUi", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUIServlet.class, productionMode = false)
    public static class MyUi extends VaadinServlet {

    }
}
