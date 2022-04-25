package animals;

abstract class Animal {
    int id;
    public Animal(int id){
        this.id = id;
    }
    public abstract void animalSound();
    public void sleep(){
        System.out.println("zzz");
    }
}
