package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class Intake {

    public void runIntake(boolean a_button, boolean b_button, HardwareMap hardwareMap){

        // Declare servo
        Servo intakeServo = hardwareMap.servo.get("intake");

        if (a_button){
            intakeServo.setPosition(1000);}

        if (b_button){
            intakeServo.setPosition(-1000);}}}