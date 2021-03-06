package BoneStructure;

import java.io.Serializable;

public class ThreeWayJoint extends Joint implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2075407121532789967L;
	Bone bone3;
	
	public ThreeWayJoint(Bone bone1, Bone bone2, Bone bone3) 
	{
		super(bone1, bone2);
		
		this.bone3 = bone3;
		
		bone2.setRot((float)Math.toDegrees((bone1.getRot() + constant *  Math.toRadians(60))));
		bone3.setRot((float)Math.toDegrees((bone1.getRot() - constant *  Math.toRadians(60))));
	}
	
	public void update()
	{
		super.update();
		
		bone3.setX((float) (x + bone3.getLength() / 2 * Math.cos(bone3.getRot())));
		bone3.setY((float) (y + constant * bone3.getLength() / 2 * Math.sin(bone3.getRot())));
	}
	
	public void rotBone3(float rot)
	{
		bone3.setRot(bone3.getDegRot() + rot);
	}
	
	public Bone getBone3()
	{
		return bone3;
	}
}
