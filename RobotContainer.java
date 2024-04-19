package frc.robot;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
    public static RobotContainer my_robotContainer = new RobotContainer();

  // Joysticks
    public static XboxController controller1 = new XboxController(Constants.DriverController);
    public static XboxController controller2 = new XboxController(Constants.OperatorController);
    
  // The robot's subsystems
    public final Stageclimb m_stageclimb = new Stageclimb();
    public final Shooter m_shooter = new Shooter();
    public final Intake m_intake = new Intake();
    public final Drivetrain m_drivetrain = new Drivetrain();

  // A chooser for autonomous commands
    SendableChooser<Command> m_chooser = new SendableChooser<>();

  //The container for the robot.  Contains subsystems, OI devices, and commands.
private RobotContainer() {
  //Activate controllers
    controller1 = new XboxController(Constants.DriverController);
    controller2 = new XboxController(Constants.OperatorController);
    
  // Smartdashboard Subsystems
    SmartDashboard.putData("Auto Drive", new AutoDriveForward( m_drivetrain ));
    SmartDashboard.putData("IntakeToggle", new IntakeOn( m_intake ));
    SmartDashboard.putData("ShootNote", new ShootNote( m_shooter ));
    SmartDashboard.putData("ClimbStage", new ClimbStage( m_stageclimb ));
    

  // Configure default commands
    m_stageclimb.setDefaultCommand(new ClimbStage( m_stageclimb ));
    
  // Configure the button bindings
    configureButtonBindings();

    // Configure autonomous sendable chooser
    final Command m_DriveForward = new AutoDriveForward( m_drivetrain );
    final Command m_ShootSpeaker = new AutoShootSpeaker();
    final Command m_ShootAmp = new AutoShootAmp();
    
    m_chooser.setDefaultOption("Drive", m_DriveForward);
    m_chooser.addOption("Shoot Speaker", m_ShootSpeaker);
    m_chooser.addOption("Shoot Amp", m_ShootAmp);
     SmartDashboard.putData("Auto Mode", m_chooser);
  }

public static RobotContainer getInstance() {
  return my_robotContainer;
  }

private void configureButtonBindings() {

  // Create buttons
  final JoystickButton buttonIntakeOn = new JoystickButton(controller2, XboxController.Button.kA.value);        
  buttonIntakeOn.onTrue(new IntakeOn(m_intake));

  final JoystickButton buttonIntakeOff = new JoystickButton(controller2, XboxController.Button.kB.value);        
  buttonIntakeOff.onTrue(new IntakeOff(m_intake));

  final JoystickButton buttonShootNote = new JoystickButton(controller2, XboxController.Button.kY.value);        
  buttonShootNote.whileTrue(new ShootNote(m_shooter));

  final JoystickButton buttonTopIntake = new JoystickButton(controller2, XboxController.Button.kRightStick.value);        
  buttonTopIntake.whileTrue(new TopIntake(m_shooter));

  final JoystickButton buttonClimbStage = new JoystickButton(controller2, XboxController.Button.kRightBumper.value);        
  buttonClimbStage.onTrue(new ClimbStage(m_stageclimb));

  final JoystickButton buttonDeployHook = new JoystickButton(controller2, XboxController.Button.kLeftBumper.value);        
  buttonDeployHook.onTrue(new DeployHook(m_stageclimb));
   
  final JoystickButton buttonPushNote = new JoystickButton(controller2, XboxController.Button.kLeftStick.value);        
  buttonPushNote.whileTrue(new PushNote(m_shooter));

  final JoystickButton buttonReverseIntake = new JoystickButton(controller1, XboxController.Button.kB.value);
  buttonReverseIntake.whileTrue(new ReverseIntake(m_intake));

  final JoystickButton buttonShootAmp = new JoystickButton(controller2, XboxController.Button.kX.value);        
  buttonShootAmp.whileTrue(new ShootAmp(m_shooter));
  
  final JoystickButton buttonClimbStage2 = new JoystickButton(controller1, XboxController.Button.kRightBumper.value);        
  buttonClimbStage2.onTrue(new ClimbStage(m_stageclimb));

  final JoystickButton buttonDeployHook2 = new JoystickButton(controller1, XboxController.Button.kLeftBumper.value);        
  buttonDeployHook2.onTrue(new DeployHook(m_stageclimb));
  }

public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
}

