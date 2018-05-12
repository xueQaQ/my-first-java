//package TestTry;
//
//interface Ifruit{
//	public void eat();
//}
//
//class Apple implements Ifruit {
//
//	@Override
//	public void eat() {
//		// TODO Auto-generated method stub
//		System.out.println("³ÔÆ»¹ûÒªÏ´");
//		
//	}
//	
//}
//
//class Banana implements Ifruit{
//
//	@Override
//	public void eat() {
//		// TODO Auto-generated method stub
//		System.out.println("³Ô");
//	}
//	
//}
//
//class FruitFactory{
////	private FruitFactory () {}
//	public static Ifruit getInstance(String className) {
//		if("apple".equals(className)) {
//			return new Apple();
//		}else if("banana".equals(className)){
//			return new Banana();
//		}
//		return null;
//	}	
//}
//
//public class Factory01 {
//public static void main(String[] args) {
//	Ifruit ifruit = FruitFactory.getInstance("banana");
//	ifruit.eat();
//}
//}
