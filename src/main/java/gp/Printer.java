package gp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Printer {

    public void print(Grammar g) {

        Map<String, List<Rule>> groupedRules = new LinkedHashMap<>();
        g.rules.forEach((r) -> {
            List<Rule> rules = groupedRules.computeIfAbsent(r.productionSymbol, (x) -> new ArrayList<>());
            rules.add(r);
            groupedRules.put(r.productionSymbol, rules);
        });

        for (Map.Entry<String, List<Rule>> symbolRules : groupedRules.entrySet()) {
            for (Rule rule : symbolRules.getValue()) {
                System.err.println(rule.productionSymbol + " -> " + rule.symbols);
            }
        }
    }

}
