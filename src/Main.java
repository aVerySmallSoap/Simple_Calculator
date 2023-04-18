import Graphics.CalculatorG;
import Interfaces.IGraphics;

public class Main {
    static IGraphics graphics = new CalculatorG();

    public static void main(String[] args) {
        graphics.Initialize();
    }
}