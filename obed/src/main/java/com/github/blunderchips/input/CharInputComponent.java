package com.github.blunderchips.input;

import com.github.blunderchips.StringInputField;

import java.lang.reflect.Field;

/**
 * @see java.lang.Character
 */
public class CharInputComponent extends InputComponent {

    private final StringInputField txtChar;

    public CharInputComponent(Field field) {
        super(field);
        super.add(txtChar = new StringInputField(field));
    }

    @Override
    public void save(Object obj) throws IllegalAccessException {
        validateInput();
        getField().setChar(obj, txtChar.getText().charAt(0));
    }

    // TODO: 28 Sep 2018
    private void validateInput() {
    }
}
