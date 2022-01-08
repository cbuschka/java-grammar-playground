package gp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode
@ToString
public class Rule {

    public final String productionSymbol;

    public final List<String> symbols;

    public Rule(String productionSymbol, String... symbols) {
        this.productionSymbol = productionSymbol;
        this.symbols = new ArrayList<>(Arrays.asList(symbols));
    }


    public Rule(String productionSymbol, List<String> symbols) {
        this.productionSymbol = productionSymbol;
        this.symbols = symbols;
    }
}
