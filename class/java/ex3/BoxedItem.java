/** Class for objects that can be sold, packed, and shipped. */
public class BoxedItem implements Sellable, Transportable {
  private String descript; // description of this item
  private int price; // list price in cents
  private int weight; // weight in grams
  private boolean haz; // true if object is hazardous
  private int height = 0; // box height in centimeters
  private int width = 0; // box width in centimeters
  private int depth = 0; // box depth in centimeters

  /** Constructor */
  public BoxedItem(String desc, int p, int w, boolean h) {
    descript = desc;
    price = p;
    weight = w;
    haz = h;
  }

  public String description() {
    return descript;
  }

  public int listPrice() {
    return price;
  }

  public int lowestPrice() {
    return price / 2;
  }

  public int weight() {
    return weight;
  }

  public boolean isHazardous() {
    return haz;
  }

  public int insuredValue() {
    return price * 2;
  }

  public void setBox(int h, int w, int d) {
    height = h;
    width = w;
    depth = d;
  }

  public static void main(String[] args) {
    // Sellable s1 = new BoxedItem("Glass", 50, 20, false);
    // System.out.println(s1.listPrice());

    // System.out.println(s1.isHazardous());

    Transportable s1 = new BoxedItem("Glass", 50, 20, false);
    System.out.println(((BoxedItem) s1).listPrice());
  }
}
