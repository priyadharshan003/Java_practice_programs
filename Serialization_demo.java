import java.io.*;
class Animal {
    int i = 20;
}
class Dog extends Animal implements Serializable{
    transient int j =10;
//    private void writeobject(){
//
//    }
}

class Serialization_Demo{
    public static void main(String[] args) throws Exception {
        Dog d1 = new Dog();
        System.out.println(d1.i+"...."+d1.j);

        FileOutputStream fos = new FileOutputStream("newfile.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d1);

        //Dog d2 = new Dog();
        FileInputStream fis = new FileInputStream("newfile.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dog d2 = (Dog) ois.readObject();

        System.out.println(d2.i+" ...."+d2.j);
    }
}

