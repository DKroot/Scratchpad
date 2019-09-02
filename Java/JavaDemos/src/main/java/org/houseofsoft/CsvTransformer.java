package org.houseofsoft;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

@Slf4j
public class CsvTransformer {

  private static String CSV_FILE_PATH = "data/Journal Classification Sample.csv";
  private static String TRANSFORMED_FILE_PATH = "data/JournalClassificationSample.java";

  public static void main(String[] args) throws FileNotFoundException, IOException {
    log.info("Opening {} ...", CSV_FILE_PATH);
    try (Reader in = new FileReader(CSV_FILE_PATH); Writer out = new FileWriter(
        TRANSFORMED_FILE_PATH)) {
      String currentJournal = null;
      List<ClassificationEntry> currentClassification = new ArrayList<>();
      for (CSVRecord record : CSVFormat.EXCEL.withHeader().parse(in)) {
        String newJournal = record.get("Journal Name (Title Case)");
        if (!newJournal.equals(currentJournal)) {
          if (currentJournal != null) {
            classify(currentJournal, currentClassification, out);
            currentClassification = new ArrayList<>();
          }
          currentJournal = newJournal;
        }
        currentClassification
            .add(new ClassificationEntry(record.get("disc_id"), record.get("subd_id")));

      }
      classify(currentJournal, currentClassification, out);
    }
  }

  private static void classify(String journal, List<ClassificationEntry> classification, Writer out)
      throws IOException {
    log.debug("Journal '{}', classification '{}'", journal, classification);
    out.write(String.format("JOURNAL_CLASSIFICATION.put(\"%s\", new Discipline[] {", journal));
    int i = 0;
    for (ClassificationEntry classificationEntry : classification) {
      out.write(String.format("\n    new Discipline(%s, %s)", classificationEntry.getDisciplineId(),
          classificationEntry.getSubdisciplineId()));
      if (i++ < classification.size() - 1) { // not the last
        out.write(",");
      }
    }
    out.write("\n});\n");
  }

  @Data
  static class ClassificationEntry {

    int disciplineId;
    int subdisciplineId;

    public ClassificationEntry(String disciplineId, String subdisciplineId) {
      this.disciplineId = Integer.parseInt(disciplineId);
      this.subdisciplineId = Integer.parseInt(subdisciplineId);
    }
  }
}
