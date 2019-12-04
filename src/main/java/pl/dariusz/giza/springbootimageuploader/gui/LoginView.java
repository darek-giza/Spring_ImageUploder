package pl.dariusz.giza.springbootimageuploader.gui;


import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import pl.dariusz.giza.springbootimageuploader.MainView;

@Route("login")
@Tag("sa-login-view")
@Theme(value = Lumo.class, variant = Lumo.DARK)
@PageTitle("Login")
public class LoginView extends MainView {

    public LoginView() {


        VerticalLayout layout = new VerticalLayout();

        LoginForm login = new LoginForm();



        layout.add(login);

        layout.setHorizontalComponentAlignment(Alignment.CENTER,login);

        login.setAction("login");
        getElement().appendChild(login.getElement());

    }

}

