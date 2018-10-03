// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See LICENSE.txt in this package.
package com.microsoft.alm.plugin.idea.common.ui.controls;

import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Use this class as the UI for a TextField where you want to add hint text. The
 * hint text is displayed as long as the control doesn't have focus and doesn't
 * have a value.
 * <br>
 * siD: Made minor modifications.
 *
 * @see <a href="https://github.com/Microsoft/vso-intellij/blob/master/plugin.idea/src/com/microsoft/alm/plugin/idea/common/ui/controls/HintTextFieldUI.java
 * ">Visual Studio Team Services Plugin for IntelliJ, Android Studio, & other Jetbrains IDEs GitHub Project</a>
 */
// https://github.com/Microsoft/vso-intellij/blob/master/plugin.idea/src/com/microsoft/alm/plugin/idea/common/ui/controls/HintTextFieldUI.java
public class HintTextFieldUI extends BasicTextFieldUI implements FocusListener {

    /**
     * Specifies a short hint that describes the expected value of the input field.
     */
    private final String hintText;

    /**
     * @param hint a short hint that describes the expected value of the input field
     */
    public HintTextFieldUI(String hint) {
        this.hintText = hint;
    }

    @Override
    protected void paintSafely(Graphics gfx) {
        super.paintSafely(gfx);
        JTextComponent cmp = getComponent();
        if (hintText != null && cmp.getText().isEmpty() && !cmp.hasFocus()) {
            gfx.setColor(Color.GRAY);

            final int fontSize = cmp.getFont().getSize();
            final int padding = (cmp.getHeight() - fontSize) / 2;
            final int x = cmp.getInsets().left;
            final int y = cmp.getHeight() - padding - 1;

            gfx.drawString(hintText, x, y);
        }
    }

    /**
     * Calls {@link #repaint()}.
     *
     * @param evt Event
     */
    public void focusGained(FocusEvent evt) {
        this.repaint();
    }

    /**
     * Calls {@link #repaint()}.
     *
     * @param evt Event
     */
    public void focusLost(FocusEvent evt) {
        this.repaint();
    }

    /**
     * Adds {@code this} focus listener.
     */
    @Override
    protected void installListeners() {
        super.installListeners();
        super.getComponent().addFocusListener(this);
    }

    /**
     * Removes {@code this} focus listener.
     */
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
