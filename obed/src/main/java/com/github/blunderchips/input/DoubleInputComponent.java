package com.github.blunderchips.input;

import java.lang.reflect.Field;

/**
 * @see java.lang.Double
 */
public class DoubleInputComponent extends InputComponent {

    private final StringInputField txtDouble;

    public DoubleInputComponent(Field field, Object obj) {
        super(field, obj);
        super.add(txtDouble = new StringInputField(this));
    }

    @Override
    protected Object getInput() throws NumberFormatException {
        String d = txtDouble.getText().trim();
        if (d.isEmpty()) {
            return (double) 0;
        }
        return Double.parseDouble(d);
    }

    @Override
    protected boolean isInputValid() {
        try {
            //noinspection ResultOfMethodCallIgnored
            Double.parseDouble(txtDouble.getText());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
