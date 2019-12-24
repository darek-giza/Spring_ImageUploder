package pl.dariusz.giza.springbootimageuploader.gui;


import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("login")
@Tag("sa-login-view")
@Theme(value = Lumo.class, variant = Lumo.DARK)
@PageTitle("Login")
public class LoginView extends VerticalLayout {


    public LoginView() {


        VerticalLayout layout = new VerticalLayout();

//        layout.getStyle().set("border", "10px dotted DarkOrange");
        layout.setSizeFull();

        LoginForm loginForm = new LoginForm();

        layout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, loginForm);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        layout.add(loginForm);
        add(layout);

    }

}

