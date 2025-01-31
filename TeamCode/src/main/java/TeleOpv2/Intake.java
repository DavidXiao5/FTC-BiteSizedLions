//for motors the POWER ranges from a value from -1 to 1, this is continuous (although it can be set to a position like a servo)

//meanwhile servos can be powered by setting the position OR continuous

package TeleOpv2;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake{

    public void intake(HardwareMap hardwareMap, int pivotPos, int slidePos, double clawPos, double cpivotPos, double wristPos, double pivotPow, double slidePow) {
        // Call the motors/servos
        DcMotor pivot = hardwareMap.get(DcMotor.class, "pivot");
        DcMotor slides = hardwareMap.get(DcMotor.class, "slidesMotor");
        Servo cpivot = hardwareMap.get(Servo.class,"cpivot");
        Servo claw = hardwareMap.get(Servo.class, "claw");
        Servo wrist = hardwareMap.get(Servo.class, "wrist");

        // Set modes for motors
        pivot.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        pivot.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        pivot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        pivot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Do Stuff
        pivot.setTargetPosition(pivotPos);
        pivot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        pivot.setPower(pivotPow);

        slides.setTargetPosition(slidePos);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slides.setPower(slidePow);

        wrist.setPosition(wristPos);
        claw.setPosition(clawPos);
        cpivot.setPosition(cpivotPos);
    }
}
