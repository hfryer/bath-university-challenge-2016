 import java.io.BufferedReader;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.net.URL;
 import java.nio.Buffer;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;

 /** Takes the top 500 web address's from the alex website
 * Created by HarryFryer on 05/04/2016.
 */
public class Main {
    private FileWriter writer;

    private ArrayList<String> returns = new ArrayList<String>();



    public static void main (String args[]) {
        for(int x =0;x<20;x++){
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                String URL_to_check= input.readLine();
                URL oracle = new URL(URL_to_check);
                //URL oracle = new URL("http://google.com");
                BufferedReader in = new BufferedReader (new InputStreamReader(oracle.openStream()));

                ArrayList<String> result = new ArrayList<String>();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    Pattern TAG_REGEX1 = Pattern.compile("<title>(.+?)</title>");
                    Pattern TAG_REGEX2 = Pattern.compile("<meta name=(.+?)>");
                     List<String> titles = new ArrayList<String>();

                    Matcher matcher1 = TAG_REGEX1.matcher(inputLine);
                    Matcher matcher2 = TAG_REGEX2.matcher(inputLine);
                    while (matcher1.find()) {
                        titles.add(matcher1.group(1));
                        System.out.println("title = "+matcher1.group(1));
                    }
                    while (matcher2.find()) {
                        titles.add(matcher2.group(1));
                        System.out.println("<meta= "+matcher2.group(1));
                    }


                }
                input.close();
                in.close();

            } catch (IOException e) {

            }
        }
        /*try {
            writer= new FileWriter("routes.txt",false);
            for (String aResult:returns) {
                writer.write(aResult + " \n");

            }
            writer.close();

        }catch (IOException Ignored) {
        }*/

    }
}
