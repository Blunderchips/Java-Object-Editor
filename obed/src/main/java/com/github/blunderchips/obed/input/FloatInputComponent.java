package com.github.blunderchips.obed.input;

import com.github.blunderchips.obed.util.StringInputField;

import java.lang.reflect.Field;

/**
 * @see java.lang.Float
 */
public class FloatInputComponent extends InputComponent {

    private final StringInputField txtFloat;

    public FloatInputComponent(Field field, Object obj) {
        super(field, obj);
        super.add(txtFloat = new StringInputField(this));
    }

    @Override
    protected Object getInput() throws NumberFormatException {
        String f = txtFloat.getText().trim();
        if (f.isEmpty()) {
            return (float) 0;
        }
        return Float.parseFloat(f);
    }

    @Override
    public boolean isInputValid() {
        String f = txtFloat.getText().trim();
        if (f.isEmpty()) {
            return true;
        }
        try {
            //noinspection ResultOfMethodCallIgnored
            Float.parseFloat(f);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
