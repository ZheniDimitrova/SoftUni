import implementations.ReversedList;



public class Main {
    public static void main(String[] args) {

        ReversedList<Integer> reversedList = new ReversedList<>();

        reversedList.add(10);
        reversedList.add(11);
        reversedList.add(12);
        reversedList.add(13);

        System.out.println(reversedList.removeAt(3));

        System.out.println();

    }
}
