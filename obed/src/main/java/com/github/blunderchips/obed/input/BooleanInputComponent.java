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
        super.add(toggleButton = new JToggleButton(field.getName()));
    }

    @Override
    protected Object getInput() {
        return toggleButton.isSelected();
    }
}
