import vehicle.*;


interface Flyable{
    void fly(int x, int y, int z);
    boolean flyable(int z);
}

abstract class Bird {
    private int x, y, z;

    void fly(int x, int y, int z) {
        printLocation();
        System.out.println("이동합니다.");
        this.x = x;
        this.y = y;
        if(flyable(z)){
            this.z = z;
        }else {
            System.out.println("그 높이로는 날 수 없습니다.");
        }
        printLocation();
    }

    abstract boolean flyable(int z);

    public void printLocation(){
        System.out.println("현재위치 {" + x + "," + y + ","+ z + "}");
    }
}

class Pigeon extends Bird {

    @Override
    boolean flyable(int z) {
        return z < 10000;
    }
}

class Peacock extends Bird {

    @Override
    boolean flyable(int z) {
        return false;
    }
}

class Penguin implements Flyable{
    private int x,y,z;

    @Override
    public void fly(int x, int y, int z) {
        printLocation();
        System.out.println("이동합니다.");
        this.x = x;
        this.y = y;
        if (flyable(z)) this.z = z;
        else {
            System.out.println("펭귄은 날지 못하고 수영을 할 줄 압니다.");
        }
        printLocation();
    }

    @Override
    public boolean flyable(int z) {
        return false;
    }

    public void printLocation(){
        System.out.println("현재위치 {" + x + "," + y + ","+ z + "}");
    }
}

public class Main {
    public static void main(String[] args) {
/*        Bird pigeon = new Pigeon();
        Bird peacock = new Peacock();
        Flyable penguin = new Penguin();

        System.out.println("--- 비둘기 ---");
        pigeon.fly(1, 1, 3);
        System.out.println("--- 공작새 ---");
        peacock.fly(1,1, 3);
        System.out.println("--- 비둘기 ---");
        pigeon.fly(3, 3, 30000);
        System.out.println("--- 펭귄 ---");
        penguin.fly(1,2, 3);*/

//        Taxi taxi = new Taxi(20, 80);
//        taxi.pickupPassenger(3, "서울 마포구", 30);
//        taxi.isStatus();
//        taxi.isOilStatus();
//        taxi.getCarNum();

//        Taxi taxi2 = new Taxi(40, 100);
//        taxi2.pickupPassenger(3, "서울 마포구", 30);
//        taxi2.isStatus();
//        taxi2.isOilStatus();
//        taxi2.getCarNum();
//        taxi2.calTotalFare();

        Bus bus1 = new Bus(50, 24, 10, 60);
        bus1.supplyOil(40);
        bus1.boardingBus(30);
        bus1.endBus();
    }
}