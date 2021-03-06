package com.github.blunderchips.obed.input;

import com.github.blunderchips.obed.util.StringInputField;

import java.lang.reflect.Field;

/**
 * Integer input component.
 *
 * @see java.lang.Integer
 */
public class IntInputComponent extends InputComponent {

    private final StringInputField txtInt;

    public IntInputComponent(Field field, Object obj) {
        super(field, obj);
        super.add(txtInt = new StringInputField(this));
    }

    @Override
    protected Object getInput() throws NumberFormatException {
        String i = txtInt.getText().trim();
        if (i.isEmpty()) {
            //noinspection RedundantCast
            return (int) 0;
        }
        return Integer.parseInt(i);
    }

    @Override
    public boolean isInputValid() {
        String i = txtInt.getText().trim();
        if (i.isEmpty()) {
            return true;
        }
        try {
            //noinspection ResultOfMethodCallIgnored
            Integer.parseInt(i);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
