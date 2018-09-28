package com.github.blunderchips.input;

import com.github.blunderchips.StringInputField;

import java.lang.reflect.Field;

/**
 * @see java.lang.Short
 */
public class ShortInputComponent extends InputComponent {

    private final StringInputField txtShort;

    public ShortInputComponent(Field field) {
        super(field);
        super.add(txtShort = new StringInputField(field));
    }

    /**
     * @param obj {@link Object} to be edited.
     * @throws IllegalAccessException
     * @throws NumberFormatException  NumberFormatException If the {@link String} does not contain a parsable {@link Short}.
     */
    @Override
    public void save(Object obj) throws IllegalAccessException, NumberFormatException {
        validateInput();
        getField().setShort(obj, Short.parseShort(txtShort.getText()));
    }

    // TODO: 28 Sep 2018
    private void validateInput() {
    }
}
