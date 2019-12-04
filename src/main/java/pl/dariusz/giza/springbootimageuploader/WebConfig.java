package pl.dariusz.giza.springbootimageuploader;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.flow.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

public class WebConfig {


    @WebServlet(urlPatterns = "/", name = "MyUIServlet", asyncSupported = true)
//    @VaadinServletConfiguration(ui = MainView.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

    }
}
