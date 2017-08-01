public class StringManipulation {
  public String trimAndConcat(String one, String two) {
    // st = st.replaceAll("\\s+","")
    return one.replaceAll(" ","") + two.replaceAll(" ","");
  }

  public Integer getIndexOrNull(String str, char argChar) {
    if (str.indexOf(argChar) == -1){
      return null;
    } else {
      return str.indexOf(argChar);
    }
  }

  public Integer getIndexOrNull(String str, String str2) {
    if (str.indexOf(str2) == -1){
      return null;
    } else {
      return str.indexOf(str2);
    }
  }

  public String concatSubstring(String str1, int int1, int int2, String str2) {
    return str1.substring(int1,int2) + str2;
  }


}
