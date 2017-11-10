package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//@Disabled
@TeleOp(name="TankDrive", group="Pushbot")
public class TankDrive extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareDRive robot           = new HardwareDRive();   // Use a Pushbot's hardware


    @Override
    public void runOpMode() {

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        float Forward=0;
        float Side=0;
        float Rt=1;
        float Lt=1;
        float Turn=0;
        float sp=0;

        robot.init(hardwareMap);

        robot.FLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.BLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.FRMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.BRMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        idle();

        robot.FLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.BLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.FRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.BRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();



        while (opModeIsActive()) {
            // Nico's tank drive code

            Forward = gamepad1.right_stick_y;
            Side = - gamepad1.left_stick_x;


            if (gamepad1.right_bumper){
                Rt=-1;
            }
            else{
                Rt=1;
            }

            if (gamepad1.left_bumper){
                Lt=-1;
            }
            else {
                Lt=1;
            }

            if (gamepad1.y){
                sp= (float) (sp+0.1);
                sleep(1000);
            }

            if (gamepad1.a){
                sp= (float) (sp-0.1);
                sleep(1000);
            }

            //robot.BLMotor.setPower(Forward*Lt);
            //robot.FLMotor.setPower(Forward*Lt);
            //robot.FRMotor.setPower(Forward*0.65*Rt);
            //robot.BRMotor.setPower(Forward*0.65*Rt);

            //robot.arm.setPower(gamepad2.right_stick_y*0.5);

            //robot.SideMotor.setPower(Side/2);

            telemetry.addData("Rt", Rt);
            telemetry.addData("Lt", Lt);
            telemetry.addData("Forward", Forward);
            telemetry.addData("hi",sp);

            
            if(gamepad1.x){
                //robot.armleft.setPosition(0);
            }
            if(gamepad1.y){
                //robot.armleft.setPosition(0.75);
            }

        }
    }
}
