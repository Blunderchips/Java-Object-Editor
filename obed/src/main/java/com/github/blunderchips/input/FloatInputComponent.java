package com.github.blunderchips.input;

import com.github.blunderchips.StringInputField;

import java.lang.reflect.Field;

/**
 * @see java.lang.Float
 */
public class FloatInputComponent extends InputComponent {

    private final StringInputField txtFloat;

    public FloatInputComponent(Field field) {
        super(field);
        super.add(txtFloat = new StringInputField(field));
    }

    @Override
    public void save(Object obj) throws IllegalAccessException, NumberFormatException {
        validateInput();
        getField().setFloat(obj, Float.parseFloat(txtFloat.getText()));
    }

    // TODO: 28 Sep 2018
    private void validateInput() {
    }
}
