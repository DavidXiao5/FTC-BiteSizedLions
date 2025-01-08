package TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class Intake {

    public void pickupPosition(HardwareMap hardwareMap){

        // Declare servo
        Servo intakeClaw = hardwareMap.servo.get("intakeClaw");
        Servo intakeClawSpinner = hardwareMap.servo.get("intakeClawSpinner");
        Servo intakeArmLeft = hardwareMap.servo.get("intakeArmLeft");
        Servo intakeArmRight = hardwareMap.servo.get("intakeArmRight");


        intakeClaw.setPosition(10);
        intakeClawSpinner.setPosition(0);
        intakeArmLeft.setPosition(0);
        intakeArmRight.setPosition(0);

    }

    public void sendPosition(HardwareMap hardwareMap){
        Servo intakeClaw = hardwareMap.servo.get("intakeClaw");
        Servo intakeClawSpinner = hardwareMap.servo.get("intakeClawSpinner");
        Servo intakeArmLeft = hardwareMap.servo.get("intakeArmLeft");
        Servo intakeArmRight = hardwareMap.servo.get("intakeArmRight");


        intakeClaw.setPosition(50);
        intakeClawSpinner.setPosition(500);
        intakeArmLeft.setPosition(50);
        intakeArmRight.setPosition(50);
    }

    public void transferPosition(HardwareMap hardwareMap){
        DcMotor teleSlide1 = hardwareMap.dcMotor.get("teleSlide1");
        DcMotor teleSlide2 = hardwareMap.dcMotor.get("teleSlide2");
        Servo outtakeClaw = hardwareMap.servo.get("outtakeClaw");
        Servo outtakeArm = hardwareMap.servo.get("outtakeArm");

        outtakeClaw.setPosition(0);
        outtakeArm.setPosition(0);

        teleSlide1.setTargetPosition(0);
        teleSlide1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        teleSlide1.setPower(0.5);

        teleSlide2.setTargetPosition(0);
        teleSlide2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        teleSlide2.setPower(-0.5);
    }

    public void scorePosition(HardwareMap hardwareMap){
        DcMotor teleSlide1 = hardwareMap.dcMotor.get("teleSlide1");
        DcMotor teleSlide2 = hardwareMap.dcMotor.get("teleSlide2");
        Servo outtakeClaw = hardwareMap.servo.get("outtakeClaw");
        Servo outtakeArm = hardwareMap.servo.get("outtakeArm");

        outtakeClaw.setPosition(100);
        outtakeArm.setPosition(100);

        teleSlide1.setTargetPosition(2500);
        teleSlide1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        teleSlide1.setPower(0.5);

        teleSlide2.setTargetPosition(2500);
        teleSlide2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        teleSlide2.setPower(0.5);
    }
}