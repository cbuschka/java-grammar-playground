package gp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UnreachableRulesRemoverTest {
    UnreachableRulesRemover remover = new UnreachableRulesRemover();

    @Test
    void removesUnreachable() {
        Grammar g = new Grammar("S");
        g.addRule("S", "A");
        g.addRule("A", "a");
        g.addRule("B", "b");

        remover.apply(g);

        assertThat(g.rules).hasSize(2);
        assertThat(g.rules).containsExactly(
                new Rule("S", "A"),
                new Rule("A", "a"));
    }

}