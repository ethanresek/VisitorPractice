package visitor;

import element.Image;
import element.Table;
import element.Text;

public interface DocumentVisitor {

  public void visit(Text text);
  public void visit(Image image);
  public void visit(Table table);
}
