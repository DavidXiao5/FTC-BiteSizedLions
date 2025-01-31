//for motors the POWER ranges from a value from -1 to 1, this is continuous (although it can be set to a position like a servo)

//meanwhile servos can be powered by setting the position OR continuous

package TeleOpv2;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class newTele extends LinearOpMode {

    @Override //Overrides methods of the superclass

    public void runOpMode() {

        DriveTrainv2 drivetrain = new DriveTrainv2();
        Intake intake = new Intake();

        waitForStart();
        while (opModeIsActive()) {

            // Drive Train Buttons
            if (gamepad1.left_bumper) {
                double y = -gamepad1.left_stick_y * .5;
                double x = -gamepad1.left_stick_x * .55;
                double rx = gamepad1.right_stick_x * .5;
                drivetrain.moveRobot(y, x, rx, hardwareMap);
            }

            else if (gamepad1.right_bumper) {
                double y = -gamepad1.left_stick_y * .25;
                double x = -gamepad1.left_stick_x * .275;
                double rx = gamepad1.right_stick_x * .25;
                drivetrain.moveRobot(y, x, rx, hardwareMap);
            }

            else {
                double y = gamepad1.left_stick_y;
                double x = -gamepad1.left_stick_x * 1.1;
                double rx = gamepad1.right_stick_x;
                drivetrain.moveRobot(y, x, rx, hardwareMap);
            }


            // Intake
            if (gamepad1.left_bumper){
                intake.intake(hardwareMap, -1023, 0, 0, 0, 0, 0, -0.2);
            }
        }
    }
}

