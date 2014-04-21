package ru.aleskovets.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class YANUKOVICHELIZATOR extends JFrame {

	private static final long serialVersionUID = -674523065222869585L;
	private int count = 0;
	private String country;
	private JLabel countryLabel;
	private JLabel imageLabel;
	private JPanel buttonsPanel;
	private JButton russia;
	private JButton ukraine;
	private JButton start;
	private JButton restart;

	public YANUKOVICHELIZATOR() {
		super("GDE YANUKOVICH, SUKA?!");
		
		setBounds(200, 200, 1000, 1000);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		countryLabel = new JLabel("UGADAI, GDE YANUKOVICH?!");
		countryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countryLabel.setFont(new Font("Arial",2 , 28));
		
		imageLabel = new JLabel();
		initImageLabel();
		
		start = new JButton("START THIS AWESOME QUEST");
		russia = new JButton("RUSSIA");
		ukraine = new JButton("UKRAINE");
		restart = new JButton("RESTART!");
		
		buttonsPanel = new JPanel(new FlowLayout());
		buttonsPanel.add(start);
		buttonsPanel.add(restart);
		buttonsPanel.add(russia);
		buttonsPanel.add(ukraine);
		
		restart.setVisible(false);
		russia.setVisible(false);
		ukraine.setVisible(false);
		
		add(countryLabel, BorderLayout.NORTH);
		
		add(imageLabel, BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(buttonsPanel, BorderLayout.SOUTH);
		initListeners();
	}

	private void initListeners() {
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start.setVisible(false);
				russia.setVisible(true);
				ukraine.setVisible(true);
			}
		});
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart.setVisible(false);
				start.setVisible(true);
				initImageLabel();
			}
		});
		russia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				country = "RUSSIA";
				count++;
				updateLabel();
			}
		});
		ukraine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				country = "UKRAINE";
				count++;
				updateLabel();
			}
		});
	}
	
	private void initImageLabel() {
		countryLabel.setText("UGADAI, GDE YANUKOVICH?!");
		imageLabel.setIcon(new ImageIcon(getClass().getResource("/img/yanukovich_title.jpg")));
	}

	private void updateLabel() {
		URL imgURL;
		if (count == 5) {
			imgURL = getClass().getResource("/img/yanukovich_result_5_wrong_answers.jpg");
			updateLabelObama();
		} else if (country.equals("RUSSIA")) {
			countryLabel.setText("RUSSIA?!");
			imgURL = getClass().getResource("/img/yanukovich_result_russia.jpg");
		} else {
			countryLabel.setText("UKRAINE?!");
			imgURL = getClass().getResource("/img/yanukovich_result_ukraine.jpg");
		}
		imageLabel.setIcon(new ImageIcon(imgURL));
	}
	
	private void updateLabelObama() {
		countryLabel.setText("OBAMA NASHEL EGO RANSHE!");
		count = 0;
		restart.setVisible(true);
		russia.setVisible(false);
		ukraine.setVisible(false);
	}

	public static void main(String[] args) {
		YANUKOVICHELIZATOR app = new YANUKOVICHELIZATOR();
		app.setVisible(true);
		//app.pack();
	}
}