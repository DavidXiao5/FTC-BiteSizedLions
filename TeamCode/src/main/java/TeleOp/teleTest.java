package TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp
public class teleTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        // Init the other modules
        DriveTrain drivetrain = new DriveTrain();
        Intake intake = new Intake();
        SlideMovement slivemovement = new SlideMovement();

        // Wait for start
        waitForStart();

        if (isStopRequested()) return;

        DcMotor rightSlide = hardwareMap.dcMotor.get("rightSlide");
        DcMotor leftSlide = hardwareMap.dcMotor.get("leftSlide");
        rightSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        Servo outtakeClaw = hardwareMap.servo.get("outtakeClaw");
        Servo outtakeArm = hardwareMap.servo.get("outtakeArm");
        Servo intakeClaw = hardwareMap.servo.get("intakeClaw");
        Servo intakeClawSpinner = hardwareMap.servo.get("intakeClawSpinner");
        Servo intakeArmLeft = hardwareMap.servo.get("intakeArmLeft");
        Servo intakeArmRight = hardwareMap.servo.get("intakeArmRight");

        DcMotor teleSlide1 = hardwareMap.dcMotor.get("teleSlide1");
        DcMotor teleSlide2 = hardwareMap.dcMotor.get("teleSlide2");

        rightSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        // Actual OpMode
        while (opModeIsActive()) {
            // Declares variables for the gamepad

            // Drive Train Buttons
            if (gamepad1.left_bumper) {
                double y = -gamepad1.left_stick_y * .5;
                double x = gamepad1.left_stick_x * .55;
                double rx = gamepad1.right_stick_x * .5;
                drivetrain.moveRobot(y, x, rx, hardwareMap);
            }
            if (gamepad1.right_bumper) {
                double y = -gamepad1.left_stick_y * .25;
                double x = gamepad1.left_stick_x * .275;
                double rx = gamepad1.right_stick_x * .25;
                drivetrain.moveRobot(y, x, rx, hardwareMap);
            }
            else {
                double y = -gamepad1.left_stick_y;
                double x = gamepad1.left_stick_x * 1.1;
                double rx = gamepad1.right_stick_x;
                drivetrain.moveRobot(y, x, rx, hardwareMap);
            }


            if(gamepad2.left_bumper){
                if (rightSlide.getCurrentPosition() < 1300) {
                    rightSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rightSlide.setTargetPosition(1250);
                    rightSlide.setPower(0.7);
                    leftSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    leftSlide.setTargetPosition(-1250);
                    leftSlide.setPower(-0.7);
                }
            }

            if(gamepad2.right_bumper){
                if (rightSlide.getCurrentPosition() > 0) {
                    rightSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rightSlide.setTargetPosition(25);
                    rightSlide.setPower(-0.7);
                    leftSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    leftSlide.setTargetPosition(-25);
                    leftSlide.setPower(0.7);
                }
            }

            if (gamepad2.a){
                intakeClaw.setPosition(0.5);
            }
            if (gamepad2.b){
                intakeClaw.setPosition(0.1);
            }

            if (gamepad2.x){
                intakeArmLeft.setPosition(0);
                intakeArmRight.setPosition(0);
            }

            if (gamepad2.y){
                intakeArmLeft.setPosition(3);
                intakeArmRight.setPosition(-3);
            }

            if (gamepad2.left_trigger>=0.4){
                outtakeArm.setPosition(0.3);
            }
            if (gamepad2.right_trigger>=0.4){
                outtakeArm.setPosition(0);
            }
            if (gamepad2.left_stick_y>=0.4){
                teleSlide1.setPower(1);
                teleSlide2.setPower(1);
            }
            else if (gamepad2.left_stick_y<=-0.4){
                teleSlide1.setPower(-1);
                teleSlide2.setPower(-1);
            }
            else {
                teleSlide1.setPower(0);
                teleSlide2.setPower(0);
            }
            if (gamepad2.left_stick_button){
                outtakeClaw.setPosition(0.1);
            }
            else if (gamepad2.right_stick_button){
                outtakeClaw.setPosition(0.5);
            }
        }
    }
}