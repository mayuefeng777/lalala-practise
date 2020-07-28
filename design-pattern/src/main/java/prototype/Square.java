package prototype;

/**
 * @author mayuefeng
 * @date 2020-07-27
 */
public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
