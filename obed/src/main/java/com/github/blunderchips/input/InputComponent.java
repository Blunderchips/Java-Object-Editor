package com.github.blunderchips.input;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

/**
 * @author Matthew 'siD' Van der Bijl
 */
public abstract class InputComponent extends JPanel {

    /**
     * {@link Field} to be edited.
     */
    private final Field field;
    /**
     * References the {@code Object} to be edited. Needed for nested objects.
     */
    private final Object obj;

    /**
     * @param field {@link Field} to be edited.
     */
    public InputComponent(Field field, Object obj) {
        this.field = field;
        this.obj = obj;

        // siD 29/09/2018: Make components fill the panel.
        super.setLayout(new GridLayout());

        // super.add(new JLabel(field.getName()));
    }

    /**
     * @throws IllegalAccessException if the {@link Field} object is enforcing Java language access control and the
     *                                underlying field is either inaccessible or final. Should never happen.
     *
     * @see Field#set(Object, Object)
     */
    public void save() throws IllegalAccessException {
        getField().set(obj, getInput());
    }

    /**
     * @return the value to be saved
     */
    protected abstract Object getInput();

    protected Field getField() {
        return this.field;
    }

    /**
     * @return True, assume that the input is valid
     */
    protected boolean isInputValid() {
        return true;
    }
}
