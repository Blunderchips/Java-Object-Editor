package com.github.blunderchips;

import javax.swing.*;
import java.awt.*;
import java.util.StringJoiner;

public class ObedFrame extends JFrame {

    public ObedFrame(Component parent) throws HeadlessException {
        super("~ Java Object Editor ~");
        super.setLocationRelativeTo(null);
        super.add(new Obed(new n()));

        pack();
        int size = Math.max(getWidth(), getHeight());
        super.setSize(size, size);
    }

    /**
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        new ObedFrame(null).setVisible(true);
    }

    public static class n {

        public String str;
        public long l;
        public char c;
        public int i;
        public double d;
        public float f;
        public short s;
        public byte b;
        public boolean bool;

        @Override
        public String toString() {
            return new StringJoiner(", ", n.class.getSimpleName() + "[", "]")
                    .add("l=" + l)
                    .add("str='" + str + "'")
                    .add("c=" + c)
                    .add("i=" + i)
                    .add("d=" + d)
                    .add("f=" + f)
                    .add("s=" + s)
                    .add("b=" + b)
                    .add("bool=" + bool)
                    .toString();
        }
    }
}
