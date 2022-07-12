package com.bookstore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.bookstore.DeliveryCostCalculator.Calculation;

public class DeliveryCostLines {

    private final List<DeliveryCostCalculator.Calculation> lines;

    public static DeliveryCostLines none() {
        return new DeliveryCostLines();
    }

    public DeliveryCostLines(DeliveryCostCalculator.Calculation... lines) {
        this(Arrays.asList(lines));
    }

    private DeliveryCostLines(List<Calculation> lines) {
        this.lines = lines;
    }

    public DeliveryCostLines add(DeliveryCostCalculator.Calculation... moreLines) {
        List<DeliveryCostCalculator.Calculation> newLines = new ArrayList<>();
        newLines.addAll(Arrays.asList(moreLines));
        newLines.addAll(lines);
        return new DeliveryCostLines(newLines);
    }

    public void forEach(Consumer<DeliveryCostCalculator.Calculation> c) {
        lines.forEach(c);
    }

}
