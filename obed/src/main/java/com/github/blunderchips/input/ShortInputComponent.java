package com.github.blunderchips.input;

import java.lang.reflect.Field;

/**
 * @see java.lang.Short
 */
public class ShortInputComponent extends InputComponent {

    private final StringInputField txtShort;

    public ShortInputComponent(Field field, Object obj) {
        super(field, obj);
        super.add(txtShort = new StringInputField(this));
    }

    @Override
    protected Object getInput() throws NumberFormatException {
        String s = txtShort.getText().trim();
        if (s.isEmpty()) {
            return (short) 0;
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
