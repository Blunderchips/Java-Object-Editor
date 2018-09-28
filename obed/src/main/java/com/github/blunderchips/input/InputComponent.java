package com.github.blunderchips.input;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

/**
 *
 */
public abstract class InputComponent extends JPanel {

    /**
     * {@link Field} to be edited.
     */
    private final Field field;

    /**
     * @param field {@link Field} to be edited.
     */
    public InputComponent(Field field) {
        this.field = field;

        super.setLayout(new GridLayout());
        // super.add(new JLabel(field.getName()));
    }

    /**
     * @param obj {@link Object} to be edited.
     * @throws IllegalAccessException if this {@code Field} object is enforcing Java language access control and the
     *                                underlying field is either inaccessible or final.
     */
    public abstract void save(Object obj) throws IllegalAccessException;

    public Field getField() {
        return this.field;
    }
}
