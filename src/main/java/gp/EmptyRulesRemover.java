package gp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmptyRulesRemover {

    public void apply(Grammar g) {
        while (true) {
            Rule rule = findEmptyRule(g);
            if (rule == null) {
                break;
            }

            removeEmptyRule(g, rule);
        }
    }

    private void removeEmptyRule(Grammar g, Rule emptyRule) {

        List<Rule> newRules = new ArrayList<>();
        for (Rule rule : g.rules) {
            if (rule != emptyRule && rule.symbols.contains(emptyRule.productionSymbol)) {
                List<String> symbols = new ArrayList<>(rule.symbols);
                symbols.remove(emptyRule.productionSymbol);
                newRules.add(new Rule(rule.productionSymbol, symbols));
            }
        }

        g.rules.remove(emptyRule);
        for (Rule newRule : newRules) {
            if (!g.rules.contains(newRule)) {
                g.rules.add(newRule);
            }
        }
    }

    private Rule findEmptyRule(Grammar g) {
        for (Rule rule : g.rules) {
            if (!rule.productionSymbol.equals(g.startSymbol)
                    && rule.symbols.isEmpty()) {
                return rule;
            }
        }

        return null;
    }
}
