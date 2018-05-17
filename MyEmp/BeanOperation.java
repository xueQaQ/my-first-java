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
			// ��Ҫ����������Ƽ���������һ�����
			String[] temp = result[i].split(":");
			// �������� "emp.ename"
			String attribute = temp[0];
			// ��������
			String value = temp[1];
			String[] fields = attribute.split("\\.");
			// ��ȡ��ǰ�����ļ�Java�����
			Object currentObject = getObject(actionObject, fields[0]);
			setObjectValue(currentObject, fields[1], temp[1]);
		}
	}

	public static String initCap(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * �������XXXAction���е�getter����ȡ�ü�Java�����
	 * 
	 * @param obj
	 *            ��ʾ���÷��������������
	 * @param attribute
	 *            ��ʾ��������
	 * @return ���ö�����
	 */
	public static Object getObject(Object obj, String attribute) throws Exception {
		String methodName = "get" + initCap(attribute);
		// ����ָ�����Ե�Field����Ŀ����ȡ�ö������ͣ����û�д�������ζ�Ų����޷���������
		Field field = obj.getClass().getDeclaredField(attribute);
		if (field == null) {
			// �ڶ��γ��ԴӸ�����ȡ�ø�����
			field = obj.getClass().getField(attribute);
		}
		if (field == null) {
			// ���ζ�δȡ��ָ�����ԵĶ��󣬱�ʾ�ö���һ��������
			return null;
		}
		Method method = obj.getClass().getMethod(methodName);
		return method.invoke(obj);
	}

	/**
	 * ����ָ�������������ָ�����е����ԣ�����setter���� ��������������� 3.2 �༶VO����ʵ��
	 * ��3.1�ڵ�������һ�����ģ���������һ����Ա(EMP)����һ������(dept)��һ����������һ����˾���������ƵĹ� ϵ������ͨ���ַ������������������ݡ�
	 * ����������Company��
	 * 
	 * @param obj
	 *            �����������ʵ��������
	 * @param attribute
	 *            ��������
	 * @param value
	 *            ��������
	 */
	public static void setObjectValue(Object obj, String attribute, String value) throws Exception {
		Field field = obj.getClass().getDeclaredField(attribute);
		// �ж������Ƿ����
		if (field == null) {
			// �ڶ��γ��ԴӸ�����ȡ�ø�����
			field = obj.getClass().getField(attribute);
		}
		if (field == null) {
			// ���ζ�δȡ��ָ�����ԵĶ��󣬱�ʾ�ö���һ��������
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
