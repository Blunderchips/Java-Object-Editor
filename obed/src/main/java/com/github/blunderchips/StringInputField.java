package com.github.blunderchips;

import com.microsoft.alm.plugin.idea.common.ui.controls.HintTextFieldUI;

import javax.swing.*;
import java.lang.reflect.Field;

/**
 * Text input. Created 26/09/2018.
 */
// TODO: 28 Sep 2018 Rename to something better
public class StringInputField extends JTextField {

    public StringInputField(Field f) {
        String str = String.format("%s : %s",
                f.getName(), f.getType().getSimpleName());

        super.setToolTipText(str);
        super.setUI(new HintTextFieldUI(str));
    }
}

