package BoneStructure;

import java.io.Serializable;

import org.newdawn.slick.Graphics;

import Player.Player;

public class BoneStructure implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -785715115218883562L;
	Bone head;
	public Joint neck;
	
	Bone Neck;
	Bone Shoulder1;
	Bone Shoulder2;
	Bone USpine;
	Bone LSpine;
	public FourWayJoint torso;
	public ThreeWayJoint Pelvic;
	public Joint Spine;
	
	Bone UArm1;
	Bone LArm1;
	Bone Hand1;
	public Joint shoulder1;
	public Joint Elbow1;
	public Joint Wrist1;
	
	Bone UArm2;
	Bone LArm2;
	Bone Hand2;
	public Joint shoulder2;
	public Joint Elbow2;
	public Joint Wrist2;
	
	Bone ULeg1;
	Bone LLeg1;
	Bone Foot1;
	public Joint Knee1;
	public Joint Ankle1;
	
	Bone ULeg2;
	Bone LLeg2;
	Bone Foot2;
	public Joint Knee2;
	public Joint Ankle2;
	
	int tick;
	
	public BoneStructure(Player player, Float size)
	{
		head = new Bone(size * 9);
		head.setRot(90);
		head.setX(player.getX());
		head.setY(player.getY());
		
		Neck = new Bone(size * 4);
		
		neck = new Joint(head, Neck);

		Shoulder1 = new Bone(size * 9);
		Shoulder2 = new Bone(size * 9);
		LSpine = new Bone(size * 12);
		USpine = new Bone(size * 12);
		torso = new FourWayJoint(Neck, Shoulder1, Shoulder2, USpine);
		
		Spine = new Joint(USpine, LSpine);
		ULeg1 = new Bone(size * 17);
		ULeg2 = new Bone(size * 17);
		Pelvic = new ThreeWayJoint(LSpine, ULeg1, ULeg2);
		
		UArm1 = new Bone(size * 12);
		LArm1 = new Bone(size * 12);
		Hand1 = new Bone(size * 8);
		shoulder1 = new Joint(Shoulder1, UArm1);
		Elbow1 = new Joint(UArm1, LArm1);
		Wrist1 = new Joint(LArm1, Hand1);

		UArm2 = new Bone(size * 12);
		LArm2 = new Bone(size * 12);
		Hand2 = new Bone(size * 8);
		shoulder2 = new Joint(Shoulder2, UArm2);
		Elbow2 = new Joint(UArm2, LArm2);
		Wrist2 = new Joint(LArm2, Hand2);
		
		LLeg1 = new Bone(size * 15);
		Foot1 = new Bone(size * 4);
		Knee1 = new Joint(ULeg1, LLeg1);
		Ankle1 = new Joint(LLeg1, Foot1);
		
		LLeg2 = new Bone(size * 15);
		Foot2 = new Bone(size * 4);
		Knee2 = new Joint(ULeg2, LLeg2);
		Ankle2 = new Joint(LLeg2, Foot2);
		
		
		Pelvic.getBone2().setRot(-225);
		Pelvic.getBone3().setRot(45);
		
		Knee1.getBone2().setRot(90);
		Knee2.getBone2().setRot(90);
		
		Ankle1.getBone2().setRot(0);
		Ankle2.getBone2().setRot(0);
		
		tick = 10;
	}
	
	public void update()
	{
		
		neck.update();
		torso.update();
		Pelvic.update();
		Spine.update();
		
		shoulder1.update();
		Elbow1.update();
		Wrist1.update();
		
		shoulder2.update();
		Elbow2.update();
		Wrist2.update();
		
		Knee1.update();
		Ankle1.update();
		
		Knee2.update();
		Ankle2.update();
	}
	
	public void render(Graphics g)
	{
		head.render(g);
		neck.render(g);
		Neck.render(g);
		torso.render(g);
		Shoulder1.render(g);
		Shoulder2.render(g);
		USpine.render(g);
		LSpine.render(g);
		
		UArm1.render(g);
		LArm1.render(g);
		Hand1.render(g);
		
		UArm2.render(g);
		LArm2.render(g);
		Hand2.render(g);
		
		ULeg1.render(g);
		LLeg1.render(g);
		Foot1.render(g);
		
		ULeg2.render(g);
		LLeg2.render(g);
		Foot2.render(g);
		
		Pelvic.render(g);
		Spine.render(g);
		
		shoulder1.render(g);
		Elbow1.render(g);
		Wrist1.render(g);
		
		shoulder2.render(g);
		Elbow2.render(g);
		Wrist2.render(g);
		
		Knee1.render(g);
		Ankle1.render(g);
		
		Knee2.render(g);
		Ankle2.render(g);
	}
	
	public Joint getJoint(String name)
	{
		if(name.equals("Neck"))
		{
			return neck;
		}else if(name.equals("Torso"))
		{
			return torso;
		}else if(name.equals("Pelvic"))
		{
			return Pelvic;
		}else if(name.equals("Shoulder 1"))
		{
			return shoulder1;
		}else if(name.equals("Shoulder 2"))
		{
			return shoulder2;
		}else if(name.equals("Elbow 1"))
		{
			return Elbow1;
		}else if(name.equals("Elbow 2"))
		{
			return Elbow2;
		}else if(name.equals("Wrist 1"))
		{
			return Wrist1;
		}else if(name.equals("Wrist 2"))
		{
			return Wrist2;
		}else if(name.equals("Knee 1"))
		{
			return Knee1;
		}else if(name.equals("Knee 2"))
		{
			return Knee2;
		}else if(name.equals("Ankle 1"))
		{
			return Ankle1;
		}else if(name.equals("Ankle 2"))
		{
			return Ankle2;
		}else 
		{
			return null;
		}
	}
}
