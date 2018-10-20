package com.github.blunderchips.obed;

import javax.swing.*;
import java.awt.*;

/**
 * {@link JFrame} with a {@link Obed} {@link JPanel} added to it.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see com.github.blunderchips.obed.Obed
 */
public class ObedFrame extends JFrame {

    public ObedFrame(Object obj, Component parent) throws HeadlessException {
        super("~ Java Object Editor ~");
        super.setLocationRelativeTo(parent);
        // super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.add(new Obed(obj));

        pack();
        int size = Math.max(getWidth(), getHeight());
        super.setSize(size, size);
    }

    /**
     * Releases all resources of this object.
     */
    @Override
    public void dispose() {
        System.out.println("Goodbye(:");
        super.dispose();
    }

    /**
     * For testing.
     *
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        new ObedFrame(new n(), null).setVisible(true);
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
            String sb = "n{" + "str='" + str + '\'' +
                    ", bb=" + bb +
                    ", ab=" + ab +
                    '}';
            return sb;
        }
    }

    /**
     * For testing.
     */
    public static class a {

        public String str;
        public long l;
        public char c;
        public int i;
        public double d;
        public float f = 10.75f;
        public short s;
        public byte b;
        public boolean bool = true;
        public Boolean asd = false;

        @Override
        public String toString() {
            String sb = "a{" + "str='" + str + '\'' +
                    ", l=" + l +
                    ", c=" + c +
                    ", i=" + i +
                    ", d=" + d +
                    ", f=" + f +
                    ", s=" + s +
                    ", b=" + b +
                    ", bool=" + bool +
                    ", asd=" + asd +
                    '}';
            return sb;
        }
    }
}
