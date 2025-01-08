package TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class SlideMovement {

    public void raiseSlides(double lt, double rt, HardwareMap hardwareMap){

        // Declare motor, make it run w/ encoder
        DcMotor rightSlide = hardwareMap.dcMotor.get("rightSlide");
        DcMotor leftSlide = hardwareMap.dcMotor.get("leftSlide");
        rightSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Servo intakeClaw = hardwareMap.servo.get("intakeClaw");
        Servo intakeClawSpinner = hardwareMap.servo.get("intakeClawSpinner");
        Servo intakeArmLeft = hardwareMap.servo.get("intakeArmLeft");
        Servo intakeArmRight = hardwareMap.servo.get("intakeArmRight");

        // Set ZeroPower to be brake to actively stop the slides
        rightSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Set initial power to zero
        rightSlide.setPower(0);
        leftSlide.setPower(0);

        // Actual controls now

        // If right trigger is pressed, raise the slide
        if (rt >=  0.4){
            rightSlide.setTargetPosition(2500);
            rightSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightSlide.setPower(0.5);
        }

        // If right button is pressed, lower the slide
        if (lt >= 0.4){
            leftSlide.setTargetPosition(-2500);
            leftSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftSlide.setPower(-0.5);
        }
    }
}
