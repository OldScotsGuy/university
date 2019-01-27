package org.nickharle.ui.commons;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RouterLayout;

@ParentLayout(UniversityMainUI.class)
public class UILayout extends HorizontalLayout implements RouterLayout {

    public UILayout(UniversityMenuFactory universityMenuFactory) {

        // Define the uiLayout = ( menu  |  changeTab)
        // ===========================================

        // Initialise Layout
        HorizontalLayout uiLayout = new HorizontalLayout();
        setSizeFull();                                 // Make as wide and high as possible
        setMargin(true);
        //uiLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        // Add Components
        Component menu = universityMenuFactory.createComponent();
        add(menu);

        // ====================================================
        // @Route will add either a StudentLayoutFactory object
        // or a UniversityLayoutFactory object
        // ====================================================
    }

}

