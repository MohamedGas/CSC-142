public class Director{
private int x;
private Partner p;

public Director(){
x = 0;
p = new Partner( this );
}
public void addOne(){
x++;
}
public int getX(){
return x;
}
public void test(){
p.doSomething();
p.display();
this.display();
}
public void display(){
System.out.println("value of c is ");
System.out.println( p.getC() );
}
}