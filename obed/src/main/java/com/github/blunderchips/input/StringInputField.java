package com.github.blunderchips.input;

import com.microsoft.alm.plugin.idea.common.ui.controls.HintTextFieldUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.reflect.Field;

/**
 * Text input. Created 26/09/2018.
 */
// TODO: 28 Sep 2018 Rename to something better
public class StringInputField extends JTextField implements FocusListener {

    /**
     * Parent input component.
     */
    private final InputComponent input;

    public StringInputField(InputComponent cmp) {
        this.input = cmp;

        Field f = cmp.getField();
        String str = String.format("%s : %s",
                f.getName(), f.getType().getSimpleName());

        super.setToolTipText(str);
        super.setUI(new HintTextFieldUI(str));

        super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent evt) {
        // siD 28/09/2018: Don't really care about this method.
    }

    @Override
    public void focusLost(FocusEvent evt) {
        if (input.isInputValid()) {
            setForeground(Color.black);
        } else {
            setForeground(Color.red); // TODO: 28 Sep 2018 Better share of red?
        }
    }
}

