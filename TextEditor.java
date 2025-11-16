import java.util.Stack;
import java.util.Scanner;

public class TextEditor {

    private String text = "";
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    public void write(String newText) {
        undoStack.push(text);        
        text += newText;              
        redoStack.clear();            
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(text);     
            text = undoStack.pop();   
        } else {
            System.out.println("Tidak ada yang bisa di-undo!");
        }
    }

    
    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(text);     
            text = redoStack.pop();   
        } else {
            System.out.println("Tidak ada yang bisa di-redo!");
        }
    }

    
    public void show() {
        System.out.println("Isi Text Editor: " + text);
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n-- TEXT EDITOR --");
            System.out.println("1. Write");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show");
            System.out.println("5. Exit");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan teks: ");
                    String teks = sc.nextLine();
                    editor.write(teks);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.show();
                    break;
                case 5:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }

        } while (pilihan != 5);

        sc.close();
    }
}
