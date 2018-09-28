package com.github.blunderchips.input;

import java.lang.reflect.Field;

/**
 * @see java.lang.Double
 */
public class DoubleInputComponent extends InputComponent {

    private final StringInputField txtDouble;

    public DoubleInputComponent(Field field) {
        super(field);
        super.add(txtDouble = new StringInputField(this));
    }

    @Override
    public void save(Object obj) throws IllegalAccessException, NumberFormatException {
        getField().setDouble(obj, getInput());
    }

    private double getInput() {
        String d = txtDouble.getText().trim();
        if (d.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(d);
    }

    @Override
    protected boolean isInputValid() {
        try {
            Double.parseDouble(txtDouble.getText());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
