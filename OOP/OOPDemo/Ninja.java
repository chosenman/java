class Ninja extends Person {

    int darkness;

    Ninja (){
        this.name = "Ninja";
        this.energy = 10;
        this.darkness = 100;
    }

    void sayHello(){
        super.sayHello();
        System.out.println("I am the darkness!");
    }

    

}