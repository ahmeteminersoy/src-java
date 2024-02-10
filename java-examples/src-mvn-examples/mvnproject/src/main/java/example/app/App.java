package example.app;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

final class App {
    private App() {

    }

    public static void main(String[] args) {
        startCode(args);
    }

    public static void startCode(String[] args) {
        run(args);
    }
    public static void run(String[] args){
        String[] files = args.clone();
        try {
            for (String i : files)
                Files.delete(Paths.get(i));

        }
        catch (NoSuchFileException ex) {
            System.out.println("Hata: Dosya bulunamadı.");
        }
        catch (DirectoryNotEmptyException ex) {
            System.out.println("Hata: Dosya bir klasör değil.");
        }
        catch (IOException ex) {
            System.out.println("Hata: Dosya silinirken bir IOException oluştu.");
            ex.printStackTrace();

        }


    }
}
