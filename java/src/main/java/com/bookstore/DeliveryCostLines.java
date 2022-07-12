package com.bookstore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class DeliveryCostLines {

    private final List<DeliveryCostLine> lines;

    public static DeliveryCostLines none() {
        return new DeliveryCostLines();
    }

    public DeliveryCostLines(DeliveryCostLine... lines) {
        this(Arrays.asList(lines));
    }

    private DeliveryCostLines(List<DeliveryCostLine> lines) {
        this.lines = lines;
    }

    public DeliveryCostLines add(DeliveryCostLine... moreLines) {
        List<DeliveryCostLine> newLines = new ArrayList<>();
        newLines.addAll(Arrays.asList(moreLines));
        newLines.addAll(lines);
        return new DeliveryCostLines(newLines);
    }

    public void forEach(Consumer<DeliveryCostLine> c) {
        lines.forEach(c);
    }

}
