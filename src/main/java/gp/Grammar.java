package gp;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@ToString
public class Grammar {

    public final String startSymbol;

    public final List<Rule> rules = new ArrayList<>();

    public void addRule(String productionSymbol, String... symbols) {
        rules.add(new Rule(productionSymbol, symbols));
    }
}
