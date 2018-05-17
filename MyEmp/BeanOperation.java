package MyEmp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BeanOperation {
	private static Object value;

	private BeanOperation() {
	}

	public static void setBeanValue(Object actionObject, String msg) throws Exception {
		String[] result = msg.split("\\|");
		for (int i = 0; i < result.length; i++) {
			// 需要针对属性名称及内容做进一步拆分
			String[] temp = result[i].split(":");
			// 属性名称 "emp.ename"
			String attribute = temp[0];
			// 属性内容
			String value = temp[1];
			String[] fields = attribute.split("\\.");
			// 获取当前操作的简单Java类对象
			Object currentObject = getObject(actionObject, fields[0]);
			setObjectValue(currentObject, fields[1], temp[1]);
		}
	}

	public static String initCap(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * 负责调用XXXAction类中的getter方法取得简单Java类对象
	 * 
	 * @param obj
	 *            表示调用方法的所在类对象
	 * @param attribute
	 *            表示属性名称
	 * @return 调用对象结果
	 */
	public static Object getObject(Object obj, String attribute) throws Exception {
		String methodName = "get" + initCap(attribute);
		// 调用指定属性的Field对象，目的是取得对象类型，如果没有此属性意味着操作无法继续进行
		Field field = obj.getClass().getDeclaredField(attribute);
		if (field == null) {
			// 第二次尝试从父类中取得该属性
			field = obj.getClass().getField(attribute);
		}
		if (field == null) {
			// 两次都未取得指定属性的对象，表示该对象一定不存在
			return null;
		}
		Method method = obj.getClass().getMethod(methodName);
		return method.invoke(obj);
	}

	/**
	 * 根据指定的类对象设置指定类中的属性，调用setter方法 范例：测试类设计 3.2 多级VO设置实现
	 * 对3.1节的需求做一个更改，假设现在一个雇员(EMP)属于一个部门(dept)，一个部门属于一个公司。这种类似的关 系都可以通过字符串的配置来设置内容。
	 * 范例：建立Company类
	 * 
	 * @param obj
	 *            属性所在类的实例化对象
	 * @param attribute
	 *            属性名称
	 * @param value
	 *            属性内容
	 */
	public static void setObjectValue(Object obj, String attribute, String value) throws Exception {
		Field field = obj.getClass().getDeclaredField(attribute);
		// 判断属性是否存在
		if (field == null) {
			// 第二次尝试从父类中取得该属性
			field = obj.getClass().getField(attribute);
		}
		if (field == null) {
			// 两次都未取得指定属性的对象，表示该对象一定不存在
			return;
		}
		String methodName = "set" + initCap(attribute);
		Method setMethod = obj.getClass().getMethod(methodName, field.getType());
		setMethod.invoke(obj, value);
	}
}

// private static void setObjectValue(Object currentObject, String string,
// String string2) {
// // TODO Auto-generated method stub
//
// }
// public static Object getRealObject(Object object,String className)throws
// Exception{
//// Class<?> class1 = object.getClass();
// Field field = object.getClass().getDeclaredField(className);
// if (field == null) {
// field = object.getClass().getDeclaredField(className);
// if (field == null) {
// return null;
//
// }
//
// }
// Method method = object.getClass().getMethod(className);
//
// return method.invoke(object);
//
// }
//
// private static void setRealObject(Object object,String className) throws
// Exception{
//// Class<?> class1 = object.getClass();
// Field field = object.getClass().getDeclaredField(className);
// if(field == null) {
// field = object.getClass().getField(className);
// if(field == null) {
// return ;
// }
// String methodName = "set" + initCap(className) ;
// Method setMethod = object.getClass().getMethod(methodName,field.getType()) ;
// setMethod.invoke(object,value) ;
// }
//
//
//
//
