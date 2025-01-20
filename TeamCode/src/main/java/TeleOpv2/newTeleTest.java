//for motors the POWER ranges from a value from -1 to 1, this is continuous (although it can be set to a position like a servo)

//meanwhile servos can be powered by setting the position OR continuous

package TeleOpv2;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class newTeleTest extends LinearOpMode {

    @Override //Overrides methods of the superclass

    public void runOpMode() {

        DriveTrainv2 drivetrain = new DriveTrainv2();

        // Setting up the motors
        DcMotor slides = hardwareMap.get(DcMotor.class, "slidesMotor");
        DcMotor pivot = hardwareMap.get(DcMotor.class, "pivot");

        Servo cpivot = hardwareMap.get(Servo.class,"cpivot");
        Servo claw = hardwareMap.get(Servo.class, "claw");

        cpivot.scaleRange(0, 0.25); //this will set the limit for how much the servo can rotate
        claw.scaleRange(0, 0.5); // make sure to change it later

        slides.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        pivot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        while (opModeIsActive()) {

            // Drive Train Buttons
            if (gamepad1.left_bumper) {
                double y = -gamepad1.left_stick_y * .5;
                double x = gamepad1.left_stick_x * .55;
                double rx = gamepad1.right_stick_x * .5;
                drivetrain.moveRobot(y, x, rx, hardwareMap);
            }

            else if (gamepad1.right_bumper) {
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


            // Pivot
            double rt = gamepad1.right_trigger;
            double lt = gamepad1.left_trigger;

            if (pivot.getCurrentPosition() < 1500 && pivot.getCurrentPosition() > 0) {
                if (rt - lt < 0.5 && rt - lt > -0.5) {
                    pivot.setPower(rt - lt); //this sets the power to be the difference of the right button (pivoting forward - range of 0 to 1) and the back button (pivoting back - range of 0 to 1)
                }
            }

            // Claw Pivot
            boolean a = gamepad1.a;
            boolean b = gamepad1.b;
            if (a) {
                cpivot.setPosition(1);
            } else if (b) {
                cpivot.setPosition(0);
            }

            // Claw
            boolean x_button = gamepad1.x;
            boolean y_button = gamepad1.y;
            if (x_button) {
                claw.setPosition(1);
            } else if (y_button) {
                claw.setPosition(0);
            }
        }
    }
}
