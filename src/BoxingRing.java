public class BoxingRing {
    Fighter ft1;
    Fighter ft2;
    int minWeight;
    int maxWeight;

    public BoxingRing(Fighter ft1, Fighter ft2, int minWeight, int maxWeight) {
        this.ft1 = ft1;
        this.ft2 = ft2;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }

    public void fight() {
        if (checkWeight()) {
            double randomNumber = Math.random();
            if (randomNumber < 0.5) {
                System.out.println("Dövüse " + ft1.name + " baslıyacak ");
            } else {
                System.out.println("Dövüse " + ft2.name + " baslıyacak ");
            }
            System.out.println("---------------------------------------------");
            while (ft1.health > 0 && ft2.health > 0) {
                System.out.println("-----------------------------NEW ROUND--------------------------");
                if (randomNumber < 0.5) {
                    this.ft2.health = ft1.hit(ft2);
                    System.out.println(ft2.health);
                    if (isWin()) {
                        break;
                    }
                    System.out.println("----------------------------------------");
                    this.ft1.health = ft2.hit(ft1);
                    System.out.println(ft1.health);
                    if (isWin()) {
                        break;
                    }
                    System.out.println("-------------------------------------------");
                } else {
                    this.ft1.health = ft2.hit(ft1);
                    System.out.println(ft1.health);
                    if (isWin()) {
                        break;
                    }
                    System.out.println("----------------------------------------");
                    this.ft2.health = ft1.hit(ft2);
                    System.out.println(ft2.health);
                    if (isWin()) {
                        break;
                    }
                    System.out.println("--------------------------------------------");
                }
                printScore();
            }
        } else {
            System.out.println("Sporcuların sikletleri uyuşmuyor.");
        }
    }

    public boolean checkWeight() {
        return (ft1.weight >= minWeight && ft1.weight <= maxWeight) && (ft2.weight >= minWeight && ft2.weight <= maxWeight);
    }

    public boolean isWin() {
        if (ft1.health == 0) {
            System.out.println("Maçı Kazanan : " + ft2.name);
            return true;
        } else if (ft2.health == 0) {
            System.out.println("Maçı Kazanan : " + ft1.name);
            return true;
        }

        return false;
    }

    public void printScore() {
        System.out.println("------------------");
        System.out.println(ft1.name + " Kalan Can \t:" + ft1.health);
        System.out.println(ft2.name + " Kalan Can \t:" + ft2.health);
    }
}

