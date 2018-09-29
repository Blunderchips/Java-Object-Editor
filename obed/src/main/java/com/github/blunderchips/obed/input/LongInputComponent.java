package com.github.blunderchips.obed.input;

import com.github.blunderchips.obed.util.StringInputField;

import java.lang.reflect.Field;

/**
 * @see java.lang.Long
 */
public class LongInputComponent extends InputComponent {

    private final StringInputField txtLong;

    public LongInputComponent(Field field, Object obj) {
        super(field, obj);
        super.add(txtLong = new StringInputField(this));
    }

    @Override
    protected Object getInput() throws NumberFormatException {
        String l = txtLong.getText().trim();
        if (l.isEmpty()) {
            return (long) 0;
        }
        return Long.parseLong(l);
    }

    @Override
    public boolean isInputValid() {
        try {
            //noinspection ResultOfMethodCallIgnored
            Long.parseLong(txtLong.getText());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
