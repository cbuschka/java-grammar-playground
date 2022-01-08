package gp;

public class DuplicateRulesRemover {

    public void apply(Grammar g) {
        while (true) {
            boolean changed = false;
            for (Rule rule : g.rules) {
                changed = removeDuplicatesFor(g, rule);
                if (changed) {
                    break;
                }
            }

            if (!changed) {
                break;
            }
        }
    }

    private boolean removeDuplicatesFor(Grammar g, Rule rule) {
        return g.rules.removeIf((r) -> rule != r && rule.equals(r));
    }
}
