package com.github.blunderchips.input;

import java.lang.reflect.Field;

/**
 * @see java.lang.Byte
 */
public class ByteInputComponent extends InputComponent {

    private final StringInputField txtByte;

    public ByteInputComponent(Field field) {
        super(field);
        super.add(txtByte = new StringInputField(this));
    }

    @Override
    public void save(Object obj) throws IllegalAccessException, NumberFormatException {
        getField().setByte(obj, getInput());
    }

    private Byte getInput() {
        String b = txtByte.getText().trim();
        if (b.isEmpty()) {
            return 0;
        }
        return Byte.parseByte(b);
    }

    @Override
    protected boolean isInputValid() {
        try {
            //noinspection ResultOfMethodCallIgnored
            Byte.parseByte(txtByte.getText());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
