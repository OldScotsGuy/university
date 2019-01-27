package org.nickharle.ui.commons;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import org.nickharle.ui.students.StudentLayoutFactory;
import org.nickharle.ui.universities.UniversityLayoutFactory;
import org.nickharle.utils.StringUtils;

@org.springframework.stereotype.Component
public class UniversityMenuFactory implements UIComponentBuilder{

    private class UniversMenu extends VerticalLayout implements RouterLayout {

        private VerticalLayout mainMenu;

        public UniversMenu init() {
            mainMenu = new VerticalLayout();
            setWidth("100%");
            setSizeUndefined();
            return this;
        }

        public UniversMenu layout() {

            // Students Menu Items
            // ===================

            // Students Label
            Label studentsTitle = new Label(StringUtils.MENU_STUDENT.getString());
            mainMenu.add(studentsTitle);
            mainMenu.setHorizontalComponentAlignment(Alignment.START,studentsTitle);

            // Students Link
            RouterLink students = new RouterLink(null, StudentLayoutFactory.class);
            students.add(new Text("Students"));
            mainMenu.add(students);
            mainMenu.setHorizontalComponentAlignment(Alignment.END,students);

            // University Menu Items
            // =====================

            // University Label
            Label university = new Label(StringUtils.MENU_UNIVERSITY.getString());
            mainMenu.add(university);
            mainMenu.setHorizontalComponentAlignment(Alignment.START,university);

            // University Link
            RouterLink universities = new RouterLink(null, UniversityLayoutFactory.class);
            universities.add(new Text("Universities"));
            mainMenu.add(universities);
            mainMenu.setHorizontalComponentAlignment(Alignment.END,universities);

            add(mainMenu);

            return this;
        }
    }

    public Component createComponent() {
        return new UniversMenu().init().layout();
    }
}
