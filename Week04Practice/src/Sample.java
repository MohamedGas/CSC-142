public class Sample{
  private int alpha, beta;
  
  public Sample( ) {
    alpha = -1;
    beta = 3;
  } 
  public int scramble( int q ){ 
    return alpha + beta -  q ;
  }
  public void modify(){
    int temp = alpha;
    alpha = beta;
    beta = 2 * temp;
  }
  public void increase( int delta){
    alpha = alpha + delta;
    beta = beta + delta;
  } 
  public void display(){
    System.out.println( alpha );
    System.out.println( beta );
  }
}