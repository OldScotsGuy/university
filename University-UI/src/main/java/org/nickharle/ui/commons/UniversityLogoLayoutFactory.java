package org.nickharle.ui.commons;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


// Ensures that UniversityLogoLayoutFactory is in the SpringApplicationContext (the bean can!)
@org.springframework.stereotype.Component
//@Service
public class UniversityLogoLayoutFactory implements UIComponentBuilder {

    private class LogoLayout extends VerticalLayout {

        private Image logo;

        public LogoLayout init() {

            logo = new Image("images/the-university-of-sydney.jpg","alt");
            logo.setWidth("959px");
            logo.setHeight("444px");
            return this;
        }

        public LogoLayout layout() {
            add(logo);
            setAlignItems(Alignment.CENTER);
            return this;
        }
    }

    public Component createComponent() {

        return new LogoLayout().init().layout();
    }

}
