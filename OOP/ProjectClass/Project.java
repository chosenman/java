public class Project {
  private String name;
  private String description;


  Project(){
    this.name = "default name";
    this.description = "def description";
  }

  Project(String name) {
    this.name = name;
  }

  Project(String name, String description) {
    this.name = name;
    this.description = description;
  }

  String elevatorPitch(){
      return "---\nName: " + this.name + "\n Description: " + this.description;
  }
 // NAME SET GET
  void setName(String name){
    this.name = name;
  }
  String getName(){
    return this.name;
  }
 // DESCRIPTION SET GET
  void setDescription(String description){
    this.description = description;
  }
  String getDescription(){
    return this.description;
  }


  void help(){
    System.out.println("Help description about constructor " + this.getClass().getSimpleName() );
  }
}
