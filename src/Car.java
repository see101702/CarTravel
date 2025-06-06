/*
- 공통 필드:
  - 속도 (int) velocity
  - 연비 (int) fuelEfficiency
  - 연료탱크 크기 (int) fuelCapacity
  - 좌석 수 (int) seatsNumber
  - 차량 이름 (String) name
- 공통 기능:
  - 총 이동 횟수 계산 totalMovement
  - 주유 횟수 계산 totaRefuel
  - 총 비용 계산 totalCost
  - 총 이동 시간 계산 totalTravelTime
- 추상 메서드:
  - setMode(boolean isOn) → 차량별 부과 기능 on/off
*/
public abstract class Car {
    protected int velocity; // 속도
    protected int fuelEfficiency; // 연비
    protected int fuelCapacity; // 연료탱크 크기
    protected int seatsNumber; // 좌석 수
    protected boolean isModeOn; // 모드 상태 (on/off)
    protected String name; // 차량 이름
    final protected int FUEL_PRICE = 2000; // 연료 가격 (단위: 원)

    public Car(int velocity, int fuelEfficiency, int fuelCapacity, int seatsNumber) {
        this.velocity = velocity;
        this.fuelEfficiency = fuelEfficiency;
        this.fuelCapacity = fuelCapacity;
        this.seatsNumber = seatsNumber;
    }


    // ceil(승객 수 / 좌석 수)
    public int totalMovement(int passengers) {
        return (int) Math.ceil((double) passengers / this.seatsNumber);
    }

    //거리 × 횟수
    public int totalDistance(int distance, int totalMovement) {
        return distance * totalMovement;
    }

    public double totalFuel(int totalDistance) {
        return  (double) totalDistance / this.fuelEfficiency;
    }

    public int countRefuel(double totalFuel) {
        return (int) Math.ceil( totalFuel / this.fuelCapacity);
    }
    public double totalCost(double totalFuel) {
        return  totalFuel * FUEL_PRICE;
    }

    public int totalTravelTime(int distance, int totalMovement, int weatherCondition) {
        return (int) Math.ceil((distance / velocity) * totalMovement * selectWeatherCondition(weatherCondition))*60;
    }

    private double selectWeatherCondition(int weatherCondition) {
        switch (weatherCondition) {
            case 1: // 맑음
                return 1.0;
            case 2: // 비
                return 1.2;
            case 3: // 눈
                return 1.4;
            default: // 예외
                return -1.0;
        }
    }

    public abstract void setMode(boolean isOn); // 차량별 부과 기능 on/off
}
