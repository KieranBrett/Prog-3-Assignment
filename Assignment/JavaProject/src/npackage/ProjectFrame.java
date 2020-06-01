package npackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;


public class ProjectFrame extends JFrame{

	private eOrder sortState;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel searchPanel;
	private JTextField textField;
	private ArrayList<Stat> statistics;
	private JTable table;
	private DefaultTableModel tm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Country", "Total Cases", "New Cases", "Total Deaths", "New Deaths", "Total Recovered", "Active", "Critical", "Total Cases/1m", "Deaths/1m", "Total Tests", "Tests/1m", "Population"
				}
		);
	
	private DefaultTableModel tm2 = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Country", "Total Cases", "New Cases", "Total Deaths", "New Deaths", "Total Recovered", "Active", "Critical", "Total Cases/1m", "Deaths/1m", "Total Tests", "Tests/1m", "Population"
				}
		);
	
	private DefaultTableModel pg = new DefaultTableModel(
			new Object[][] {
			},
			new String[]
					{
							"Total"
					});
	private JTable table_1;
	private JTextField averageField;
			

	/**
	 * Create the frame.
	 */
	public ProjectFrame(ArrayList<Stat> stats) {
		// Setting the default sort state
		sortState = eOrder.TOTAL_CASES;
		this.statistics = stats;
		
		// Generated code for buttons and panels etc
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 777);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1164, 720);
		contentPane.add(tabbedPane);
		
		JPanel homePanel = new JPanel();
		tabbedPane.addTab("Home", null, homePanel, null);
		homePanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1139, 617);
		homePanel.add(scrollPane);
				
		searchPanel = new JPanel();
		tabbedPane.addTab("Search", null, searchPanel, null);
		searchPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 289, 31);
		searchPanel.add(textField);
		textField.setColumns(10);
		
		/////////////////////////////////////////////////////////// Search Button Method
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonSearchEvent();
			}
		});
		//////////////////////////////////////////////////////////
		
		btnNewButton.setBounds(309, 11, 104, 31);
		searchPanel.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 53, 1139, 39);
		searchPanel.add(scrollPane_1);
		
		//seach table
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(tm2);
		
		//Home tabel
		table = new JTable();
		table.setModel(tm);
		scrollPane.setViewportView(table);
		
		// Alphabet Sort Button
		JButton btnSortAlphabet = new JButton("Alphabetical");
		btnSortAlphabet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortData("alphabetical");
			}
		});
		btnSortAlphabet.setBounds(10, 639, 107, 42);
		homePanel.add(btnSortAlphabet);
		
		JButton btnSortCases = new JButton("Cases");
		btnSortCases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortData("totalCases");
			}
		});
		btnSortCases.setBounds(124, 639, 89, 42);
		homePanel.add(btnSortCases);
		
		JButton btnTotalDeaths = new JButton("Total Deaths");
		btnTotalDeaths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortData("totalDeaths");
			}
		});
		btnTotalDeaths.setBounds(223, 639, 107, 42);
		homePanel.add(btnTotalDeaths);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Calculate Averages", null, panel, null);
		panel.setLayout(null);
		
		averageField = new JTextField();
		averageField.setFont(new Font("Sitka Display", Font.PLAIN, 34));
		averageField.setToolTipText("Average");
		averageField.setBounds(196, 129, 239, 74);
		panel.add(averageField);
		averageField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Calculate Averages");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 68));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 634, 107);
		panel.add(lblNewLabel);
		
		JButton deathsAverage = new JButton("Deaths");
		deathsAverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				averageField.setText(Integer.toString(Utilities.calculateAverage(statistics, eOrder.TOTAL_DEATHS)));
			}
		});
		deathsAverage.setBounds(128, 224, 170, 47);
		panel.add(deathsAverage);
		
		JLabel lblNewLabel_1 = new JLabel("per country");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(439, 174, 79, 29);
		panel.add(lblNewLabel_1);
		
		JButton casesAverage = new JButton("Cases");
		casesAverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				averageField.setText(Integer.toString(Utilities.calculateAverage(statistics, eOrder.TOTAL_CASES)));
			}
		});
		casesAverage.setBounds(348, 224, 170, 47);
		panel.add(casesAverage);
		casesAverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				averageField.setText(Integer.toString(Utilities.calculateAverage(statistics, eOrder.TOTAL_CASES)));
			}
		});
		
		
		drawTable();
	}
		
				
		public void sortData(String button) {
		switch(button) {
		case "alphabetical":
			if (sortState != eOrder.ALPHABETICAL) {
				Collections.sort(statistics, new NameCompare());
			}
			else {
				Collections.reverse(statistics);
			}
			sortState = eOrder.ALPHABETICAL;
			break;
		
		// Total cases
		case "totalCases":
			if (sortState != eOrder.TOTAL_CASES) {
				Collections.sort(statistics, new CaseTotalCompare());
			}
			else {
				Collections.reverse(statistics);
			}
			sortState = eOrder.TOTAL_CASES;
			break;
			
		// Total Deaths
		case "totalDeaths":
			if (sortState != eOrder.TOTAL_DEATHS) {
				Collections.sort(statistics, new DeathCompare());
			}
			else {
				Collections.reverse(statistics);
			}
			sortState = eOrder.TOTAL_DEATHS;
			break;
		}
		
		
			
		
		drawTable();
	}
	
	public void drawTable() {
		tm.setRowCount(0);
		for(int i = 0; i < 215; i++) {
			Object[] object = new Object[13];
			object[0] = statistics.get(i).getCountry();
			object[1] = statistics.get(i).getTotalCases();
			object[2] = statistics.get(i).getNewCases();
			object[3] = statistics.get(i).getTotalDeaths();
			object[4] = statistics.get(i).getNewDeaths();
			object[5] = statistics.get(i).getTotalRecovered();
			object[6] = statistics.get(i).getActiveCases();
			object[7] = statistics.get(i).getSeriousCritical();
			object[8] = statistics.get(i).getTotalCasesPerMil();
			object[9] = statistics.get(i).getDeathsPerMil();
			object[10] = statistics.get(i).getTotalTests();
			object[11] = statistics.get(i).getTotalTestsPerMil();
			object[12] = statistics.get(i).getTotalPop();
			

			tm.addRow(object);
			
		}
	}
	
	private void createAPieGraph() {
		
		DefaultPieDataset data = new DefaultPieDataset();
		Collections.sort(statistics, new CaseTotalCompare());
		pg.setRowCount(0);
		for(int i = 0; i < 10; i++) {
			
			data.setValue(statistics.get(i).getCountry(), statistics.get(i).getTotalCases());
			
		}
		
		JFreeChart chart = ChartFactory.createPieChart("Top 10 Infected Countries",data,true,true,Locale.ENGLISH);
		
		ChartPanel piePanel = new ChartPanel(chart);
		piePanel.setVisible(true);
		
		tabbedPane.add("Pie Graph", piePanel);
	}
	
	private void buttonSearchEvent() {
		String searchVal = textField.getText();
		textField.setText("");
		Stat match = Utilities.Search(statistics, searchVal);
		
		if(match != null) {				
		tm2.setRowCount(0);
		
		Object[] object = new Object[13];
		object[0] = match.getCountry();
		object[1] = match.getTotalCases();
		object[2] = match.getNewCases();
		object[3] = match.getTotalDeaths();
		object[4] = match.getNewDeaths();
		object[5] = match.getTotalRecovered();
		object[6] = match.getActiveCases();
		object[7] = match.getSeriousCritical();
		object[8] = match.getTotalCasesPerMil();
		object[9] = match.getDeathsPerMil();
		object[10] = match.getTotalTests();
		object[11] = match.getTotalTestsPerMil();
		object[12] = match.getTotalPop();
		
		tm2.addRow(object);
		}
	}
}
