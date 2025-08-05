package visitor;

import element.Image;
import element.Table;
import element.Text;

public class HTMLExportVisitor implements DocumentVisitor {
  private StringBuilder buffer;

  public HTMLExportVisitor() {
    buffer = new StringBuilder();
  }

  @Override
  public void visit(Text text) {
    buffer.append("<p>").append(text.getContent()).append("<p>\n");
  }

  @Override
  public void visit(Image image) {
    buffer.append("<img src='").append(image.getPath()).append("' />\n");
  }

  @Override
  public void visit(Table table) {
    buffer.append("<table>");

    for (String[] row : table.getRows()) {
      buffer.append("<tr>");
      buffer.append("<td>").append(String.join("</td><td>", row)).append("</td>");
      buffer.append("</tr>\n");
    }

    buffer.append("</table>\n");
  }
}
