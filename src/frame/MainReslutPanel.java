package frame;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import entities.Bus;
import entities.Employee;
import entities.Local;
import entities.LongDistance;
import entities.Manager;
import entities.Passenger;
import entities.Route;
import entities_2.Bike;

import listener.TableListener;

public class MainReslutPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4090036947302273308L;
	private static MainReslutPanel mainPanel;
	private DataTable table;
	private JScrollPane jscrolPane;
	private String dataType;

	public static MainReslutPanel instance() {
		if (mainPanel == null)
			mainPanel = new MainReslutPanel();
		return mainPanel;
	}

	public MainReslutPanel() {
		mainPanel = this;
		setOpaque(false);
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(0, 0, 5,5));
		table = new DataTable(null, null);
		jscrolPane = new JScrollPane();
		jscrolPane.setBorder(null);
		jscrolPane.setOpaque(false);
		jscrolPane.getViewport().setOpaque(false);
		add(jscrolPane);
	//	showCustomerData();
	}

	@Override
	public void paint(Graphics g) {
		ImageIcon icon = new ImageIcon(this.getClass().getResource(
				"/image/scrollpane.png"));
		Image img = icon.getImage();
		g.drawImage(img, jscrolPane.getX(), jscrolPane.getY(),
				jscrolPane.getWidth(), jscrolPane.getHeight(), this);
		super.paint(g);
	}

	public DataTable getTable() {
		return table;
	}

		public void showData(Object[][] data, Object[] head) {
		table.removeAll();
		table = new DataTable(data, head);
		jscrolPane.setViewportView(table);
	}

	//added by jkd,4st Jan in 2014
	public void showBusData() throws ClassNotFoundException, SQLException { 
		dataType = "BusData";
		Object[] head = { "����","���","��λ��","��·���"};
		Bus bus = new Bus();
		showData(bus.getAllBusData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showBicycleData() throws ClassNotFoundException, SQLException { 
		dataType = "BicycleData";
		Object[] head = { "ID","�Ƿ�ռ��","����","�����","����"};
		Bike bike = new Bike();
		showData(bike.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showRouteData() throws ClassNotFoundException, SQLException { 
		dataType = "RouteData";
		Object[] head = { "ID","ʼ��վ","�յ�վ","��վ��","����ʱ��"};
		Route route = new Route();
		showData(route.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showLocalData() throws ClassNotFoundException, SQLException { 
		dataType = "LocalData";
		Object[] head = { "ID","ʼ��վ","�յ�վ","��վ��","����ʱ��","·�̳���","��·���"};
		Local local = new Local();
		showData(local.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showLongDistanceData() throws ClassNotFoundException, SQLException { 
		dataType = "LongDistanceData";
		Object[] head = { "ID","ʼ��վ","�յ�վ","��վ��","����ʱ��","ʼ��ʱ��","ĩ��ʱ��"};
		LongDistance ld = new LongDistance();
		showData(ld.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showEmployeeData() throws ClassNotFoundException, SQLException { 
		dataType = "EmployeeData";
		Object[] head = { "ID","����","���֤��","����","нˮ","��������"};
		Employee ep = new Employee();
		showData(ep.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showPassengerData() throws ClassNotFoundException, SQLException { 
		dataType = "Passenger";
		Object[] head = { "ID","����","�Ա�","����","��ע"};
		Passenger pas = new Passenger();
		showData(pas.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showManagerData() throws ClassNotFoundException, SQLException { 
		dataType = "ManagerData";
		Object[] head = { "ID","����","���֤��","����","нˮ","��������","��������","���ܲ���","ְ��"};
		Manager manager = new Manager();
		showData(manager.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
}
