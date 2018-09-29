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
    protected boolean isInputValid() {
        try {
            //noinspection ResultOfMethodCallIgnored
            Float.parseFloat(txtFloat.getText());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}