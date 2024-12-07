package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


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

        // Actual OpMode
        while (opModeIsActive()) {
            // Declares variables for the gamepad

            // Drive Train Buttons
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double rx = gamepad1.right_stick_x;

            // Slide Buttons
            double lt = gamepad1.left_trigger;
            boolean lb = gamepad1.left_bumper;
            double rt = gamepad1.right_trigger;
            boolean rb = gamepad1.right_bumper;

            // Intake Buttons
            boolean a = gamepad1.a;
            boolean b = gamepad1.b;

            // Actual code now

            // Moves the robot
            drivetrain.moveRobot(y, x, rx, hardwareMap);

            // Moves the slides
            slivemovement.raiseSlides(rb, rt, hardwareMap);
            slivemovement.spinSlides(lb, lt, hardwareMap);

            // Intake
            intake.runIntake(a, b, hardwareMap);
        }
    }
}