package MyEmp;



public class EmpAction {

	private Emp emp = new Emp();
	public void setValue(String value) throws Exception{
		BeanOperation.setBeanValue(this,value);   //this ��action��Ķ���
	}
	
	public Emp getEmp() {
		return emp;
	}
}
