package sample;

import java.rmi.Remote;

public class ProxyApp implements Remote{
    public static void main(String[] args) {
        Image image = new RealImage("d:/sample.jpg");
        image.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image {
    String file;

    public RealImage(String file) {
        this.file = file;
        load();
    }

    void load() {
        System.out.println("load: " + file);
    }


    public void display() {
        System.out.println("View: " + file);
    }
}
class ProxyImage implements Image{
    String file;
    RealImage image;
    public ProxyImage(String file) {
        this.file = file;
    }

    public void display() {
        if(image==null){
            image = new RealImage(file);
        }
        image.display();
    }
}