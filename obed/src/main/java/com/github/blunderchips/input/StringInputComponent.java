package com.github.blunderchips.input;

import java.lang.reflect.Field;

/**
 * @see java.lang.String
 */
public class StringInputComponent extends InputComponent {

    private final StringInputField txtInput;

    public StringInputComponent(Field field) {
        super(field);
        super.add(txtInput = new StringInputField(this));
    }

    @Override
    protected Object getInput() {
        return txtInput.getText();
    }
}
