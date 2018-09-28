package com.github.blunderchips.input;

import java.lang.reflect.Field;

/**
 * @see java.lang.Integer
 */
public class IntInputComponent extends InputComponent {

    private final StringInputField txtInt;

    public IntInputComponent(Field field) {
        super(field);
        super.add(txtInt = new StringInputField(this));
    }

    @Override
    public void save(Object obj) throws IllegalAccessException, NumberFormatException {
        getField().setInt(obj, getInput());
    }

    private int getInput() {
        String i = txtInt.getText().trim();
        if (i.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(i);
    }

    @Override
    protected boolean isInputValid() {
        try {
            Integer.parseInt(txtInt.getText());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
