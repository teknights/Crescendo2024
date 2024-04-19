package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Shooter extends SubsystemBase {

    private static CANSparkMax shootMotor1;
    private static CANSparkMax shootMotor2;
    private static DoubleSolenoid pusher;

public Shooter() {
    //Define motors here.
    shootMotor1 = new CANSparkMax(Constants.shooterMotor1Id, MotorType.kBrushed);
    shootMotor1.restoreFactoryDefaults();  
    shootMotor1.setInverted(true);
    shootMotor1.setIdleMode(IdleMode.kCoast);
    shootMotor1.burnFlash();
  
    shootMotor2 = new CANSparkMax(Constants.shooterMotor2Id, MotorType.kBrushed);
    shootMotor2.restoreFactoryDefaults();  
    shootMotor2.setInverted(true);
    shootMotor2.setIdleMode(IdleMode.kCoast);
    shootMotor2.burnFlash();
   
    pusher = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM, Constants.pusherForwardId, Constants.pusherReverseId);
    addChild("Pusher", pusher);

    shootMotor1.enableVoltageCompensation(10);
    shootMotor2.enableVoltageCompensation(10);
    }

@Override
public void periodic() {
    // This method will be called once per scheduler run
}
   
@Override
public void simulationPeriodic() {
    // This method will be called once per scheduler run when in simulation
}

    public static void shootNote(){
        shootMotor1.set(0.88);
        shootMotor2.set(-0.88);
    }
    public static void stopMotor(){
        shootMotor1.set(0);
        shootMotor2.set(0);
    }
    public void topIntake(){
        shootMotor1.set(-.3);
        shootMotor2.set(.3);
    }
    public static void pushNote(){
        pusher.set(Value.kForward);
    }
    public static void releasePusher(){
        pusher.set(Value.kReverse);
    }
    public static void shootAmp(){
        shootMotor1.set(.55);
        shootMotor2.set(-.55);
    }
   // Put methods for controlling this subsystem here. Call these from Commands.
}

