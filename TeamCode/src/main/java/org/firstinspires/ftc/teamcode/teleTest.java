package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp
public class teleTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Get code from other classes
        DriveTrain drivetrain = new DriveTrain();
        //SlideMovement slideMovement = new SlideMovement();
        //Intake intake = new Intake();

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            // Declares variables for the gamepad

            // Drive Train Buttons
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double rx = gamepad1.right_stick_x;

            // Moves the robot
            drivetrain.moveRobot(y, x, rx, hardwareMap);
        }
    }
}