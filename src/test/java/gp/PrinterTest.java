package gp;

import org.junit.jupiter.api.Test;

class PrinterTest {

    @Test
    void test() {
        Grammar g = new Grammar("S");
        g.addRule("S", "A");
        g.addRule("S", "B");
        g.addRule("A", "a");
        g.addRule("B", "b");

        Printer p = new Printer();
        p.print(g);
    }
}