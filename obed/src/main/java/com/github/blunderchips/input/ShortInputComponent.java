package com.github.blunderchips.input;

import java.lang.reflect.Field;

/**
 * @see java.lang.Short
 */
public class ShortInputComponent extends InputComponent {

    private final StringInputField txtShort;

    public ShortInputComponent(Field field) {
        super(field);
        super.add(txtShort = new StringInputField(this));
    }

    /**
     * @param obj {@link Object} to be edited.
     * @throws IllegalAccessException
     * @throws NumberFormatException  NumberFormatException If the {@link String} does not contain a parsable {@link Short}.
     */
    @Override
    public void save(Object obj) throws IllegalAccessException, NumberFormatException {
        getField().setShort(obj, getInput());
    }

    private short getInput() {
        String s = txtShort.getText().trim();
        if (s.isEmpty()) {
            return 0;
        }
        return Short.parseShort(s);
    }

    @Override
    protected boolean isInputValid() {
        try {
            //noinspection ResultOfMethodCallIgnored
            Short.parseShort(txtShort.getText());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
