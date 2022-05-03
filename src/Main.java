public class Main {
    public static void main(String[] args) {
        Fighter ft1 = new Fighter("BATUHAN", 10, 200, 80, 8.0);
        Fighter ft2 = new Fighter("EMİRHAN", 8, 210, 70, 5.0);

        BoxingRing box = new BoxingRing(ft1, ft2, 60, 100);

        box.fight();


    }
}