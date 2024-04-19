package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Stageclimb extends SubsystemBase {

    private DoubleSolenoid hook1;

public Stageclimb() {
    //Define solenoids here.
    hook1 = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM, Constants.hook1ForwardId, Constants.hook1ReverseId);
    addChild("Hook1", hook1);
    }
    
@Override
public void periodic() {
    // This method will be called once per scheduler run
}

@Override
public void simulationPeriodic() {
    // This method will be called once per scheduler run when in simulation
}

    public void raiseArms(){
        hook1.set(Value.kForward);
    }
    public void lowerArms(){
        hook1.set(Value.kReverse);
    }
    // Put methods for controlling this subsystem here. Call these from Commands.
}

