package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SlideMovement {

    public void raiseSlides(boolean rb, double rt, HardwareMap hardwareMap){

        // Declare motor, make it run w/ encoder
        DcMotor sr = hardwareMap.dcMotor.get("slideRaiser");
        sr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Make the motors orientation right
        sr.setDirection(DcMotorSimple.Direction.FORWARD);

        // Set ZeroPower to be brake to actively stop the slides
        sr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Set initial power to zero
        sr.setPower(0);

        // Actual controls now

        // If right trigger is pressed, raise the slide
        if (rt >=  0.4){
            sr.setTargetPosition(2500);
            sr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            sr.setPower(0.5);}

        // If right button is pressed, lower the slide
        else if (rb){
            sr.setTargetPosition(-2500);
            sr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            sr.setPower(-0.5);}}

    // Makes gamepad be able to spin the slides
    public void spinSlides(boolean lb, double lt, HardwareMap hardwareMap){

        // Declare motor, make it run w/ encoder
        DcMotor ss = hardwareMap.dcMotor.get("slideSpinner");
        ss.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Make the motors orientation right
        ss.setDirection(DcMotorSimple.Direction.FORWARD);

        // Set ZeroPower to be brake to actively stop the robot
        ss.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Set initial power to zero
        ss.setPower(0);

        // Actual controls now

        // If left trigger is pressed, spin the slide to scoring position
        if (lt >= 0.4) {
            ss.setTargetPosition(1000);
            ss.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            ss.setPower(0.5);}

        // If left button is pressed, spin the slide to resting position
        else if (lb) {
            ss.setTargetPosition(-1000);
            ss.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            ss.setPower(-0.5);}}}
