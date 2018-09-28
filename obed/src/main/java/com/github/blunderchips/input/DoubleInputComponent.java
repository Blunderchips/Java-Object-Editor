package com.github.blunderchips.input;

import com.github.blunderchips.StringInputField;

import java.lang.reflect.Field;

/**
 * @see java.lang.Double
 */
public class DoubleInputComponent extends InputComponent {

    private final StringInputField txtDouble;

    public DoubleInputComponent(Field field) {
        super(field);
        super.add(txtDouble = new StringInputField(field));
    }

    @Override
    public void save(Object obj) throws IllegalAccessException, NumberFormatException {
        validateInput();
        getField().setDouble(obj, Double.parseDouble(txtDouble.getText()));
    }

    // TODO: 28 Sep 2018
    private void validateInput() {
    }
}
