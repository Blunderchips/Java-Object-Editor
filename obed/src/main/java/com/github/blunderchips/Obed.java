package com.github.blunderchips;

import com.github.blunderchips.input.*;
import org.oxbow.swingbits.dialog.task.TaskDialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * Java Object Editor.
 * Created 24th September 2018.
 *
 * @author Matthew Van der Bijl
 */
public class Obed extends JPanel implements ActionListener {

    private Object obj;
    private JButton btnSubmit;

    public Obed(Object obj) {
        super.setLayout(new GridLayout(0, 1));

        this.obj = obj;

        for (Field f : obj.getClass().getDeclaredFields()) {
            add(getInputComponent(f));
        }

        this.btnSubmit = new JButton("Submit");
        this.btnSubmit.setToolTipText("Submit");
        this.btnSubmit.addActionListener(this);
        super.add(new JSeparator());
        super.add(btnSubmit);
    }

    public Component getInputComponent(Field f) throws IllegalArgumentException {
        // FIXME: 28 Sep 2018 ¯\_(ツ)_/¯
        if (f.getType().equals(String.class)) {
            return new StringInputComponent(f);
        } else if (f.getType().equals(boolean.class)) {
            return new BooleanInputComponent(f);
        } else if (f.getType().equals(short.class)) {
            return new ShortInputComponent(f);
        } else if (f.getType().equals(int.class)) {
            return new IntInputComponent(f);
        } else if (f.getType().equals(long.class)) {
            return new LongInputComponent(f);
        } else if (f.getType().equals(double.class)) {
            return new DoubleInputComponent(f);
        } else if (f.getType().equals(float.class)) {
            return new FloatInputComponent(f);
        } else if (f.getType().equals(byte.class)) {
            return new ByteInputComponent(f);
        } else if (f.getType().equals(char.class)) {
            return new CharInputComponent(f);
        }

        JLabel err = new JLabel(String.format("%s : %s", f.getName(), f.getType().getSimpleName()));
        err.setToolTipText(String.format("%s is unsupported.", f.getType().getName()));
        return err;
    }

    public void actionPerformed(ActionEvent evt) {
        save();
    }

    private void save() {
        try {
            for (Component cmp : getComponents()) {
                if (cmp instanceof InputComponent) {
                    ((InputComponent) cmp).save(obj);
                }
            }
        } catch (IllegalAccessException | NumberFormatException ex) {
            ex.printStackTrace(System.err);
            Toolkit.getDefaultToolkit().beep();
            TaskDialogs.showException(ex);
        }
        System.out.println(obj);
    }
}
