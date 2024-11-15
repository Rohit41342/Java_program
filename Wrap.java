public class Wrap {

    public static void main(String[] args) {

        // Parsing a String to an integer
        int z = Integer.parseInt("234");
        System.out.println(z); 

        // Parsing a binary String to an Integer object with base 2
        Integer z1 = Integer.valueOf("11010101", 2);
        // Converting Integer object to primitive int
        int y = z1.intValue();
        System.out.println(y);  

        // Parsing a String to a Double object
        Double a1 = Double.valueOf("234");
        // Converting Double object to primitive double
        double b = a1.doubleValue();
        System.out.println(b);  

    }
    
}
