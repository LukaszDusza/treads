package TreadsApp;


public class Main {

     public static void main(String[] args) {

          Bucket bucket = new Bucket();
          
          Consument consument = new Consument("Konsument", bucket);
          Producer producer = new Producer("Producent", bucket);
          
          consument.start();
          producer.start();
          
          
     }

}
