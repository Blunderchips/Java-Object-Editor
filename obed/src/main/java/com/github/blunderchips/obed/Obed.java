package com.github.blunderchips.obed;

import com.github.blunderchips.obed.input.*;
import org.oxbow.swingbits.dialog.task.TaskDialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Obed Java Object Editor (<b>Obed</b>).
 * Created 24th September 2018.
 *
 * @author Matthew Van der Bijl
 */
public class Obed extends JPanel implements ActionListener {

    private final JPanel inputPanel; // FIXME: 29 Sep 2018
    /**
     * The {@code Object} to be edited.
     */
    private final Object obj;

    /**
     * @param obj The {@code Object} to be edited
     */
    public Obed(Object obj) {
        this(obj, true);
    }

    /**
     * @param obj    The {@code Object} to be edited
     * @param isRoot Whether {@code this} is the first {@link JPanel} to be created or not
     */
    private Obed(Object obj, boolean isRoot) {
        super(new BorderLayout());
        this.obj = obj;

        this.inputPanel = attachComponents(obj.getClass());
        this.inputPanel.setBorder(BorderFactory.createTitledBorder(obj.getClass().getSimpleName()));
        super.add(new JScrollPane(inputPanel), BorderLayout.CENTER);

        if (isRoot) {
            JButton btnSubmit = new JButton("Submit");
            btnSubmit.setToolTipText("Submit");
            btnSubmit.addActionListener(this);
            super.add(btnSubmit, BorderLayout.SOUTH);
        }
    }

    /**
     * To make exception handling more generic.
     * <br>TODO
     *
     * @param t the exception that has occurred
     */
    private static void err(Throwable t) {
        t.printStackTrace(System.err);
        Toolkit.getDefaultToolkit().beep();
        TaskDialogs.showException(t);
    }

    private JPanel attachComponents(Class c) {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        return attachComponents(c, pnl);
    }

    private JPanel attachComponents(Class c, JPanel panel) {
        for (Field field : c.getDeclaredFields()) {

            int mod = field.getModifiers();
            if (Modifier.isFinal(mod) || Modifier.isStatic(mod)) {
                continue; // siD 29/09/2018: Ignore all static and/or final attributes.
            }

            // FIXME: 28 Sep 2018 ¯\_(ツ)_/¯
            Class type = field.getType();
            if (type.equals(String.class)) {
                panel.add(new StringInputComponent(field, obj));
            } else if (type.equals(boolean.class)
                    || type.equals(Boolean.class)) {
                panel.add(new BooleanInputComponent(field, obj));
            } else if (type.equals(short.class)
                    || type.equals(Short.class)) {
                panel.add(new ShortInputComponent(field, obj));
            } else if (type.equals(int.class)
                    || type.equals(Integer.class)) {
                panel.add(new IntInputComponent(field, obj));
            } else if (type.equals(long.class)
                    || type.equals(Long.class)) {
                panel.add(new LongInputComponent(field, obj));
            } else if (type.equals(double.class)
                    || type.equals(Double.class)) {
                panel.add(new DoubleInputComponent(field, obj));
            } else if (type.equals(float.class)
                    || type.equals(Float.class)) {
                panel.add(new FloatInputComponent(field, obj));
            } else if (type.equals(byte.class)
                    || type.equals(Byte.class)) {
                panel.add(new ByteInputComponent(field, obj));
            } else if (type.equals(char.class)
                    || type.equals(Character.class)) {
                panel.add(new CharInputComponent(field, obj));
            } else {
                try {
                    Object nestedObject = field.get(obj);
                    if (nestedObject == null) {
                        nestedObject = field.getType().newInstance();
                        field.set(obj, nestedObject);
                    }

                    JPanel obedPanel = new Obed(nestedObject, false);
                    obedPanel.setBorder(BorderFactory.createTitledBorder(
                            String.format("%s : %s", field.getName(), type.getSimpleName())));
                    panel.add(obedPanel);
                } catch (Exception ex) {
                    Obed.err(ex);
                }
            }
        }
        return panel;
    }

    private void save() {
        try {
            save(inputPanel.getComponents());
        } catch (IllegalAccessException | NumberFormatException ex) {
            Obed.err(ex);
        }
        System.out.println(obj);
    }

    // FIXME: 29 Sep 2018
    private void save(Component[] arr) throws IllegalAccessException {
        for (Component cmp : arr) {
            if (cmp instanceof InputComponent) {
                ((InputComponent) cmp).save();
            }
            if (cmp instanceof Container) {
                save(((Container) cmp).getComponents());
            }
        }
    }

    /**
     * Invoked when the submit button is clicked.
     *
     * @param evt Event
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        save();
    }
}
