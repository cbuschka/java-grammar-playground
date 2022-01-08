package gp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmptyRulesRemoverTest {
    EmptyRulesRemover remover = new EmptyRulesRemover();

    @Test
    void removedEmptyRules() {
        Grammar g = new Grammar("S");
        g.addRule("S", "A");
        g.addRule("S", "B");
        g.addRule("A", "a");
        g.addRule("A");
        g.addRule("B", "b");

        remover.apply(g);

        assertThat(g.rules).contains(
                new Rule("S", "A"),
                new Rule("B", "b"),
                new Rule("S")
        );
    }


    @Test
    void removesIndirections() {
        Grammar g = new Grammar("S");
        g.addRule("S", "X");
        g.addRule("X", "Y");
        g.addRule("Y");
        g.addRule("X");

        remover.apply(g);

        assertThat(g.rules).contains(
                new Rule("S")
        );
    }

}