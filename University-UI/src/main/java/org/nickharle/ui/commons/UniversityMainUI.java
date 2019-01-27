package org.nickharle.ui.commons;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;

public class UniversityMainUI extends VerticalLayout implements RouterLayout {

    public UniversityMainUI(UniversityLogoLayoutFactory universityLogoLayoutFactory) {

        // Define rootLayout Components
        Component logo = universityLogoLayoutFactory.createComponent();
        VerticalLayout logoPanel = new VerticalLayout(logo);    // Store logo
        logoPanel.setSizeUndefined();                           // Takes only as much room as necessary
        logoPanel.setWidth("75%");                              // Gives some padding

        add(logo);
        setSizeFull();

       // =====================================================
       // UILayout object added through injection using @Parent
       // =====================================================
    }
}

