package gp;

import java.util.HashSet;
import java.util.Set;

public class UnreachableRulesRemover {

    public void apply(Grammar g) {
        Set<String> reachableSymbols = findReachableSymbols(g);
        g.rules.removeIf((r) -> !reachableSymbols.contains(r.productionSymbol));
    }

    private Set<String> findReachableSymbols(Grammar g) {
        if (g.startSymbol == null) {
            throw new IllegalStateException("No start symbol.");
        }

        Set<String> reachableSymbols = new HashSet<>();
        reachableSymbols.add(g.startSymbol);
        boolean done = false;
        while (!done) {
            done = true;
            for (Rule rule : g.rules) {
                if (reachableSymbols.contains(rule.productionSymbol)) {
                    for (String symbol : rule.symbols) {
                        if (!reachableSymbols.contains(symbol)) {
                            reachableSymbols.add(symbol);
                            done = false;
                        }
                    }
                }
            }
        }

        return reachableSymbols;
    }
}
