import java.io.IOException;

public class ChessGUI {
    
    public BoardFrame boardframe;
    public static void main(String[] args) throws IOException {
        ChessGUI gui = new ChessGUI();
        gui.boardframe = new BoardFrame();
        gui.boardframe.setVisible(true);
        
    }
}
