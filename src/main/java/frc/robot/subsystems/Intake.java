package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

    private CANSparkMax intakeMotor;

public Intake() {
    //Define motors here.
    intakeMotor = new CANSparkMax(Constants.intakeMotorId, MotorType.kBrushed);
    intakeMotor.restoreFactoryDefaults();  
    intakeMotor.setInverted(false);
    intakeMotor.setIdleMode(IdleMode.kCoast);
    intakeMotor.burnFlash();

    intakeMotor.enableVoltageCompensation(10);
    }

@Override
public void periodic() {
    // This method will be called once per scheduler run
}
     
@Override
public void simulationPeriodic() {
    // This method will be called once per scheduler run when in simulation
}
    
    public void activateIntake(){
        intakeMotor.set(.95);
    }
    public void disableIntake(){
        intakeMotor.set(0);
    }
    public void reverseIntake(){
        intakeMotor.set(-1);
    }
    // Put methods for controlling this subsystem here. Call these from Commands.
}

