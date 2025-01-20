//for motors the POWER ranges from a value from -1 to 1, this is continuous (although it can be set to a position like a servo)

//meanwhile servos can be powered by setting the position OR continuous

package TeleOpv2;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp()
public class servo extends LinearOpMode {

    @Override

    public void runOpMode() {

        Servo servo = hardwareMap.get(Servo.class,"servo");

        waitForStart();
        while (opModeIsActive()) {

            servo.setPosition(0);
        }
    }
}
