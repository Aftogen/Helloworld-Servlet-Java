package sample;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlType(name = "cat")
@XmlRootElement
public class Cat {
    public Cat(){ }


    public String name;
    public int age;
    public int weight;

}