package pl.dariusz.giza.springbootimageuploader.gui;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;

@Route("")
public class StartView extends VerticalLayout implements View {

    public StartView() {
        HorizontalLayout layout = new HorizontalLayout();
        VerticalLayout verticalLayout = new VerticalLayout();

        Icon logo = new Icon(VaadinIcon.VAADIN_H);
        Image java=new Image("/Frontend/styles/images/java.png","java");
        Image logos=new Image("/Frontend/styles/images/logos.png","java");
        Image maven=new Image("/Frontend/styles/images/maven.png","maven");
        logo.setSize("150px");
        logo.setColor("orange");

        Label info = new Label(
                "This application allows you to add photos \n " +
                        " to the cloud using the Cloudinary API.\n" +
                        " The image link is saved in your database so you can \n" +
                        " view your photos in the gallery \n " +
                        "without having them physically on your computer.");

        Anchor anchorLogin = new Anchor("/login", "LOG IN ...");
        Anchor anchorJoin = new Anchor("/join", "JOIN NOW...");


        layout.setHeight("200px");
        layout.setWidth("100%");
        layout.setJustifyContentMode(JustifyContentMode.AROUND);
        layout.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        verticalLayout.add(info);
        verticalLayout.setHeight("200px");
        verticalLayout.setWidth("100%");
        verticalLayout.setJustifyContentMode(JustifyContentMode.AROUND);
        verticalLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        layout.add(logo,java,logos,maven,anchorJoin, anchorLogin);
        add(layout);
        add(verticalLayout);


    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}