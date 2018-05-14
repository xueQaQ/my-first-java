//package TestTry;
//
//interface Ifruit{
//	public void eat();
//}
//
//class Apple implements Ifruit{
//
//	@Override
//	public void eat() {
//		// TODO Auto-generated method stub
//		System.out.println("hahahahah");
//	}
//	
//}
//
//class Orange implements Ifruit{
//
//	@Override
//	public void eat() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}
//
//class FruitFactory{
//	private FruitFactory(){}
//	public static Ifruit getInstance(String className) {
//		Ifruit ifruit = null;
//		try {
//			ifruit = (Ifruit)Class.forName(className).newInstance();
//		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		return ifruit;
//		
//	}
//}
//
//public class Factory02 {
//	public static void main(String[] args) {
//		Ifruit ifruit = FruitFactory.getInstance("TestTry.Apple");
//		ifruit.eat();
//		
//	}
//}
