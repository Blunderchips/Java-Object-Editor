package com.github.blunderchips.input;

import com.github.blunderchips.StringInputField;

import java.lang.reflect.Field;

/**
 * @see java.lang.Byte
 */
public class ByteInputComponent extends InputComponent {

    private final StringInputField txtByte;

    public ByteInputComponent(Field field) {
        super(field);
        super.add(txtByte = new StringInputField(field));
    }

    @Override
    public void save(Object obj) throws IllegalAccessException, NumberFormatException {
        validateInput();
        getField().setByte(obj, Byte.parseByte(txtByte.getText()));
    }

    // TODO: 28 Sep 2018
    private void validateInput() {
    }
}
