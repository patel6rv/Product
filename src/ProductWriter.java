import java.util.ArrayList;
import java.util.Scanner;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;

public class ProductWriter
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList <Product> productArrayList = new ArrayList<>();

        //list values
        String ID = "";
        String name = "";
        String description = "";
        double cost;

        //do while loop condition
        boolean check = true;

        System.out.println("Please enter your product(s).");

        do
        {
            name = SafeInput.getNonZeroLenString(in, "Please enter the product's name");
            description = SafeInput.getNonZeroLenString(in, "Please enter a description of the product (short sentence)");
            cost = SafeInput.getDouble(in, "Please enter the product's price");

            Product item = new Product(name, description, cost);
            productArrayList.add(item);

            check = SafeInput.getYNConfirm(in, "Do you wish to add another product?");
        } while(check);


        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTextData.txt");

        try
        {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(Product rec : productArrayList)
            {
                writer.write(rec.toCSVRecord());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
