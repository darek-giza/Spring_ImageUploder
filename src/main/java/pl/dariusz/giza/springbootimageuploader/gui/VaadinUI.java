package pl.dariusz.giza.springbootimageuploader.gui;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import javax.swing.*;

public class VaadinUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();






    Label title = new Label("Menu");
        title.addStyleName(ValoTheme.MENU_TITLE);

        Button upload = new Button("Upload ", e ->navigate("upload"));
        upload.addStyleName(ValoTheme.BUTTON_LINK);

        Button gallery = new Button("Upload ", e -> navigate("upload"));
        gallery.addStyleName(ValoTheme.BUTTON_LINK);

        CssLayout menu = new CssLayout(title, upload,gallery);
        menu.addStyleName(ValoTheme.MENU_ROOT);

        CssLayout viewContainer = new CssLayout();

        HorizontalLayout mainLayout = new HorizontalLayout(menu,viewContainer);
        mainLayout.setSizeFull();



//        Navigator navigator = new Navigator(this,viewContainer);
//        navigator.addView("", (Class<? extends View>) DefaultView.class);
//        navigator.addView("upload", (Class<? extends View>) UploadGui.class);
//        navigator.addView("gallery", (Class<? extends View>) GalleryGui.class);



    }

}
