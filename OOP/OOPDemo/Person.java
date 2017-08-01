class Person {

    protected int energy;
    protected String name;
    Person(){ 
        this(50);
    }
    Person(int energy){
        this.energy = energy;
        this.name = "No Name";
    }
    Person(int energy, String name){
        this.energy = energy;
        this.name = name;
    }


    void sayHello(){
        System.out.println(String.format("Hello my name is %s\nI have %d energy", this.name, this.energy));
    }
    void setEnergy(int energy){
        this.energy = energy;
    }
    int getEnergy(){
        return this.energy;
    }

    void setName(String name){
        this.name = name;
    }
    
    String getName(){
        return this.name;
    }

}