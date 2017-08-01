import java.util.*;

public class Hashmap {
  public static void main(String[] args){
      // ImportHashmap PuzzleJava = new ImportHashmap();

      HashMap<String, String> trackList = new HashMap<>();

      trackList.put("Song A", "Text of song A");
      trackList.put("Song B", "Text of song B");
      trackList.put("Song C", "Text of song C");
      trackList.put("Song D", "Text of song D");

      String name = trackList.get("Song A");
      String text = trackList.get("Text of song A");

      for (String key : trackList.keySet() ){
        System.out.println(key + ": " + trackList.get(key));
      }
      // System.out.println(trackList);
  }
}
