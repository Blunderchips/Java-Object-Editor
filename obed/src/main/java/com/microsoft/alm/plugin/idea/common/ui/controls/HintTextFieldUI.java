// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the project root.
package com.microsoft.alm.plugin.idea.common.ui.controls;

import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Use this class as the UI for a TextField where you want to add hint text. The
 * hint text is displayed as long as the control doesn't have focus and doesn't
 * have a value. siD: Made minor modifications.
 *
 * @see <a href="https://github.com/Microsoft/vso-intellij/blob/master/plugin.idea/src/com/microsoft/alm/plugin/idea/common/ui/controls/HintTextFieldUI.java
 * ">GitHub</a>
 */
// https://github.com/Microsoft/vso-intellij/blob/master/plugin.idea/src/com/microsoft/alm/plugin/idea/common/ui/controls/HintTextFieldUI.java
public class HintTextFieldUI extends BasicTextFieldUI implements FocusListener {

    private final String hintText;

    public HintTextFieldUI(String hint) {
        this.hintText = hint;
    }

    @Override
    protected void paintSafely(Graphics gfx) {
        super.paintSafely(gfx);
        JTextComponent component = getComponent();
        if (hintText != null && component.getText().isEmpty() && !component.hasFocus()) {
            gfx.setColor(Color.GRAY);

            final int fontSize = component.getFont().getSize();
            final int padding = (component.getHeight() - fontSize) / 2;
            final int x = component.getInsets().left;
            final int y = component.getHeight() - padding - 1;

            gfx.drawString(hintText, x, y);
        }
    }

    public void focusGained(FocusEvent evt) {
        this.repaint();
    }

    public void focusLost(FocusEvent evt) {
        this.repaint();
    }

    @Override
    protected void installListeners() {
        super.installListeners();
        super.getComponent().addFocusListener(this);
    }

    @Override
    protected void uninstallListeners() {
        super.uninstallListeners();
        super.getComponent().removeFocusListener(this);
    }

    private void repaint() {
        if (getComponent() != null) {
            super.getComponent().repaint();
        }
    }
}
