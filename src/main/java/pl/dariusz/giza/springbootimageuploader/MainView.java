package pl.dariusz.giza.springbootimageuploader;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PageConfigurator;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import pl.dariusz.giza.springbootimageuploader.gui.DefaultView;
import pl.dariusz.giza.springbootimageuploader.gui.GalleryGui;
import pl.dariusz.giza.springbootimageuploader.gui.UploadGui;

@Route
public class MainView extends UI implements PageConfigurator {
    @Override
    protected void init(VaadinRequest request) {

        Label title = new Label("Menu");
        title.addStyleName(ValoTheme.MENU_TITLE);

        Button upload = new Button("Upload ", e -> getNavigator().navigateTo("upload"));
        upload.addStyleName(ValoTheme.BUTTON_LINK);

        Button gallery = new Button("Gallery ", e -> getNavigator().navigateTo("gallery"));
        gallery.addStyleName(ValoTheme.BUTTON_LINK);

        CssLayout menu = new CssLayout(title, upload, gallery);
        menu.addStyleName(ValoTheme.MENU_ROOT);

        CssLayout viewContainer = new CssLayout();

        HorizontalLayout mainLayout = new HorizontalLayout(menu, viewContainer);
        mainLayout.setSizeFull();
        mainLayout.addComponent(mainLayout);


      Navigator navigator = new Navigator(this, viewContainer);
        navigator.addView("", DefaultView.class);
        navigator.addView("upload", UploadGui.class);
        navigator.addView("gallery", GalleryGui.class);

    }

    @Override
    public void configurePage(InitialPageSettings initialPageSettings) {


    }
}
