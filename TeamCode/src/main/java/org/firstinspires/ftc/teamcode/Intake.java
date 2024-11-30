package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class Intake {
    public Servo intakeServo;

    HardwareMap hardwareMap;

    // Initializes all the motors needed for the intake
    public void Intake_init(HardwareMap hwMap){
        hardwareMap = hwMap;

        // Declare servo
        Servo intakeServo = hardwareMap.servo.get("intake");}

    // Makes gamepad be able to intake
    public void GetSample(boolean a_button){
        if (a_button){
            intakeServo.setPosition(1000);}}


    // Makes gamepad be able to outtake
    public void ScoreSample(boolean b_button){
        if (b_button){
            intakeServo.setPosition(-1000);}}}