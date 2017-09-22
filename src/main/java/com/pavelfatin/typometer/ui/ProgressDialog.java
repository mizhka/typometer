/*
 * Copyright 2017 Pavel Fatin, https://pavelfatin.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pavelfatin.typometer.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import static java.lang.Math.round;

class ProgressDialog extends JDialog {
    private static final Color DEFAULT_LABEL_FOREGROUND = UIManager.getColor("Label.foreground");

    private JPanel contentPane;
    private JButton myButton;
    private JProgressBar myProgressBar;
    private JLabel myPercent;
    private JLabel myFooter;
    private JLabel myHeader;

    ProgressDialog(JFrame parent, String title) {
        super(parent, title, true);

        setContentPane(contentPane);
        setPreferredSize(new Dimension(400, 120));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);

        getRootPane().setDefaultButton(myButton);

        myHeader.setMinimumSize(myHeader.getPreferredSize());
        myFooter.setMinimumSize(myFooter.getPreferredSize());

        myPercent.setMinimumSize(myPercent.getPreferredSize());
        myPercent.setMaximumSize(myPercent.getPreferredSize());

        initListeners();

        reset();
    }

    private void initListeners() {
        myButton.addActionListener(e -> dispose());

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ACTION_CLOSE");

        getRootPane().getActionMap().put("ACTION_CLOSE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void reset() {
        setHeader(" ");
        setFooter(" ");
        setMaximum(100);
        setValue(0);
    }

    void setHeader(String text) {
        setHeader(text, DEFAULT_LABEL_FOREGROUND);
    }

    void setHeader(String text, Color color) {
        myHeader.setForeground(color);
        myHeader.setText(text);
    }

    void setFooter(String text) {
        myFooter.setText(text);
    }

    void setMaximum(int value) {
        myProgressBar.setMaximum(value);
    }

    void setValue(int value) {
        myProgressBar.setValue(value);

        int percent = (int) round(100.0D * value / myProgressBar.getMaximum());
        myPercent.setText(String.format("%d%%", percent));
    }

    void setButtonText(String text) {
        myButton.setText(text);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(14, 14, 14, 14), null));
        myProgressBar = new JProgressBar();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 8, 10);
        contentPane.add(myProgressBar, gbc);
        myButton = new JButton();
        myButton.setText("Cancel");
        myButton.setMnemonic('C');
        myButton.setDisplayedMnemonicIndex(0);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 8, 0);
        contentPane.add(myButton, gbc);
        myPercent = new JLabel();
        myPercent.setText("100%");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 8, 10);
        contentPane.add(myPercent, gbc);
        myHeader = new JLabel();
        myHeader.setText("Header");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 5, 0);
        contentPane.add(myHeader, gbc);
        myFooter = new JLabel();
        myFooter.setText("Footer");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(myFooter, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
