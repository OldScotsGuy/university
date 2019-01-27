package org.nickharle.ui.universities;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.nickharle.ui.commons.UILayout;

@Route(value = UniversityLayoutFactory.NAME, layout = UILayout.class)
@PageTitle("U n i v e r s i t y")
public class UniversityLayoutFactory extends VerticalLayout {

    public static final String NAME = "universities";

    UniversityLayoutFactory() {
        setMargin(true);
        add(new Label("University Layout Object"));
    }

}
