package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class teleTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Get code from other classes
        DriveTrain drivetrain = new DriveTrain();
        SlideMovement slideMovement = new SlideMovement();
        Intake intake = new Intake();

        // Declare our motors
        drivetrain.DT_init(hardwareMap); // Initializes the four driving motors
        slideMovement.Slide_init(hardwareMap); // Initializes the slide motors
        intake.Intake_init(hardwareMap); // Initializes the intake servo

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            // Declares variables for the gamepad

            // Drive Train Buttons
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double rx = gamepad1.right_stick_x;

            // Slide Buttons
            double rt = gamepad1.right_trigger;
            boolean rb = gamepad1.right_bumper;
            double lt = gamepad1.left_trigger;
            boolean lb = gamepad1.left_bumper;

            // Intake Buttons
            boolean a_button = gamepad1.a;
            boolean b_button = gamepad1.b;

            // Actual code that controls the robot

            // Moves the robot
            drivetrain.moveRobot(y, x, rx);

            // Moves the slides
            slideMovement.RaiseSlides(rb, rt);
            slideMovement.SpinSlides(lb, lt);

            // Moves the intake
            intake.GetSample(a_button);
            intake.ScoreSample(b_button);
        }
    }
}