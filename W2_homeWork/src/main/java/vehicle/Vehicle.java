package vehicle;

interface Status{
    public void getCarNum();
    public void isStatus();
    public void supplyOil(int oil);
}

public abstract class Vehicle {
    public int oil = 0;
    public int currentSpeed = 0;
    public boolean[] status = {false, false}; // [0] : 운행가능여부 , [1] : 손님 탑승여부

    public Vehicle(int oil, int currentSpeed) {
        this.oil = oil;
        this.currentSpeed = currentSpeed;
    }

    abstract void isOilStatus();

//    abstract int convertSpeed(int convertSpeed);
    public int convertSpeed(int convertSpeed) {
        int deltaV = this.currentSpeed - convertSpeed;
        if (deltaV > 0) {
            System.out.println("현재 속도는 " + this.currentSpeed + "에서 " + convertSpeed + "로 감속되었습니다.");
        } else if(deltaV < 0){
            System.out.println("현재 속도는 " + this.currentSpeed + "에서 " + convertSpeed + "로 가속되었습니다.");
        }else System.out.println("속도의 변화가 없습니다.");
        this.currentSpeed -= deltaV; // delta 양수 : 감속, delta 음수 : 가속
        return (deltaV) * -1; // 리턴값은 음수 일때 감속, 양수일때 가속
    }
}
