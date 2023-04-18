package Interfaces;
public interface IGraphics {
    void Draw();

    default void Initialize(){
        Draw();
    }
}
