package pl.dariusz.giza.springbootimageuploader.gui;


import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.awt.*;

@StyleSheet("/css/style.css")
@Route("login")
@Tag("sa-login-view")
@Theme(value = Lumo.class, variant = Lumo.DARK)
@PageTitle("Login")
public class LoginView extends VerticalLayout {

    private VerticalLayout layout = new VerticalLayout();

    private LoginForm login = new LoginForm();

    public LoginView() {

        layout.addComponentAsFirst(login);
        layout.setSizeFull();
        layout.setHorizontalComponentAlignment(Alignment.CENTER, login);
        login.setAction("login");
        getElement().appendChild(login.getElement());

    }

}

