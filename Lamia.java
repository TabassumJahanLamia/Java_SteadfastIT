import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String inp = "src/main/java/inp.txt";
        Map<String, Integer> hash = new HashMap<>();

        try (BufferedReader rd = new BufferedReader(new FileReader(inp))) {
            String s;
            while ((s = rd.readLine()) != null) {
  
                String[] wd = s.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
                for (String w : wd) {
                    if (!w.isEmpty()) {
                        hash.put(w, hash.getOrDefault(w, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error Reading file: " + e.getMessage());
        }


        List<Map.Entry<String, Integer>> res = new ArrayList<>(hash.entrySet());
        res.sort(Map.Entry.comparingByKey());

 
        for (Map.Entry<String, Integer> ans : res) {
            System.out.println(ans.getKey() + ": " + ans.getValue());
        }
    }
}
