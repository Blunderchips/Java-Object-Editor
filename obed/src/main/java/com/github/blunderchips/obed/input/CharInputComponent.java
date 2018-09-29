package com.github.blunderchips.obed.input;

import com.github.blunderchips.obed.util.StringInputField;

import java.lang.reflect.Field;

/**
 * @see java.lang.Character
 */
public class CharInputComponent extends InputComponent {

    private final StringInputField txtChar;

    public CharInputComponent(Field field, Object obj) {
        super(field, obj);
        super.add(txtChar = new StringInputField(this));
    }

    @Override
    protected Object getInput() {
        String c = txtChar.getText().trim();
        if (c.isEmpty()) {
            return ' ';
        }
        return c.charAt(0);
    }

    // TODO: 28 Sep 2018 Check
    @Override
    protected boolean isInputValid() {
        return txtChar.getText().length() == 1;
    }
}
