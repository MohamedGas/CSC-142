public class Partner{
private Director dir;
private int c;

public Partner( Director d ){
dir = d;
c = 2;
dir.addOne();
}
public void doSomething(){
c += dir.getX();
}
public int getC(){
return c;
}
public void display(){
System.out.println( "Value of x is: " + dir.getX() );
}
public static void main(String[] args) {
	Director d = new Director();
	d.addOne();
	d.addOne();
	d.test();
}
}
