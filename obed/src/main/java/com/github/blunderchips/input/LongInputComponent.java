package com.github.blunderchips.input;

import com.github.blunderchips.StringInputField;

import java.lang.reflect.Field;

/**
 * @see java.lang.Long
 */
public class LongInputComponent extends InputComponent {

    private final StringInputField txtLong;

    public LongInputComponent(Field field) {
        super(field);
        super.add(txtLong = new StringInputField(field));
    }

    @Override
    public void save(Object obj) throws IllegalAccessException, NumberFormatException {
        validateInput();
        getField().setLong(obj, Long.parseLong(txtLong.getText()));
    }

    // TODO: 28 Sep 2018
    private void validateInput() {
    }
}
