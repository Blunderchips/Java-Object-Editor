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

    private final JPanel inputPanel; // FIXME: 29 Sep 2018 
    private final Object obj;

    public Obed(Object obj) {
        super(new BorderLayout());
        this.obj = obj;

        this.inputPanel = attachComponents(obj.getClass());
        add(new JScrollPane(inputPanel), BorderLayout.CENTER);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setToolTipText("Submit");
        btnSubmit.addActionListener(this);
        super.add(btnSubmit, BorderLayout.SOUTH);
    }

    JPanel attachComponents(Class c) {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        pnl.setBorder(BorderFactory.createTitledBorder(c.getSimpleName()));
        return attachComponents(c, pnl);
    }

    JPanel attachComponents(Class c, JPanel panel) {
        for (Field field : c.getDeclaredFields()) {
            // FIXME: 28 Sep 2018 ¯\_(ツ)_/¯
            Class type = field.getType();
            if (type.equals(String.class)) {
                panel.add(new StringInputComponent(field));
            } else if (type.equals(boolean.class)
                    || type.equals(Boolean.class)) {
                panel.add(new BooleanInputComponent(field));
            } else if (type.equals(short.class)
                    || type.equals(Short.class)) {
                panel.add(new ShortInputComponent(field));
            } else if (type.equals(int.class)
                    || type.equals(Integer.class)) {
                panel.add(new IntInputComponent(field));
            } else if (type.equals(long.class)
                    || type.equals(Long.class)) {
                panel.add(new LongInputComponent(field));
            } else if (type.equals(double.class)
                    || type.equals(Double.class)) {
                panel.add(new DoubleInputComponent(field));
            } else if (type.equals(float.class)
                    || type.equals(Float.class)) {
                panel.add(new FloatInputComponent(field));
            } else if (type.equals(byte.class)
                    || type.equals(Byte.class)) {
                panel.add(new ByteInputComponent(field));
            } else if (type.equals(char.class)
                    || type.equals(Character.class)) {
                panel.add(new CharInputComponent(field));
            }
            // TODO: 29 Sep 2018  
            //else {
            //    panel.add(attachComponents(type));
            //}
        }
        return panel;
    }

    public void actionPerformed(ActionEvent evt) {
        save();
    }

    // FIXME: 29 Sep 2018 
    private void save() {
        try {
            for (Component cmp : inputPanel.getComponents()) {
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
