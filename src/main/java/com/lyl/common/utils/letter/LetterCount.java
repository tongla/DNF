package com.lyl.common.utils.letter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LetterCount {

	private JFrame frame;

	private JTextField input;

	public LetterCount() {
		init();
		input = new JTextField();
		frame.add(input, BorderLayout.CENTER);

		final JLabel hint = new JLabel();
		frame.add(hint, BorderLayout.NORTH);

		JButton confirm = new JButton("确定");
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// int length = input.getText().length();
				String text = input.getText();
				if (text != null) {
					hint.setText(String.valueOf(text.length()));
				}
			}
		});

		frame.add(confirm, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	public void init() {
		frame = new JFrame("字数统计");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new LetterCount();
	}

}
