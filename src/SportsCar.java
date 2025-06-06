import mode.Aircon;
import mode.AutoDrive;
import mode.Music;

public class SportsCar extends Car implements Music, AutoDrive {

    public SportsCar() {
        super(250, 8, 30, 2); // 기본 속도 250km/h, 연비 8km/L, 연료탱크 30L, 좌석 2석
        this.name = "포르쉐 911";
    }

    @Override
    public void setMode(boolean isOn) {
        this.isModeOn = isOn;
        if (isOn) {
            this.velocity *= 1.2;
        } else {
            this.velocity = 250; // 기본 속도 복구
        }
    }

    @Override
    public String getModeMessageWhenModeOn(String carName, boolean isOn) {
        String msg = Music.super.getModeMessageWhenModeOn(carName, isOn)
                + "\n"
                + AutoDrive.super.getModeMessageWhenModeOn(carName, isOn);
        return msg;
    }

}
