package visitor;

import element.Image;
import element.Table;
import element.Text;

public class PlainTextExportVisitor implements DocumentVisitor {
  StringBuilder buffer;

  public PlainTextExportVisitor() {
    buffer = new StringBuilder();
  }

  @Override
  public void visit(Text text) {
    buffer.append(text.getContent()).append("\n");
  }

  @Override
  public void visit(Image image) {
    buffer.append("[Image: ").append(image.getCaption()).append("]\n");
    buffer.append("Path: ").append(image.getPath()).append("\n");
  }

  @Override
  public void visit(Table table) {

    for (String[] row : table.getRows()) {
      for (int i = 0; i < row.length - 1; i++) {
        if (row[i] != null) {
          buffer.append(row[i]).append(",");
        } else {
          buffer.append(",");
        }
      }

      if (row.length > 0 && row[row.length - 1] != null) {
        buffer.append(row[row.length - 1]);
      } else {
        buffer.append("");
      }

      buffer.append("\n");
    }

    buffer.append("\n");
  }
}
