package com.github.blunderchips.obed.util;

import com.github.blunderchips.obed.input.InputComponent;
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
     * Error colour.
     */
    private static final Color SCARLET = new Color(0xff2400);

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

        try {
            Object obj = cmp.getField().get(cmp.getObject());
            if (obj != null) {
                str = obj.toString().trim();
                if (!str.isEmpty()) {
                    super.setText(str);
                }
            }
        } catch (Exception ex) {
            // TODO: 05 Oct 2018  
            ex.printStackTrace(System.err);
        }

        super.addFocusListener(this);
    }

    /**
     * @param evt Event
     */
    @Override
    public void focusGained(FocusEvent evt) {
        // siD 28/09/2018: Don't really care about this method.
    }

    /**
     * @param evt Event
     */
    @Override
    public void focusLost(FocusEvent evt) {
        if (input.isInputValid()) {
            setForeground(Color.black);
        } else {
            setForeground(SCARLET);
        }
    }
}

