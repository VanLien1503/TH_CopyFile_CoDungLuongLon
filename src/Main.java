import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
   private static void copyFileUsingJava7Files(File source,File dest) throws IOException {
       Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

    }
   private static void copyFileUsingStream(File source,File dest) throws IOException {
       InputStream is = null;
       OutputStream os = null;
       try {
           is =new FileInputStream(source);
           os = new FileOutputStream(dest);
           byte[] bytes=new byte[1024];
           int length;
           while ((length = is.read(bytes))>0){
               os.write(bytes,0,length);
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       finally {
           is.close();
           os.close();
       }
   }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter source file");
        String souPath = sc.nextLine();

        System.out.println("enter destination file");
        String desPath = sc.nextLine();

        File sourceFile = new File(souPath);
        File destFile = new File(desPath);

        try {
//            copyFileUsingJava7Files(sourceFile,destFile);
            System.out.println("copy completed");
            copyFileUsingStream(sourceFile,destFile);

        } catch (IOException e) {
            System.out.println("can't copy that file "+e.getMessage());
            System.out.println(e.getMessage());
        }

    }
}
