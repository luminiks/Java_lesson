package Animals;

import java.util.Scanner;

/**
 * Created by Luminiksik on 07.05.2016.
 */
public abstract class Animals {
    protected String color;
    protected String name;
    protected  int age;
    protected static Scanner sc = new Scanner(System.in);

    public abstract void voice();{

    }
    abstract public void run(float m);{

    }
    abstract public void swim(float m);{

    }
    abstract public void jump(float m);{

    }
}
