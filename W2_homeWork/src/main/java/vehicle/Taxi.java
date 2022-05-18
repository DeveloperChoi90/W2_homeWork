package vehicle;

public class Taxi extends Vehicle implements Status {
    private static int taxiSerialNum = 100;   // 택시 고유번호, 객체가 생성될 때 +1 증가한다.
    public int passenger = 0;          // 택시에 탑승한 손님 수
    public String destination = "";         // 목적지
    public int baseDistance = 10;      // 기본거리 10 km
    public int targetDistance;         // 목적지까지 거리
    public int baseFare = 3800;        // 기본 요금
    public int additionalFare = 100;   // 추가 요금 : 이동 거리가 10 km 이상 시 1km당 100원
    // super.status[0] : 운행 가능여부, super.status[1] : 손님 탑승 여부

    // 생성자 초기화
    public Taxi(int oil, int currentSpeed) {
        super(oil, currentSpeed);
        taxiSerialNum++;
        this.supplyOil(oil);
        this.isStatus();
    }

    // 택시 고유번호 얻는 method
    @Override
    public void getCarNum() {
        System.out.println(taxiSerialNum);
    }

    // 택시의 현재 상태를 알 수 있는 method
    @Override
    public void isStatus() {
        if (super.status[0]) {
            if(super.status[1]) System.out.println("현재 " + this.passenger + "명을 태우고 운행중 입니다.");
            else System.out.println("일반 상태 : 손님을 찾고있습니다.");
        }else System.out.println("주유 상태가 10 이하, 운행 불가");
    }

    // 택시에 손님을 태우는 method
    public void pickupPassenger(int passengerNum, String destination, int targetDistance) {
        if (super.status[0]) { // status default : true
            if (passengerNum < 5) {
                System.out.println("상태 : 일반");
                System.out.println("손님" + passengerNum + "명을 태웠습니다.");
                this.passenger = passengerNum;
                this.destination = destination;
                this.targetDistance = targetDistance;
                super.status[1] = true;
                System.out.println("목적지 : " + destination);
                System.out.println("운행 중");
            } else {
                System.out.println("택시는 손님을 " + passengerNum + "명을 태울 수 없습니다.");
                super.status[1] = false;
            }
        } else {
            System.out.println("탑승 불가");
        }
    }

    // 택시에서 손님 내려는 method
    public void getOffVehicle() { // 중간에 경유하는 경우를 생각해야한다.
        super.status[1] = false;
        this.passenger = 0;
        this.targetDistance = 0;
        this.destination = "";

        System.out.println("손님이 내렸습니다.");
    }

    // 택시에 주유하는 method
    @Override
    public void supplyOil(int oil) {
        super.oil = oil;
        System.out.println(oil + "만큼 주유가 되었습니다.");
        super.status[0] = super.oil > 10;
    }

    // 현재 택시의 주유상태 확인 method
    @Override
    public void isOilStatus() {
        if (super.oil < 10) {
            System.out.println("현재 주유된 양은 " + this.oil + "만큼 주유되어 있습니다.");
            System.out.println("더 많이 기름을 넣어주세요.");
            super.status[0] = false;
        } else {
            System.out.println("현재 주유된 양은 " + this.oil + "만큼 주유되어 있습니다.");
            super.status[0] = true;
        }
    }

//    @Override
//    public int convertSpeed(int convertSpeed) {
//        int deltaV = super.currentSpeed - convertSpeed;
//        if (deltaV < 0) {
//            System.out.println("현재 속도는 " + super.currentSpeed + "에서 " + convertSpeed + "로 감속되었습니다.");
//        } else {
//            System.out.println("현재 속도는 " + super.currentSpeed + "에서 " + convertSpeed + "로 가속되었습니다.");
//        }
//        super.currentSpeed += (super.currentSpeed + deltaV < 0) ? 0 : deltaV;
//        return deltaV;
//    }

    // 목적지까지의 최종 요금 계산하는 method
    public int calTotalFare() {
        if (super.status[1]) {
            int totalFare = (this.targetDistance > this.baseDistance) ? (this.baseFare + (this.targetDistance - this.baseDistance) * this.additionalFare) : this.baseFare;
            System.out.println(destination + "까지 나온 요금은 " + totalFare + "원 입니다.");
            return totalFare;
        }
        System.out.println("손님이 탑승 중이 아닙니다.");
        return 0;
    }
}
