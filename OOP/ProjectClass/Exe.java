class Exe {
  public static void main(String[] arg) {
    Project projectInstance = new Project();
    System.out.println( projectInstance.elevatorPitch() );

    Project piName = new Project("this Custom name");
    System.out.println( piName.elevatorPitch() );
    piName.setName("changed Name");
    System.out.println( piName.getName() );
    piName.setDescription("changed Description");
    System.out.println( piName.getDescription() );

    Project piDescName = new Project("3rd Name", "3rd desc");
    System.out.println( piDescName.elevatorPitch() );
    piDescName.setName("3rd changed Name");
    System.out.println( piDescName.getName() );
    piDescName.setDescription("3rd changed Description");
    System.out.println( piDescName.getDescription() );
  }
}
