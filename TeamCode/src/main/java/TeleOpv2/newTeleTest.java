package TeleOpv2;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp
public class newTeleTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        // Wait for start
        waitForStart();

        if (isStopRequested()) return;

        DcMotor pivot = hardwareMap.dcMotor.get("pivot");
        pivot.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        double position = pivot.getCurrentPosition();
        telemetry.update();

        // Actual OpMode
        while (opModeIsActive()) {
            if (gamepad1.a){
                pivot.setPower(0.1);
            }
            else if (gamepad1.b){
                pivot.setPower(-0.1);
            }
            else{
                pivot.setPower(0);
                System.out.println("e");
            }
        }
    }
}