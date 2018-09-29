package com.github.blunderchips.input;

import java.lang.reflect.Field;

/**
 * @see java.lang.Byte
 */
public class ByteInputComponent extends InputComponent {

    private final StringInputField txtByte;

    public ByteInputComponent(Field field, Object obj) {
        super(field, obj);
        super.add(txtByte = new StringInputField(this));
    }

    @Override
    protected Object getInput() throws NumberFormatException {
        String b = txtByte.getText().trim();
        if (b.isEmpty()) {
            return (byte) 0;
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
