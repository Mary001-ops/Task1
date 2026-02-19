package Utils;



import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

    public class Data {
 /*
   This is a JSON object that will hold the data from the JSON file
    as if i make string variable and call it x and assign the value of the
    JSON file to it then i will have to parse it every time i want
    to use it but if i make it a JSON object then i can directly
    call the values from it without parsing it every time
    */
        private JSONObject jsonObject;

        //Constructor that takes a JSONObject and initializes the jsonObject variable

        public Data(String filepath) {
            /*
        we use try catch block to handle any exceptions that
        may occur while reading the JSON file
         */
            try {
                //this method to print the path of the JSON file that is being read
                // in case of any issues with the file path
                System.out.println("Trying to load JSON from: " + filepath);

                // قراءة الملف
                 /*this method to read the JSON file and assign it to the jsonObject variable
            you can consider parser as a tool that reads the JSON file and converts it into
             a format that can be easily used in Java, in this case, a JSONObject.
             */
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(filepath));
                
              /*
            casting the object returned by the parser to a JSONObject so
            that we can use it to access the data in the JSON file
             */
                jsonObject = (JSONObject) obj;

                System.out.println("JSON loaded successfully: " + jsonObject);

            } catch (Exception e) {
                 /*this method to print the stack trace of any exceptions that
             occur while reading the JSON file and also print a message indicating that
             the file could not be read, along with the file path for easier debugging
             */
                System.err.println("Error loading JSON! Check file path and JSON syntax.");
                e.printStackTrace();
            }
        }

        // Method لجلب البيانات لأي سيناريو
        public String getData(String scenario, String key) {
            if (jsonObject == null) {
                System.err.println("JSON Object is null! Cannot fetch data.");
                return null;
            }

            JSONObject scenarioObject = (JSONObject) jsonObject.get(scenario);

            if (scenarioObject == null) {
                System.err.println("Scenario '" + scenario + "' not found in JSON!");
                return null;
            }

            String value = (String) scenarioObject.get(key);

            if (value == null) {
                System.err.println("Key '" + key + "' not found in scenario '" + scenario + "'!");
            }

            return value;
        }
    }
