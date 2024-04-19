package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Drivetrain extends SubsystemBase {
    
    private static CANSparkMax leftMotor1;
    private static CANSparkMax leftMotor2;
    private static CANSparkMax rightMotor1;
    private static CANSparkMax rightMotor2;
    public DifferentialDrive m_myRobot;
   
public Drivetrain() {
    //Define motors here.
    
    leftMotor1 = new CANSparkMax(Constants.leftMotor1Id, MotorType.kBrushed);
    leftMotor1.restoreFactoryDefaults();  
    leftMotor1.setInverted(false);
    leftMotor1.setIdleMode(IdleMode.kCoast);
    leftMotor1.burnFlash();
  
    leftMotor2 = new CANSparkMax(Constants.leftMotor2Id, MotorType.kBrushed);
    leftMotor2.restoreFactoryDefaults();  
    leftMotor2.setInverted(false);
    leftMotor2.setIdleMode(IdleMode.kCoast);
    leftMotor2.burnFlash();
    
    rightMotor1 = new CANSparkMax(Constants.rightMotor1Id, MotorType.kBrushed);
    rightMotor1.restoreFactoryDefaults();  
    rightMotor1.setInverted(true);
    rightMotor1.setIdleMode(IdleMode.kCoast);
    rightMotor1.burnFlash();
  
    rightMotor2 = new CANSparkMax(Constants.rightMotor2Id, MotorType.kBrushed);
    rightMotor2.restoreFactoryDefaults();  
    rightMotor2.setInverted(true);
    rightMotor2.setIdleMode(IdleMode.kCoast);
    rightMotor2.burnFlash();

    leftMotor1.enableVoltageCompensation(10);
    leftMotor2.enableVoltageCompensation(10);
    rightMotor1.enableVoltageCompensation(10);
    rightMotor2.enableVoltageCompensation(10);

    m_myRobot = new DifferentialDrive(Drivetrain.leftMotor1,Drivetrain.rightMotor2);
    m_myRobot.setSafetyEnabled(false);  
  
    ///Create motor control groups
    leftMotor2.follow(leftMotor1);
    rightMotor1.follow(rightMotor2);
}

@Override
public void periodic() {
     m_myRobot.tankDrive(RobotContainer.controller1.getLeftY(), RobotContainer.controller1.getRightY());
    // This method will be called once per scheduler run
}
   
    
@Override
public void simulationPeriodic() {
    // This method will be called once per scheduler run when in simulation
    }

public static void driveForward(double leftspeed, double rightspeed){
    leftMotor1.set(leftspeed);
    rightMotor2.set(rightspeed);
}

// Put methods for controlling this subsystem here. Call these from Commands.
}

