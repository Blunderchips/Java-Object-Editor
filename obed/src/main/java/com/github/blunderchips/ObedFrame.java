package com.github.blunderchips;

import javax.swing.*;
import java.awt.*;
import java.util.StringJoiner;

/**
 * For testing.
 */
public class ObedFrame extends JFrame {

    public ObedFrame(Component parent) throws HeadlessException {
        super("~ Java Object Editor ~");
        super.setLocationRelativeTo(parent);
        super.add(new Obed(new n()));

        pack();
        int size = Math.max(getWidth(), getHeight());
        super.setSize(size, size);
    }

    @Override
    public void dispose() {
        System.out.println("Goodbye(:");
        super.dispose();
    }

    /**
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        new ObedFrame(null).setVisible(true);
    }

    /**
     * Class for testing.
     */
    public static class n {

        public String str;
        //        public long l;
//        public char c;
//        public int i;
//        public double d;
//        public float f;
//        public short s;
//        public byte b;
//        public boolean bool;
//        public Boolean asd;
        public a bb;
        public a ab;

        @Override
        public String toString() {
            return new StringJoiner(", ", n.class.getSimpleName() + "[", "]")
                    .add("str='" + str + "'")
//                    .add("l=" + l)
//                    .add("c=" + c)
//                    .add("i=" + i)
//                    .add("d=" + d)
//                    .add("f=" + f)
//                    .add("s=" + s)
//                    .add("b=" + b)
//                    .add("bool=" + bool)
//                    .add("asd=" + asd)
                    .add("bb=" + bb)
                    .add("ab=" + ab)
                    .toString();
        }
    }

    public static class a {

        public String str;
        public long l;
        public char c;
        public int i;
        public double d;
        public float f;
        public short s;
        public byte b;
        public boolean bool;
        public Boolean asd;

        @Override
        public String toString() {
            return new StringJoiner(", ", a.class.getSimpleName() + "[", "]")
                    .add("str='" + str + "'")
                    .add("l=" + l)
                    .add("c=" + c)
                    .add("i=" + i)
                    .add("d=" + d)
                    .add("f=" + f)
                    .add("s=" + s)
                    .add("b=" + b)
                    .add("bool=" + bool)
                    .add("asd=" + asd)
                    .toString();
        }
    }
}
