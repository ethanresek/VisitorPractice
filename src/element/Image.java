package element;

import visitor.DocumentVisitor;

public class Image implements DocumentElement {
private String path;
private String caption;

  public Image(String path, String caption) {
    this.path = path;
    this.caption = caption;
  }

  @Override
  public void accept(DocumentVisitor visitor) {
    visitor.visit(this);
  }

  public String getPath() {
    return path;
  }

  public String getCaption() {
    return caption;
  }

}
