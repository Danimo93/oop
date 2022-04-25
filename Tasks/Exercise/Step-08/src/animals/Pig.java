package animals;

class Pig extends Mammal {

    public Pig(int id){
        super(id);
    }
    public void animalSound(){
        System.out.println("The pig says: wee wee");
    }

    @Override
    public void provideMilkForBaby() {
        System.out.println("Providing milk through one of my 10-14 teats");
    }

    @Override
    public String toString() {
        return "Pig{" +
                "id=" + id +
                '}';
    }
}
