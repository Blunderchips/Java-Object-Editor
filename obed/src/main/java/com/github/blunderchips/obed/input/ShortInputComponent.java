package com.github.blunderchips.obed.input;

import com.github.blunderchips.obed.util.StringInputField;

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
    public boolean isInputValid() {
        String s = txtShort.getText().trim();
        if (s.isEmpty()) {
            return true;
        }
        try {
            //noinspection ResultOfMethodCallIgnored
            Short.parseShort(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
