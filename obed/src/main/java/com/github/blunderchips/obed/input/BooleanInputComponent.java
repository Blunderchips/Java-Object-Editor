package com.github.blunderchips.obed.input;

import javax.swing.*;
import java.lang.reflect.Field;

/**
 * @see java.lang.Boolean
 */
public class BooleanInputComponent extends InputComponent {

    private final JToggleButton toggleButton;

    public BooleanInputComponent(Field field, Object obj) {
        super(field, obj);
        this.toggleButton = new JToggleButton(field.getName());
        try {
            // siD 05/10/2018: caused an exception to be thrown
            // this.toggleButton.setSelected(field.getBoolean(obj));

            this.toggleButton.setSelected((boolean) field.get(obj));
        } catch (Exception ex) {
            // TODO: 04 Oct 2018
            ex.printStackTrace(System.err);
        }
        super.add(toggleButton);
    }

    @Override
    public Object getInput() {
        return toggleButton.isSelected();
    }
}
