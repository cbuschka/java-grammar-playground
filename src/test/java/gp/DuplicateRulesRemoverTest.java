package gp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicateRulesRemoverTest {
    DuplicateRulesRemover remover = new DuplicateRulesRemover();

    @Test
    void removesDuplicates() {
        Grammar g = new Grammar("S");
        g.addRule("S", "X");
        g.addRule("S", "X");
        g.addRule("S", "X");
        g.addRule("S", "X");

        remover.apply(g);

        assertThat(g.rules).contains(
                new Rule("S", "X")
        );
    }

}