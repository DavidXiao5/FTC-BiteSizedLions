package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp
public class teleTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Declare our motors
        DcMotor slideSpinner = hardwareMap.dcMotor.get("slideSpinner");
        DcMotor slideRaiser = hardwareMap.dcMotor.get("slideRaiser");
        Servo intake = hardwareMap.servo.get("intake");

        // Get code from other classes
        DriveTrain drivetrain = new DriveTrain();

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            // Helps control the robot driving with gamepad
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double rx = gamepad1.right_stick_x;

            drivetrain.moveRobot(y, x, rx);
        }
    }
}