//for motors the POWER ranges from a value from -1 to 1, this is continuous (although it can be set to a position like a servo)

//meanwhile servos can be powered by setting the position OR continuous

package TeleOpv2;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class backupTele extends LinearOpMode {

    @Override //Overrides methods of the superclass

    public void runOpMode() {

        DriveTrainv2 drivetrain = new DriveTrainv2();
        DcMotor pivot = hardwareMap.get(DcMotor.class, "pivot");
        DcMotor slides = hardwareMap.get(DcMotor.class, "slidesMotor");
        Servo cpivot = hardwareMap.get(Servo.class,"cpivot");
        Servo claw = hardwareMap.get(Servo.class, "claw");
        Servo wrist = hardwareMap.get(Servo.class, "wrist");

        // Set modes for motors
        pivot.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        slides.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        pivot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slides.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Positions
        double cpivotpos = 0;
        double clawpos = 0;
        double wristpos = 0;

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
                double y = -gamepad1.left_stick_y;
                double x = -gamepad1.left_stick_x * 1.1;
                double rx = gamepad1.right_stick_x;
                drivetrain.moveRobot(y, x, rx, hardwareMap);
            }

            // Slides
            if (gamepad2.left_bumper){
                slides.setPower(0.5);
            }
            else if (gamepad2.right_bumper){
                slides.setPower(-0.5);
            }
            else {
                slides.setPower(0);
            }

            // Pivot
            if (gamepad2.left_trigger>=0.4){
                pivot.setPower(0.5);
            }
            else if (gamepad2.right_trigger>=0.4){
                pivot.setPower(-0.5);
            }
            else {
                pivot.setPower(0);
            }

            // Cpivot
            if (gamepad2.a){
                cpivot.setPosition(0.2);
            }
            else if (gamepad2.b){
                cpivot.setPosition(-0.23);
            }

            // Wrist
            if (gamepad2.x){
                wrist.setPosition(wristpos);
                wristpos+=0.001;
            }
            else if (gamepad2.y){
                wrist.setPosition(wristpos);
                wristpos-=0.001;
            }

            // Claw
            if (gamepad2.left_stick_button){
                claw.setPosition(clawpos);
                clawpos+=0.001;
            }
            else if (gamepad2.right_stick_button){
                claw.setPosition(clawpos);
                clawpos-=0.001;
            }
        }
    }
}

