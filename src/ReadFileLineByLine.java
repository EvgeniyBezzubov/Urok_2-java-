import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadFileLineByLine {

    // построчное считывание файла
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\user\\IdeaProjects\\urok_2\\src\\file.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();


            while (line != null) {


                int family_1 = line.indexOf(":");
                int family_2 = line.indexOf(",");

                int mark = line.indexOf(":",family_1+1);
                int predmet = line.indexOf(":",mark+1);

              //  System.out.println(family_2);

                StringBuffer strBuffer = new StringBuffer(line);
                //strBuffer.append(index);
                // strBuffer.append(line.length());


                char[] family_name = new char[family_2-family_1];
                strBuffer.getChars(family_1, family_2, family_name, 0);
                System.out.println(family_name); // orl

                String family_name_string = String.valueOf(family_name);
                System.out.println(family_name_string);
                System.out.println("читай выше");
                //String str = "" + family_name;
               // System.out.println(str); // orl
                char[] mark_family = new char[mark+3-mark+2];
                strBuffer.getChars(mark+2, mark+3, mark_family, 0);
                String mark_family_string = String.valueOf(mark_family);



                char[] predmet_family = new char[line.length()-predmet+1];
                strBuffer.getChars(predmet+1, line.length(), predmet_family, 0);
                String predmet_family_string = String.valueOf(predmet_family);
                System.out.println(family_name_string);
                System.out.println(predmet_family); // orl



                System.out.println(strBuffer);




                // считываем остальные строки в цикле
                line = reader.readLine();

                try(FileWriter writer = new FileWriter("notes3.txt", true))
                {
                    // запись всей строки
                    writer.append("Студент ");
                    writer.write(family_name_string);
                    writer.append(" получил  ");
                    writer.append(mark_family_string);
                    writer.append(" по предмету ");
                    writer.append(predmet_family_string);
                    // запись по символам
                    writer.append('\n');

                    writer.flush();
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}