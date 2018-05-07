package Abstruct;

/*
 * ģ�����ģʽ
 */
abstract class Action{  //��������һ��������Ϊ
	public static final int EAT = 1;
	public static final int SLEEP = 5;
	public static final int WORK = 10;
	public void command(int cmd) {
		switch(cmd) {
		case EAT:
			this.eat();
			break;
		case SLEEP:
			this.sleep();
			break;
		case WORK:
			this.work();
			break;
		case EAT + SLEEP + WORK:
			this.eat();
			this.sleep();
			this.work();
			break;
		}
	}

	public abstract void eat();
	public abstract void sleep();
	public abstract void work();
}

class Person extends Action{
	public void eat() {
		System.out.println("�˳Է���");
	}
	public void sleep() {
		System.out.println("��˯����");
	}
	public void work() {
		System.out.println("�˹���");
	}
}

class Pig extends Action{
	public void eat() {
		System.out.println("���ʳ");
	}
	public void sleep() {
		System.out.println("��˯����");
	}
	public void work() {
		
	}
}

class Robot extends Action{
	public void eat() {
		System.out.println("�����˳��");
	}
	public void sleep() {
	
	}
	public void work() {
		System.out.println("�����˹���");
	}
}

public class Testabstruct01 {
	public static void main(String[] args) {
		fun(new Person());
		fun(new Pig());
		fun(new Robot());
	}

	private static void fun(Action action) {
		// TODO Auto-generated method stub
		action.command(Action.EAT + Action.SLEEP +Action.WORK) ;
		
	}
}
