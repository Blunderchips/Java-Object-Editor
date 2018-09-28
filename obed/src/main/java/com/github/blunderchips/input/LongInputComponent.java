package com.github.blunderchips.input;

import java.lang.reflect.Field;

/**
 * @see java.lang.Long
 */
public class LongInputComponent extends InputComponent {

    private final StringInputField txtLong;

    public LongInputComponent(Field field) {
        super(field);
        super.add(txtLong = new StringInputField(this));
    }

    @Override
    public void save(Object obj) throws IllegalAccessException, NumberFormatException {
        getField().setLong(obj, getInput());
    }

    private long getInput() {
        String l = txtLong.getText().trim();
        if (l.isEmpty()) {
            return 0;
        }
        return Long.parseLong(l);
    }

    @Override
    protected boolean isInputValid() {
        try {
            Long.parseLong(txtLong.getText());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
