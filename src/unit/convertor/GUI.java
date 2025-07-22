package unit.convertor;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GUI extends javax.swing.JFrame {

    String SU = "Length";
    String inputUnit;
    String outputUnit;
    double inputValue;
    Map<String, String> unitTooltips = new HashMap<>();
    List<Conversion> history = new ArrayList<>();
    double val;

    public GUI() {
        initComponents();
        initializeTooltips();
        // Arrow key bindings for inValue field
        javax.swing.InputMap im = inValue.getInputMap(javax.swing.JComponent.WHEN_FOCUSED);
        javax.swing.ActionMap am = inValue.getActionMap();

        im.put(javax.swing.KeyStroke.getKeyStroke("UP"), "increment");
        im.put(javax.swing.KeyStroke.getKeyStroke("DOWN"), "decrement");

        am.put("increment", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                try {
                    double value = Double.parseDouble(inValue.getText());
                    value += 0.01;
                    inValue.setText(String.format("%.2f", value));
                    convert();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(GUI.this, "Invalid input!");
                }
            }
        });

        am.put("decrement", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                try {
                    double value = Double.parseDouble(inValue.getText());
                    value -= 0.01;
                    inValue.setText(String.format("%.2f", value));
                    convert();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(GUI.this, "Invalid input!");
                }
            }
        });

    }

    private void applyTooltipRenderer(javax.swing.JComboBox<String> comboBox) {
        comboBox.setRenderer(new javax.swing.plaf.basic.BasicComboBoxRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {

                java.awt.Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                String shortUnit = value.toString();
                String tooltip = unitTooltips.getOrDefault(shortUnit, shortUnit);
                if (index > -1) { // only applies when the dropdown is open
                    list.setToolTipText(tooltip);
                } else {
                    comboBox.setToolTipText(tooltip); // when just hovering the selected item
                }
                return c;
            }
        });
    }

    private void initializeTooltips() {
        // Length
        unitTooltips.put("m", "Meter");
        unitTooltips.put("km", "Kilometer");
        unitTooltips.put("cm", "Centimeter");
        unitTooltips.put("mm", "Millimeter");
        unitTooltips.put("mi", "Mile");
        unitTooltips.put("ft", "Foot");
        unitTooltips.put("in", "Inch");
        unitTooltips.put("yd", "Yard");

        // Volume
        unitTooltips.put("L", "Liter");
        unitTooltips.put("m³", "Cubic Meter");
        unitTooltips.put("mL", "Milliliter");
        unitTooltips.put("cm³", "Cubic Centimeter");
        unitTooltips.put("usGal", "US Gallon");
        unitTooltips.put("usFlOz", "US Fluid Ounce");
        unitTooltips.put("ft³", "Cubic Foot");
        unitTooltips.put("in³", "Cubic Inch");
        unitTooltips.put("ukGal", "UK Gallon");
        unitTooltips.put("ukFlOz", "UK Fluid Ounce");

        // Time
        unitTooltips.put("s", "Second");
        unitTooltips.put("min", "Minute");
        unitTooltips.put("h", "Hour");
        unitTooltips.put("day", "Day");
        unitTooltips.put("month", "Month");
        unitTooltips.put("year", "Year");

        // Temperature
        unitTooltips.put("C", "Celsius");
        unitTooltips.put("F", "Fahrenheit");

        // Area
        unitTooltips.put("Km²", "Square Kilometer");
        unitTooltips.put("ha", "Hectare");
        unitTooltips.put("m²", "Square Meter");
        unitTooltips.put("acres", "Acre");
        unitTooltips.put("mi²", "Square Mile");
        unitTooltips.put("ft²", "Square Foot");

        // Speed
        unitTooltips.put("mps", "Meters per Second");
        unitTooltips.put("kmph", "Kilometers per Hour");
        unitTooltips.put("mph", "Miles per Hour");
        unitTooltips.put("fps", "Feet per Second");
        unitTooltips.put("knots", "Knots");

        // Pressure
        unitTooltips.put("bar", "Bar");
        unitTooltips.put("pa", "Pascal");
        unitTooltips.put("atm", "Atmosphere");
        unitTooltips.put("psi", "Pounds per Square Inch");

        // Power
        unitTooltips.put("W", "Watt");
        unitTooltips.put("KW", "Kilowatt");
        unitTooltips.put("hp", "Horsepower");
        unitTooltips.put("BTU/h", "British Thermal Unit per Hour");

        // Energy
        unitTooltips.put("J", "Joule");
        unitTooltips.put("KWH", "Kilowatt Hour");
        unitTooltips.put("BTU", "British Thermal Unit");
        unitTooltips.put("cal", "Calorie");

        // Data Storage
        unitTooltips.put("Byte", "Byte");
        unitTooltips.put("bit", "Bit");
        unitTooltips.put("Kb", "Kilobit");
        unitTooltips.put("KB", "Kilobyte");
        unitTooltips.put("Mb", "Megabit");
        unitTooltips.put("MB", "Megabyte");
        unitTooltips.put("Gb", "Gigabit");
        unitTooltips.put("GB", "Gigabyte");
        unitTooltips.put("Tb", "Terabit");
        unitTooltips.put("TB", "Terabyte");
        unitTooltips.put("Pb", "Petabit");
        unitTooltips.put("PB", "Petabyte");

        // Weight/Mass
        unitTooltips.put("mg", "Milligram");
        unitTooltips.put("g", "Gram");
        unitTooltips.put("kg", "Kilogram");
        unitTooltips.put("oz", "Ounce");
        unitTooltips.put("lb", "Pound");
        unitTooltips.put("ton", "Ton");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        SelectedUnit = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        inUnit = new javax.swing.JComboBox<>();
        inValue = new javax.swing.JTextField();
        incValue = new javax.swing.JButton();
        decValue = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        result = new javax.swing.JTextField();
        outUnit = new javax.swing.JComboBox<>();
        copy = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        reverse = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        historyCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 400));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(231, 235, 234));
        jPanel3.setPreferredSize(new java.awt.Dimension(648, 55));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 3, 24)); // NOI18N
        jLabel1.setText("Unite couverter");
        jPanel3.add(jLabel1, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.GridLayout(0, 1));

        jPanel4.setBackground(new java.awt.Color(29, 53, 87));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        SelectedUnit.setBackground(new java.awt.Color(244, 225, 210));
        SelectedUnit.setFont(new java.awt.Font("Book Antiqua", 3, 22)); // NOI18N
        SelectedUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Length", "Volume", "Time", "Temperature", "Area", "Speed", "Pressure", "power", "Energy", "Data Storage", "Frequency", "weight/Mass" }));
        SelectedUnit.setPreferredSize(new java.awt.Dimension(165, 50));
        SelectedUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectedUnitActionPerformed(evt);
            }
        });
        jPanel4.add(SelectedUnit, new java.awt.GridBagConstraints());

        jPanel2.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(29, 53, 87));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setBackground(new java.awt.Color(29, 53, 87));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        inUnit.setBackground(new java.awt.Color(244, 225, 210));
        inUnit.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        inUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m", "km", "cm", "mm", "mi", "ft", "in", "yd" }));
        applyTooltipRenderer(inUnit);
        inUnit.setMinimumSize(new java.awt.Dimension(72, 35));
        inUnit.setPreferredSize(new java.awt.Dimension(90, 46));
        inUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inUnitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel7.add(inUnit, gridBagConstraints);

        inValue.setBackground(new java.awt.Color(244, 225, 210));
        inValue.setText("0.0");
        inValue.setMinimumSize(new java.awt.Dimension(64, 30));
        inValue.setPreferredSize(new java.awt.Dimension(98, 22));
        inValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inValueActionPerformed(evt);
            }
        });
        inValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inValueKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 34;
        jPanel7.add(inValue, gridBagConstraints);

        incValue.setBackground(new java.awt.Color(244, 225, 210));
        incValue.setFont(new java.awt.Font("Inter", 0, 10)); // NOI18N
        incValue.setText("⌃");
        incValue.setMinimumSize(new java.awt.Dimension(30, 15));
        incValue.setPreferredSize(new java.awt.Dimension(41, 12));
        incValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incValueActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 13;
        jPanel7.add(incValue, gridBagConstraints);

        decValue.setBackground(new java.awt.Color(244, 225, 210));
        decValue.setFont(new java.awt.Font("Inter", 0, 10)); // NOI18N
        decValue.setText("⌄");
        decValue.setMinimumSize(new java.awt.Dimension(30, 15));
        decValue.setPreferredSize(new java.awt.Dimension(41, 12));
        decValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decValueActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel7.add(decValue, gridBagConstraints);

        jPanel5.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(29, 53, 87));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        result.setBackground(new java.awt.Color(244, 225, 210));
        result.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        result.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        result.setEnabled(false);
        result.setMinimumSize(new java.awt.Dimension(64, 30));
        result.setPreferredSize(new java.awt.Dimension(102, 46));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel8.add(result, gridBagConstraints);

        outUnit.setBackground(new java.awt.Color(244, 225, 210));
        outUnit.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        outUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m", "km", "cm", "mm", "mi", "ft", "in", "yd" }));
        applyTooltipRenderer(outUnit);
        outUnit.setMinimumSize(new java.awt.Dimension(72, 30));
        outUnit.setPreferredSize(new java.awt.Dimension(90, 46));
        outUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outUnitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel8.add(outUnit, gridBagConstraints);

        copy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unit/convertor/copy-icon.png"))); // NOI18N
        copy.setMinimumSize(new java.awt.Dimension(22, 30));
        copy.setPreferredSize(new java.awt.Dimension(30, 46));
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel8.add(copy, gridBagConstraints);

        jPanel5.add(jPanel8);

        jPanel2.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(29, 53, 87));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        reverse.setBackground(new java.awt.Color(244, 225, 210));
        reverse.setFont(new java.awt.Font("Book Antiqua", 3, 22)); // NOI18N
        reverse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unit/convertor/convert-icon.png"))); // NOI18N
        reverse.setText("reverse");
        reverse.setPreferredSize(new java.awt.Dimension(132, 55));
        reverse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reverseActionPerformed(evt);
            }
        });
        jPanel6.add(reverse, new java.awt.GridBagConstraints());

        jPanel2.add(jPanel6);

        jPanel9.setBackground(new java.awt.Color(29, 53, 87));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        historyCombo.setBackground(new java.awt.Color(244, 225, 210));
        historyCombo.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        historyCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "history" }));
        historyCombo.setPreferredSize(new java.awt.Dimension(300, 50));
        historyCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyComboActionPerformed(evt);
            }
        });
        jPanel9.add(historyCombo, new java.awt.GridBagConstraints());

        jLabel3.setFont(new java.awt.Font("Inter", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(244, 225, 210));
        jLabel3.setText("?");
        jLabel3.setToolTipText("click Enter after your conversion to add it to history ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        jPanel9.add(jLabel3, gridBagConstraints);

        jPanel2.add(jPanel9);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String toSuperscript(int n) {
        String digits = String.valueOf(n);
        StringBuilder sb = new StringBuilder();

        for (char c : digits.toCharArray()) {
            switch (c) {
                case '-':
                    sb.append('\u207B');
                    break; // superscript minus
                case '0':
                    sb.append('\u2070');
                    break;
                case '1':
                    sb.append('\u00B9');
                    break;
                case '2':
                    sb.append('\u00B2');
                    break;
                case '3':
                    sb.append('\u00B3');
                    break;
                case '4':
                    sb.append('\u2074');
                    break;
                case '5':
                    sb.append('\u2075');
                    break;
                case '6':
                    sb.append('\u2076');
                    break;
                case '7':
                    sb.append('\u2077');
                    break;
                case '8':
                    sb.append('\u2078');
                    break;
                case '9':
                    sb.append('\u2079');
                    break;
            }
        }

        return sb.toString();
    }

    private String formatSmart(double val) {
        if (Math.abs(val) < 1e-3 || Math.abs(val) >= 1e4) {
            String sci = String.format("%.4e", val); // e.g., 1.2345e+22
            String[] parts = sci.split("e");
            String base = parts[0];
            int exponent = Integer.parseInt(parts[1]);
            return base + " × 10" + toSuperscript(exponent);
        } else {
            String raw = String.format("%.4f", val); // e.g., 0.0100
            raw = raw.replaceAll("0+$", "");          // remove trailing zeros
            raw = raw.replaceAll("\\.$", "");         // remove trailing dot if needed
            return raw;
        }
    }

    private void copyToClipboard() {
        String resultText = result.getText();
        if (resultText == null || resultText.trim().isEmpty()) {
            return;
        }

        StringSelection stringSelection = new StringSelection(resultText);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        // Optional: show a small confirmation
        JOptionPane.showMessageDialog(this, "Result copied to clipboard!");
    }

    public void convert() {

        // SAFETY CHECK
        if (SU == null || inUnit.getSelectedItem() == null || outUnit.getSelectedItem() == null) {
            return;
        }
        DecimalFormat formatter = new DecimalFormat("#.#####");
        String formatted;
        boolean goodFormatted = true;
        try {
            inputUnit = inUnit.getSelectedItem().toString();
            outputUnit = outUnit.getSelectedItem().toString();
            inputValue = Double.parseDouble(inValue.getText());
        } catch (NumberFormatException e) {
            goodFormatted = false;
        }

        if (!goodFormatted) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }

        try {
            switch (SU) {
                case "Area":
                    val = new Area(inputValue, inputUnit).getter(outputUnit);
                    break;
                case "Data Storage":
                    val = new DataStorage(inputValue, inputUnit).getter(outputUnit);
                    break;
                case "Energy":
                    val = new Energy(inputValue, inputUnit).getter(outputUnit);
                    break;
                case "Frequency":
                    val = new Frequency(inputValue, inputUnit).getter(outputUnit);
                    break;
                case "Length":
                    val = new Length(inputValue, inputUnit).getter(outputUnit);
                    break;
                case "power":
                    val = new Power(inputValue, inputUnit).getter(outputUnit);
                    break;
                case "Pressure":
                    val = new Pressure(inputValue, inputUnit).getter(outputUnit);
                    break;
                case "Speed":
                    val = new Speed(inputValue, inputUnit).getter(outputUnit);
                    break;
                case "Temperature":
                    val = new Temperature(inputValue, inputUnit).getter(outputUnit);
                    break;
                case "Volume":
                    val = new Volume(inputValue, inputUnit).getter(outputUnit);
                    break;
                case "weight/Mass":
                    val = new WeightMass(inputValue, inputUnit).getter(outputUnit);
                    break;
                case "Time":
                    val = new Time(inputValue, inputUnit).getter(outputUnit);
                    break;
                default:
                    result.setText("Unknown unit type");
                    return;
            }
            result.setText(formatSmart(val));
        } catch (Exception e) {
            result.setText("Error");
            e.printStackTrace();
        }
    }


    private void SelectedUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectedUnitActionPerformed
        SU = SelectedUnit.getSelectedItem().toString();
        switch (SU) {
            case "Area":
                inUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Km²", "ha", "m²", "acres", "mi²", "ft²"}));
                outUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Km²", "ha", "m²", "acres", "mi²", "ft²"}));
                break;
            case "Data Storage":
                inUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Byte", "bit", "Kb", "KB", "Mb", "MB", "Gb", "GB", "Tb", "TB", "Pb", "PB"}));
                outUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Byte", "bit", "Kb", "KB", "Mb", "MB", "Gb", "GB", "Tb", "TB", "Pb", "PB"}));
                break;
            case "Energy":
                inUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"J", "KWH", "BTU", "cal"}));
                outUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"J", "KWH", "BTU", "cal"}));
                break;
            case "Frequency":
                inUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"HZ", "cycle/s"}));
                outUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"HZ", "cycle/s"}));
                break;
            case "Length":
                inUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"m", "km", "cm", "mm", "mi", "ft", "in", "yd"}));
                outUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"m", "km", "cm", "mm", "mi", "ft", "in", "yd"}));
                break;
            case "power":
                inUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"W", "KW", "hp", "BTU/h"}));
                outUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"W", "KW", "hp", "BTU/h"}));
                break;
            case "Pressure":
                inUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"bar", "pa", "atm", "psi"}));
                outUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"bar", "pa", "atm", "psi"}));
                break;
            case "Speed":
                inUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"mps", "kmph", "mph", "fps", "knots"}));
                outUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"mps", "kmph", "mph", "fps", "knots"}));
                break;
            case "Temperature":
                inUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"C", "F"}));
                outUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"C", "F"}));
                break;
            case "Volume":
                inUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"L", "m³", "mL", "cm³", "usGal", "usFlOz", "ft³", "in³", "ukGal", "ukFlOz"}));
                outUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"L", "m³", "mL", "cm³", "usGal", "usFlOz", "ft³", "in³", "ukGal", "ukFlOz"}));
                break;
            case "weight/Mass":
                inUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"mg", "g", "kg", "oz", "lb", "ton"}));
                outUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"mg", "g", "kg", "oz", "lb", "ton"}));
                break;
            case "Time":
                inUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"s", "min", "h", "day", "month", "year"}));
                outUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"s", "min", "h", "day", "month", "year"}));
                break;
            default:
                break;
        }
        convert();
    }//GEN-LAST:event_SelectedUnitActionPerformed

    private void inUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inUnitActionPerformed
        convert();
    }//GEN-LAST:event_inUnitActionPerformed

    private void outUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outUnitActionPerformed
        convert();
    }//GEN-LAST:event_outUnitActionPerformed

    private void reverseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reverseActionPerformed

        // Step 1: Parse the current result value first
        double reverseInput;
        try {
            String resultText = result.getText().replace(",", "."); // Support comma
            if (resultText.isEmpty()) {
                return;
            }

            // Handle scientific notation if it has "× 10⁶"
            if (resultText.contains("×")) {
                String[] parts = resultText.split("×");
                String base = parts[0].trim();
                String expPart = parts[1].trim().replace("10", "").trim();

                // Convert superscript to regular digits
                String normalExponent = expPart
                        .replace("⁰", "0").replace("¹", "1").replace("²", "2").replace("³", "3")
                        .replace("⁴", "4").replace("⁵", "5").replace("⁶", "6").replace("⁷", "7")
                        .replace("⁸", "8").replace("⁹", "9").replace("⁻", "-");

                reverseInput = Double.parseDouble(base) * Math.pow(10, Integer.parseInt(normalExponent));
            } else {
                reverseInput = Double.parseDouble(resultText);
            }

            // Step 2: Swap units
            Object temp = inUnit.getSelectedItem();
            inUnit.setSelectedItem(outUnit.getSelectedItem());
            outUnit.setSelectedItem(temp);

            // Step 3: Set new input
            inValue.setText(reverseInput + "");
            convert();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_reverseActionPerformed

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed
        copyToClipboard();
    }//GEN-LAST:event_copyActionPerformed

    private void incValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incValueActionPerformed
        double V = 0;
        try {
            V = Double.parseDouble(inValue.getText());
            V += 0.01;
        } catch (NullPointerException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
            return;
        }
        inValue.setText(String.format("%.2f", V));
        convert();
    }//GEN-LAST:event_incValueActionPerformed

    private void inValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inValueActionPerformed
        convert();
        Conversion c = new Conversion(inputValue, val, inputUnit, outputUnit);
        history.add(c);
        historyCombo.addItem(c.toString());
