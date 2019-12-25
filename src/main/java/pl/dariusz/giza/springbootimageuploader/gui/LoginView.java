package pl.dariusz.giza.springbootimageuploader.gui;


import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.util.Collections;

@Route("login")
@Tag("sa-login-view")
@Theme(value = Lumo.class, variant = Lumo.DARK)
@PageTitle("login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {


    LoginForm loginForm = new LoginForm();

    public LoginView() {


        VerticalLayout layout = new VerticalLayout();

//        layout.getStyle().set("border", "10px dotted DarkOrange");
        layout.setSizeFull();


        loginForm.setAction("login");

        loginForm.addLoginListener(e -> {

            boolean isAuthenticated = authenticate(e);
            if (isAuthenticated) {
                navigateToMainPage();
            } else {
                loginForm.setError(true);
            }
        });

        layout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, loginForm);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        layout.add(loginForm);
        add(layout);

    }


    private boolean authenticate(AbstractLogin.LoginEvent e) {
        return true;
    }

    private void navigateToMainPage() {
        this.getUI().ifPresent(ui->ui.navigate("/start"));
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (!event.getLocation().getQueryParameters().getParameters()
                .getOrDefault("error", Collections.emptyList()).isEmpty()) {
            loginForm.setError(true);
        }
    }
}

