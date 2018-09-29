package com.github.blunderchips.input;

import javax.swing.*;
import java.lang.reflect.Field;

/**
 * @see java.lang.Boolean
 */
public class BooleanInputComponent extends InputComponent {

    private final JToggleButton toggleButton;

    public BooleanInputComponent(Field f) {
        super(f);
        super.add(toggleButton = new JToggleButton(f.getName()));
    }

    @Override
    protected Object getInput() {
        return toggleButton.isSelected();
    }
}
