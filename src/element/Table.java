package element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import visitor.DocumentVisitor;

public class Table implements DocumentElement {
private List<String[]> rows;

  public Table(List<String[]> rows) {
    this.rows = rows;
  }

  public List<String[]> getRows() {
    List<String[]> returnList = new ArrayList<>();
    for (String[] row : returnList) {
      returnList.add(Arrays.copyOf(row, row.length));
    }
    return returnList;
  }

  @Override
  public void accept(DocumentVisitor visitor) {
    visitor.visit(this);
  }

}
