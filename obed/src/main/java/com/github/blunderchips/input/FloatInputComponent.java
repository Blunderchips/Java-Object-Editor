package com.github.blunderchips.input;

import java.lang.reflect.Field;

/**
 * @see java.lang.Float
 */
public class FloatInputComponent extends InputComponent {

    private final StringInputField txtFloat;

    public FloatInputComponent(Field field) {
        super(field);
        super.add(txtFloat = new StringInputField(this));
    }

    @Override
    public void save(Object obj) throws IllegalAccessException, NumberFormatException {
        getField().setFloat(obj, getInput());
    }

    private float getInput() throws NumberFormatException {
        String f = txtFloat.getText().trim();
        if (f.isEmpty()) {
            return 0;
        }
        return Float.parseFloat(f);
    }

    @Override
    protected boolean isInputValid() {
        try {
            Float.parseFloat(txtFloat.getText());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
