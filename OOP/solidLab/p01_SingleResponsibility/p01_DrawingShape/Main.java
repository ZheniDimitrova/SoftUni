package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.ConsoleRenderer;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class Main {
    public static void main(String[] args) {


        Shape shape = new Rectangle(13, 4);
        DrawingManager drawingManager = new DrawingManagerImpl(new ConsoleRenderer());
        drawingManager.draw(shape);
    }
}
