package com.bas.detector.util;

import com.bas.detector.entity.Position;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.io.Files.readLines;

public class CSVLoader {

    public static List<Position> readPositionsFromCSV(String filePath) throws IOException {
        List<Position> positions = new ArrayList<>();

        File file = new File(Objects.requireNonNull(CSVLoader.class.getClassLoader().getResource(filePath)).getFile());

        List<String> lines = readLines(file, StandardCharsets.UTF_8);
        boolean firstLine = true;
        for (String line : lines) {
            String[] columns = line.split(",");
            if (columns.length == 2 && !firstLine) {
                String symbol = columns[0].trim();
                int positionSize = Integer.parseInt(columns[1].trim());
                positions.add(new Position(symbol, positionSize));
            } else {
                firstLine = false;
            }
        }
        return positions;
    }
}
