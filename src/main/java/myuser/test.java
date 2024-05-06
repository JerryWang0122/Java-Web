package myuser;

public class test {
    public static void main(String[] args) {
        Integer u = Integer.valueOf(2);
        System.out.println("u == 2: " + (u == 2));
        System.out.println("u.equals(2): " + u.equals(2));
        System.out.println("u == '2': " + (u == '2'));
        System.out.println("u.equals('2'): " + u.equals('2'));
        System.out.println("u == \"2\": " /*+ (u == "2")*/);  // complie error
        System.out.println("u.equals(\"2\"): " + u.equals("2"));
    }
}