//        historyModel.addElement(c);
    }//GEN-LAST:event_inValueActionPerformed

    private void decValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decValueActionPerformed
        double V = 0;
        try {
            V = Double.parseDouble(inValue.getText());
            V -= 0.01;
        } catch (NullPointerException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
            return;
        }
        inValue.setText(String.format("%.2f", V));
        convert();
    }//GEN-LAST:event_decValueActionPerformed

    private void inValueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inValueKeyReleased
        inValue.setText(inValue.getText().replace(',', '.'));
        String text = inValue.getText();

        // Check if input is empty or contains only a minus sign
        if (text.isEmpty() || text.equals("-")) {
            result.setText("");
            return;
        }
        try {
            // Try to parse the input as a double
            Double.parseDouble(text);
            convert();  // Only convert if input is valid
        } catch (NumberFormatException e) {
            // Show error and keep old value
            JOptionPane.showMessageDialog(this, "Invalid input!");
            inValue.setText(text.substring(0, text.length() - 1));  // Remove last character
        }
    }//GEN-LAST:event_inValueKeyReleased

    private void historyComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyComboActionPerformed
        Conversion selected = new Conversion(historyCombo.getSelectedItem().toString());
        inValue.setText(String.valueOf(selected.getInValue()));
        inUnit.setSelectedItem(selected.getInUnit());
        outUnit.setSelectedItem(selected.getOutUnit());
        convert();
    }//GEN-LAST:event_historyComboActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> SelectedUnit;
    private javax.swing.JButton copy;
    private javax.swing.JButton decValue;
    private javax.swing.JComboBox<String> historyCombo;
    private javax.swing.JComboBox<String> inUnit;
    private javax.swing.JTextField inValue;
    private javax.swing.JButton incValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JComboBox<String> outUnit;
    private javax.swing.JTextField result;
    private javax.swing.JButton reverse;
    // End of variables declaration//GEN-END:variables
}
