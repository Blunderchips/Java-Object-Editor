package com.github.blunderchips.input;

import java.lang.reflect.Field;

/**
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
            return (int) 0;
        }
        return Integer.parseInt(i);
    }

    @Override
    protected boolean isInputValid() {
        try {
            //noinspection ResultOfMethodCallIgnored
            Integer.parseInt(txtInt.getText());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
