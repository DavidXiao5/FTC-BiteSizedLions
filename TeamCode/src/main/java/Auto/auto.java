package Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; // these are imported class (happens automatically with press of a button)
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous //this tells the control that it's teleop
public class auto extends LinearOpMode { //runs code in one method contrasted with regular opmode

    static final double HD_COUNTS_PER_REV = 28;
    static final double DRIVE_GEAR_REDUCTION = 20.15293;
    static final double WHEEL_CIRCUMFERENCE_MM = 90 * Math.PI;
    static final double DRIVE_COUNTS_PER_MM = (HD_COUNTS_PER_REV * DRIVE_GEAR_REDUCTION) / WHEEL_CIRCUMFERENCE_MM;
    static final double DRIVE_COUNTS_PER_IN = DRIVE_COUNTS_PER_MM * 25.4;

    //initializing the drivtrain motors
    DcMotor backLeft = hardwareMap.get(DcMotor.class, "backLeftMotor"); //this defines the motor: left side declares the motor, while right side gets the class of the motor from the superclass (the device name has to be found from the control hub)
    DcMotor frontLeft = hardwareMap.get(DcMotor.class, "frontLeftMotor"); //same thing as above for left forward motor
    DcMotor backRight = hardwareMap.get(DcMotor.class, "backRightMotor");
    DcMotor frontRight = hardwareMap.get(DcMotor.class, "frontRightMotor");
    DcMotor slides = hardwareMap.get(DcMotor.class, "slidesMotor");//while the top 4 were for the drivetrain, this is for the slides
    DcMotor pivot = hardwareMap.get(DcMotor.class, "pivot"); //this is for pivoting the slides

    Servo cpivot = hardwareMap.get(Servo.class, "cpivot"); //this is declaring the servo for the claw pivot
    Servo claw = hardwareMap.get(Servo.class, "claw"); //declaring the servo for the claw
    Servo wrist = hardwareMap.get(Servo.class, "wrist");

    public void auto_drive(double power, double leftInches, double rightInches){
        int rfTarget = frontRight.getCurrentPosition() + (int)(rightInches * DRIVE_COUNTS_PER_IN);
        int lfTarget = frontLeft.getCurrentPosition() + (int)(leftInches * DRIVE_COUNTS_PER_IN);
        int rbTarget = backRight.getCurrentPosition() + (int)(rightInches * DRIVE_COUNTS_PER_IN);
        int lbTarget = backLeft.getCurrentPosition() + (int)(leftInches * DRIVE_COUNTS_PER_IN);
        if (opModeIsActive()) {

            backLeft.setTargetPosition(lbTarget);
            frontLeft.setTargetPosition(lfTarget);
            backRight.setTargetPosition(rbTarget);
            frontRight.setTargetPosition(rfTarget);

            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            backLeft.setPower(power);
            frontLeft.setPower(power);
            backRight.setPower(power);
            frontRight.setPower(power);

            while (opModeIsActive() && (backLeft.isBusy() || backRight.isBusy() || frontLeft.isBusy() || frontRight.isBusy())){
                continue;
            }

            backLeft.setPower(0);
            frontLeft.setPower(0);
            backRight.setPower(0);
            frontRight.setPower(0);
        }
    }

    @Override
    public void runOpMode() {

    }
}