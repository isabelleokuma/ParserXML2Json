package parser;

import org.json.JSONObject;
import org.json.XML;
import java.io.*;

public class Main {
    public static int fator = 4;

    public static void main(String[] args) throws Exception {
        String arqJson = "output.json";

        try
        {
            File arqXML = new File("input.xml");
            InputStream inputStream = new FileInputStream(arqXML);
            StringBuilder builder = new StringBuilder();
            int parametro;
            while ((parametro = inputStream.read()) != -1)
            {
                builder.append((char) parametro);
            }

            String xml = builder.toString();
            JSONObject jsonObj = XML.toJSONObject(xml);
            System.out.print(jsonObj);
            FileWriter fileWriter = new FileWriter(arqJson);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(jsonObj.toString(fator));
            bufferedWriter.close();

        } catch (IOException ex)
        {
            System.out.println(
                    "Error writing to file '"
                            + arqJson + "'");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}