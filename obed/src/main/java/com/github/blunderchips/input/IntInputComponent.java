package com.github.blunderchips.input;

import com.github.blunderchips.StringInputField;

import java.lang.reflect.Field;

/**
 * @see java.lang.Integer
 */
public class IntInputComponent extends InputComponent {

    private final StringInputField txtInt;

    public IntInputComponent(Field field) {
        super(field);
        super.add(txtInt = new StringInputField(field));
    }

    @Override
    public void save(Object obj) throws IllegalAccessException, NumberFormatException {
        validateInput();
        getField().setInt(obj, Integer.parseInt(txtInt.getText()));
    }

    // TODO: 28 Sep 2018
    private void validateInput() {
    }
}
