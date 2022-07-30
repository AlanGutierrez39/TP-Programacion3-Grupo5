package vista;

import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JList;

public interface IVistaAgencia
{
	void setActionListener(ActionListener actionListener);
	public JList<String> getList1();
	//public JList getList2();
	//public JList getList3();
	public void setList1(JList<String> list1);
	//public void setList2(JList list2);
	//public void setList3(JList list3);
	public JLabel getLblNewLabel();
}
