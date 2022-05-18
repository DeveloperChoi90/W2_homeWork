package vehicle;

public class Bus extends Vehicle implements Status{
    private static int busSerialNum = 1000; // 버스 고유번호
    public int maxPassenger, currentPassenger; // 최대 승객수, 현재 승객수
    public int fare = 2100;    // 버스 요금
    // Bus의 경우 super.status 변수의 [0] 값만 사용하요 운행 상태를 확인한다.

    public Bus(int maxPassenger, int currentPassenger, int oil, int currentSpeed) {
        super(oil, currentSpeed);
        busSerialNum++;
        this.maxPassenger = maxPassenger;
        this.currentPassenger = currentPassenger;
        this.supplyOil(oil);
        super.status[0] = true;
        this.isStatus();
    }


    @Override
    public void getCarNum() {
        System.out.println("현재 운행하는 버스의 번호는 " + busSerialNum + "입니다.");
    }

    @Override
    public void isStatus() {
        if (super.status[0]) System.out.println("운행");
        else {
            if(this.oil > 10) System.out.println("차고지행");
            else System.out.println("주유가 필요합니다.");
        }
    }

    @Override
    public void supplyOil(int oil) {
        if(super.oil > 10) {
            super.oil =  oil;
            System.out.println(oil + "만큼 주유하였습니다.");
        }else {
            super.oil = oil;
            System.out.println("주유가 부족합니다. 주유해주시길 바랍니다.");
            super.status[0] = false;
        }
    }

    @Override
    public void isOilStatus() {
        if(super.oil > 10) System.out.println("현재 기름의 양: " + super.oil);
        else System.out.println("주유량을 확인하세요. 주유하시길 바랍니다.");
    }

    public void boardingBus(int passenger) {
        isStatus();
        if(super.status[0]) {
           int remainingSeat = this.maxPassenger - this.currentPassenger;
           if(remainingSeat + passenger > maxPassenger) {
               System.out.println("자리가 부족하여 탑승하지 못한 인원 : " + (remainingSeat + passenger - maxPassenger));
               this.currentPassenger = this.maxPassenger;
           }else this.currentPassenger = remainingSeat + passenger;
        }
    }

    // 승객 내리는 method
    public void getOffVehicle(int passenger) {
        if(this.currentPassenger - passenger > 0) {
            System.out.println(passenger + " 승객이 하차합니다.");
            this.currentPassenger -= passenger;
        }else {
            System.out.println("현재의 탑승 승객수 보다 많이 입력하셨습니다.");
            System.out.println("현재의 탑승 승객수: " + this.currentPassenger);
        }
    }

    @Override
    public int convertSpeed(int convertSpeed) {
        this.isOilStatus();
        if(super.oil > 10){
            int deltaV = super.convertSpeed(convertSpeed);
            return deltaV;
        }
        return 0;
    }

    public void endBus(){
        super.status[0] = false;
        System.out.println("차고지행");
    }
}

