package org.usfirst.frc.team2342.robot;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SampleRobot;

public class Robot extends SampleRobot {

	WPI_TalonSRX m_leftTalon1;
	WPI_TalonSRX m_rightTalon1;
	WPI_TalonSRX m_leftTalon2;
	WPI_TalonSRX m_rightTalon2;
	
	WPI_TalonSRX m_flyWheelL;
	WPI_TalonSRX m_flyWheelR;
	
	WPI_TalonSRX m_rollers;
	
	Joystick m_stick = new Joystick(0);
	
	public void robotInit()
	{
		m_leftTalon1 = new WPI_TalonSRX(2);
		m_leftTalon2 = new WPI_TalonSRX(4);
		m_rightTalon1 = new WPI_TalonSRX(1);
		m_rightTalon2 = new WPI_TalonSRX(3);
		
		m_flyWheelL = new WPI_TalonSRX(5);
		m_flyWheelR = new WPI_TalonSRX(6);
		
		m_rollers = new WPI_TalonSRX(8);
	}
	
	public void operatorControl()
	{
		while(isEnabled()) {
			m_leftTalon1.set(ControlMode.PercentOutput, -m_stick.getY());
			m_leftTalon2.set(ControlMode.PercentOutput, -m_stick.getY());
			
			m_rightTalon1.set(ControlMode.PercentOutput, m_stick.getZ());
			m_rightTalon2.set(ControlMode.PercentOutput, m_stick.getZ());
			
			if(m_stick.getRawButton(1)) {
				m_flyWheelL.set(ControlMode.PercentOutput, (m_stick.getRawAxis(4) + 1) / 2.0);
				m_flyWheelR.set(ControlMode.PercentOutput, (m_stick.getRawAxis(4) + 1) / 2.0);
			} else {
				m_flyWheelL.set(ControlMode.PercentOutput, 0);
				m_flyWheelR.set(ControlMode.PercentOutput, 0);
			}
			
			if(m_stick.getRawButton(2)) 
				m_rollers.set(ControlMode.PercentOutput, 0.5);
			else if(m_stick.getRawButton(7))
				m_rollers.set(ControlMode.PercentOutput, -0.5);
			else
				m_rollers.set(ControlMode.PercentOutput, 0);
		}
	}
	
}
