package element;

import visitor.DocumentVisitor;

public class Text implements DocumentElement {
  private String content;

  @Override
  public void accept(DocumentVisitor visitor) {
    visitor.visit(this);
  }

  public String getContent() {
    return content;
  }

}
