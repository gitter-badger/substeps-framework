package com.technophobia.substeps.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Background {

    private final int lineNumber;
    private final String description;
    private final List<Step> steps;
    private final String rawText;
    private final int sourceStartOffset;

    public Background(final int lineNumber, final String rawText, final File sourceFile, final int sourceStartOffset) {
        super();
        this.lineNumber = lineNumber;
        this.rawText = rawText;
        this.description = descriptionFor(rawText);
        this.steps = stepsFrom(lineNumber, rawText, sourceFile);
        this.sourceStartOffset = sourceStartOffset;
    }

    private List<Step> stepsFrom(final int backgroundLineNumber, final String backgroundText, final File sourceFile) {
        final List<Step> backgroundSteps = new ArrayList<Step>();
        final String[] bLines = backgroundText.split("\n");
        for (int i = 1; i < bLines.length; i++) {

            // TODO
            backgroundSteps.add(new Step(bLines[i], sourceFile, backgroundLineNumber + i, -1));
        }
        return Collections.unmodifiableList(backgroundSteps);
    }

    public String getDescription() {
        return this.description;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public String getRawText() {
        return this.rawText;
    }

    public List<Step> getSteps() {
        return this.steps;
    }

    private String descriptionFor(final String text) {
        final int startIndex = text.indexOf(":") + 1;
        final int endIndex = text.indexOf(System.getProperty("line.separator"));
        return text.substring(startIndex, endIndex).trim();
    }
}