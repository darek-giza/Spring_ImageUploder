package pl.dariusz.giza.springbootimageuploader;


import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.stereotype.Component;
import pl.dariusz.giza.springbootimageuploader.gui.DefaultView;
import pl.dariusz.giza.springbootimageuploader.gui.GalleryGui;
import pl.dariusz.giza.springbootimageuploader.gui.LoginView;
import pl.dariusz.giza.springbootimageuploader.gui.UploadGui;

@Route
@Component
public class MainView extends VerticalLayout {


    public MainView() {

        VerticalLayout layout = new VerticalLayout();

        layout.setMargin(true);
        layout.setSpacing(true);

        MenuBar menuBar = new MenuBar();

        MenuItem menu = menuBar.addItem("MENU", i -> getUI().ifPresent(ui -> ui.navigate("")));
        MenuItem gallery = menuBar.addItem("GALLERY", i -> getUI().ifPresent(ui -> ui.navigate("gallery")));
        MenuItem upload = menuBar.addItem("UPLOAD", i -> getUI().ifPresent(ui -> ui.navigate("upload")));
        MenuItem fault = menuBar.addItem("DEFAULT", i -> getUI().ifPresent(ui -> ui.navigate("defoult")));
        MenuItem login = menuBar.addItem("LOGIN", i -> getUI().ifPresent(ui -> ui.navigate("login")));
        MenuItem logout = menuBar.addItem("LOGOUT", i -> getUI().ifPresent(ui -> ui.navigate("logout")));

        layout.add(menuBar);

        add(layout);
    }


    void routerLink() {
        Div menu = new Div();
        menu.add(new RouterLink("Default", DefaultView.class));
        menu.add(new RouterLink("Gallery", GalleryGui.class));
        menu.add(new RouterLink("Upload", UploadGui.class));
        menu.add(new RouterLink("Login", LoginView.class));
        menu.add(new RouterLink("", MainView.class));
    }
}
