package GUI;

import com.sun.glass.events.KeyEvent;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import virtual.machine.Compiler;



public class IDE extends javax.swing.JFrame {    

    
    
    public IDE() {
        initComponents();
        this.setTitle("EZ IDE");
        DefaultTableModel fc = (DefaultTableModel) flowchart.getModel();        
        ButtonGroup grp = new ButtonGroup();        
        grp.add(insertRB);
        grp.add(editRB);        
        grp.add(insertAboveRB);
        grp.add(insertBelowRB);
        insertRB.setSelected(true);
        JScrollBar jScrollBar1 = new JScrollBar();      
        JScrollBar jScrollBar2 = new JScrollBar();               
        jScrollBar1 = scroll.getVerticalScrollBar();
        jScrollBar2 = jScrollPane2.getVerticalScrollBar();
        jScrollBar2.setModel(jScrollBar1.getModel());
        setIcon();
    }
    
    public static String currentFile = "";
    private static String[] clipBoard;    
    public static boolean isEditing = false;    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        flowchart = new javax.swing.JTable(){
            private static final long serialVersionUID = 1L;
            public boolean isCellEditable(int row, int column){
                return false;
            };
        };
        commandPanel = new javax.swing.JPanel();
        insertRB = new javax.swing.JRadioButton();
        editRB = new javax.swing.JRadioButton();
        insertAboveRB = new javax.swing.JRadioButton();
        insertBelowRB = new javax.swing.JRadioButton();
        builtInsScroll = new javax.swing.JScrollPane();
        builtInsPanel = new javax.swing.JPanel();
        functionButton = new javax.swing.JButton();
        callButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        endfuncButton = new javax.swing.JButton();
        intButton = new javax.swing.JButton();
        floatButton = new javax.swing.JButton();
        phraseButton = new javax.swing.JButton();
        assignButton = new javax.swing.JButton();
        ifButton = new javax.swing.JButton();
        elseButton = new javax.swing.JButton();
        endifButton = new javax.swing.JButton();
        forButton = new javax.swing.JButton();
        endforButton = new javax.swing.JButton();
        commentButton = new javax.swing.JButton();
        importableFunctionPanel = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        standardPanel = new javax.swing.JPanel();
        getButton = new javax.swing.JButton();
        sayButton = new javax.swing.JButton();
        linebreakButton = new javax.swing.JButton();
        mathPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        subButton = new javax.swing.JButton();
        mulButton = new javax.swing.JButton();
        divButton = new javax.swing.JButton();
        powButton = new javax.swing.JButton();
        incrementButton = new javax.swing.JButton();
        decrementButton = new javax.swing.JButton();
        moveUpButton = new javax.swing.JButton();
        moveDownButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lineNumber = new javax.swing.JTable();
        MenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newProgramItem = new javax.swing.JMenuItem();
        saveProgramItem = new javax.swing.JMenuItem();
        openProgramItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        copyItem = new javax.swing.JMenuItem();
        cutItem = new javax.swing.JMenuItem();
        pasteItem = new javax.swing.JMenuItem();
        runMenu = new javax.swing.JMenu();
        runProgramItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        EZMenuItem = new javax.swing.JMenuItem();
        AboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        bg.setBackground(new java.awt.Color(204, 255, 204));

        scroll.setBackground(new java.awt.Color(204, 255, 204));

        flowchart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        flowchart.setDragEnabled(true);
        flowchart.setDropMode(javax.swing.DropMode.INSERT_ROWS);
        flowchart.setSelectionBackground(new java.awt.Color(204, 255, 204));
        flowchart.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scroll.setViewportView(flowchart);

        commandPanel.setBackground(new java.awt.Color(153, 255, 153));

        insertRB.setBackground(new java.awt.Color(153, 255, 153));
        insertRB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        insertRB.setText("Insert ");

        editRB.setBackground(new java.awt.Color(153, 255, 153));
        editRB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        editRB.setText("Edit");

        insertAboveRB.setBackground(new java.awt.Color(153, 255, 153));
        insertAboveRB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        insertAboveRB.setText("Insert above");
        insertAboveRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertAboveRBActionPerformed(evt);
            }
        });

        insertBelowRB.setBackground(new java.awt.Color(153, 255, 153));
        insertBelowRB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        insertBelowRB.setText("Insert below");

        builtInsScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        builtInsPanel.setBackground(new java.awt.Color(204, 255, 204));

        functionButton.setBackground(new java.awt.Color(204, 255, 204));
        functionButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        functionButton.setText("Function");
        functionButton.setPreferredSize(new java.awt.Dimension(100, 30));
        functionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                functionButtonActionPerformed(evt);
            }
        });

        callButton.setBackground(new java.awt.Color(204, 255, 204));
        callButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        callButton.setText("Call");
        callButton.setPreferredSize(new java.awt.Dimension(100, 30));
        callButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callButtonActionPerformed(evt);
            }
        });

        returnButton.setBackground(new java.awt.Color(204, 255, 204));
        returnButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        endfuncButton.setBackground(new java.awt.Color(204, 255, 204));
        endfuncButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        endfuncButton.setText("Endfunc");
        endfuncButton.setPreferredSize(new java.awt.Dimension(100, 30));
        endfuncButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endfuncButtonActionPerformed(evt);
            }
        });

        intButton.setBackground(new java.awt.Color(204, 255, 204));
        intButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        intButton.setText("Integer");
        intButton.setPreferredSize(new java.awt.Dimension(100, 30));
        intButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intButtonActionPerformed(evt);
            }
        });

        floatButton.setBackground(new java.awt.Color(204, 255, 204));
        floatButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        floatButton.setText("Decimal");
        floatButton.setPreferredSize(new java.awt.Dimension(100, 30));
        floatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floatButtonActionPerformed(evt);
            }
        });

        phraseButton.setBackground(new java.awt.Color(204, 255, 204));
        phraseButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        phraseButton.setText("Phrase");
        phraseButton.setPreferredSize(new java.awt.Dimension(100, 30));
        phraseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phraseButtonActionPerformed(evt);
            }
        });

        assignButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        assignButton.setText("Assign");
        assignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignButtonActionPerformed(evt);
            }
        });

        ifButton.setBackground(new java.awt.Color(204, 255, 204));
        ifButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        ifButton.setText("If");
        ifButton.setOpaque(false);
        ifButton.setPreferredSize(new java.awt.Dimension(100, 30));
        ifButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ifButtonActionPerformed(evt);
            }
        });

        elseButton.setBackground(new java.awt.Color(204, 255, 204));
        elseButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        elseButton.setText("Else");
        elseButton.setPreferredSize(new java.awt.Dimension(100, 30));
        elseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elseButtonActionPerformed(evt);
            }
        });

        endifButton.setBackground(new java.awt.Color(204, 255, 204));
        endifButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        endifButton.setText("Endif");
        endifButton.setPreferredSize(new java.awt.Dimension(100, 30));
        endifButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endifButtonActionPerformed(evt);
            }
        });

        forButton.setBackground(new java.awt.Color(204, 255, 204));
        forButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        forButton.setText("For");
        forButton.setPreferredSize(new java.awt.Dimension(100, 30));
        forButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forButtonActionPerformed(evt);
            }
        });

        endforButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        endforButton.setText("Endfor");
        endforButton.setPreferredSize(new java.awt.Dimension(100, 30));
        endforButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endforButtonActionPerformed(evt);
            }
        });

        commentButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        commentButton.setText("Comment");
        commentButton.setPreferredSize(new java.awt.Dimension(100, 30));
        commentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout builtInsPanelLayout = new javax.swing.GroupLayout(builtInsPanel);
        builtInsPanel.setLayout(builtInsPanelLayout);
        builtInsPanelLayout.setHorizontalGroup(
            builtInsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(builtInsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(builtInsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(builtInsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(assignButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(returnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(functionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(callButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(endfuncButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(floatButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phraseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(forButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(intButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ifButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endifButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endforButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        builtInsPanelLayout.setVerticalGroup(
            builtInsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(builtInsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(functionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(callButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endfuncButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(floatButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phraseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(assignButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ifButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endifButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(endforButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        builtInsScroll.setViewportView(builtInsPanel);

        javax.swing.GroupLayout commandPanelLayout = new javax.swing.GroupLayout(commandPanel);
        commandPanel.setLayout(commandPanelLayout);
        commandPanelLayout.setHorizontalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(insertBelowRB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insertAboveRB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editRB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insertRB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commandPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(builtInsScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        commandPanelLayout.setVerticalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(insertRB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editRB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertAboveRB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertBelowRB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(builtInsScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        importableFunctionPanel.setBackground(new java.awt.Color(153, 255, 153));

        deleteButton.setBackground(new java.awt.Color(204, 255, 204));
        deleteButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/cross.png"))); // NOI18N
        deleteButton.setText("Delete line");
        deleteButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        deleteButton.setOpaque(false);
        deleteButton.setPreferredSize(new java.awt.Dimension(30, 30));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(153, 255, 153));
        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setToolTipText("Math Functions");
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jTabbedPane1.setOpaque(true);

        standardPanel.setBackground(new java.awt.Color(204, 255, 204));

        getButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        getButton.setText("Get");
        getButton.setPreferredSize(new java.awt.Dimension(30, 30));
        getButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getButtonActionPerformed(evt);
            }
        });

        sayButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        sayButton.setText("Say");
        sayButton.setPreferredSize(new java.awt.Dimension(30, 30));
        sayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sayButtonActionPerformed(evt);
            }
        });

        linebreakButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        linebreakButton.setText("Line Break");
        linebreakButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linebreakButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout standardPanelLayout = new javax.swing.GroupLayout(standardPanel);
        standardPanel.setLayout(standardPanelLayout);
        standardPanelLayout.setHorizontalGroup(
            standardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(standardPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(standardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sayButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(linebreakButton, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(getButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        standardPanelLayout.setVerticalGroup(
            standardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(standardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sayButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(getButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(linebreakButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Standard", standardPanel);

        mathPanel.setBackground(new java.awt.Color(204, 255, 204));

        addButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        addButton.setText("Add");
        addButton.setPreferredSize(new java.awt.Dimension(30, 30));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        subButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        subButton.setText("Subtract");
        subButton.setPreferredSize(new java.awt.Dimension(30, 30));
        subButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subButtonActionPerformed(evt);
            }
        });

        mulButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        mulButton.setText("Multiply");
        mulButton.setPreferredSize(new java.awt.Dimension(30, 30));
        mulButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mulButtonActionPerformed(evt);
            }
        });

        divButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        divButton.setText("Divide");
        divButton.setPreferredSize(new java.awt.Dimension(30, 30));
        divButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divButtonActionPerformed(evt);
            }
        });

        powButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        powButton.setText("Power");
        powButton.setPreferredSize(new java.awt.Dimension(30, 30));
        powButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powButtonActionPerformed(evt);
            }
        });

        incrementButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        incrementButton.setText("Increment");
        incrementButton.setPreferredSize(new java.awt.Dimension(30, 30));
        incrementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incrementButtonActionPerformed(evt);
            }
        });

        decrementButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        decrementButton.setText("Decrement");
        decrementButton.setPreferredSize(new java.awt.Dimension(30, 30));
        decrementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decrementButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mathPanelLayout = new javax.swing.GroupLayout(mathPanel);
        mathPanel.setLayout(mathPanelLayout);
        mathPanelLayout.setHorizontalGroup(
            mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(mathPanelLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(subButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mulButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(divButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(powButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(incrementButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(decrementButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mathPanelLayout.setVerticalGroup(
            mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mathPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(subButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mulButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(divButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(powButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(incrementButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decrementButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Math", mathPanel);

        moveUpButton.setBackground(new java.awt.Color(204, 255, 204));
        moveUpButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        moveUpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/up button.png"))); // NOI18N
        moveUpButton.setText("Move up");
        moveUpButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        moveUpButton.setOpaque(false);
        moveUpButton.setPreferredSize(new java.awt.Dimension(30, 30));
        moveUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveUpButtonActionPerformed(evt);
            }
        });

        moveDownButton.setBackground(new java.awt.Color(204, 255, 204));
        moveDownButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        moveDownButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/down button.png"))); // NOI18N
        moveDownButton.setText("Move down");
        moveDownButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        moveDownButton.setOpaque(false);
        moveDownButton.setPreferredSize(new java.awt.Dimension(30, 30));
        moveDownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveDownButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout importableFunctionPanelLayout = new javax.swing.GroupLayout(importableFunctionPanel);
        importableFunctionPanel.setLayout(importableFunctionPanelLayout);
        importableFunctionPanelLayout.setHorizontalGroup(
            importableFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importableFunctionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(importableFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(moveUpButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(moveDownButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        importableFunctionPanelLayout.setVerticalGroup(
            importableFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importableFunctionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moveUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moveDownButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1))
        );

        jScrollPane2.setBackground(new java.awt.Color(204, 255, 204));

        lineNumber.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lineNumber.setEnabled(false);
        lineNumber.setFocusable(false);
        lineNumber.setSelectionBackground(new java.awt.Color(204, 255, 204));
        jScrollPane2.setViewportView(lineNumber);
        if (lineNumber.getColumnModel().getColumnCount() > 0) {
            lineNumber.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importableFunctionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commandPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(importableFunctionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scroll)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        fileMenu.setText("File");

        newProgramItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newProgramItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/new.png"))); // NOI18N
        newProgramItem.setText("New Program");
        newProgramItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProgramItemActionPerformed(evt);
            }
        });
        fileMenu.add(newProgramItem);

        saveProgramItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveProgramItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Save.png"))); // NOI18N
        saveProgramItem.setText("Save Program");
        saveProgramItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveProgramItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveProgramItem);

        openProgramItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openProgramItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Open.png"))); // NOI18N
        openProgramItem.setText("Open Program");
        openProgramItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openProgramItemActionPerformed(evt);
            }
        });
        fileMenu.add(openProgramItem);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/exit.png"))); // NOI18N
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        MenuBar.add(fileMenu);

        editMenu.setText("Edit");

        copyItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        copyItem.setText("Copy");
        copyItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyItemActionPerformed(evt);
            }
        });
        editMenu.add(copyItem);

        cutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        cutItem.setText("Cut");
        cutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutItemActionPerformed(evt);
            }
        });
        editMenu.add(cutItem);

        pasteItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        pasteItem.setText("Paste");
        pasteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteItemActionPerformed(evt);
            }
        });
        editMenu.add(pasteItem);

        MenuBar.add(editMenu);

        runMenu.setText("Run");

        runProgramItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.SHIFT_MASK));
        runProgramItem.setText("Run Program");
        runProgramItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runProgramItemActionPerformed(evt);
            }
        });
        runMenu.add(runProgramItem);

        MenuBar.add(runMenu);

        helpMenu.setText("Help");

        EZMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        EZMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/help.png"))); // NOI18N
        EZMenuItem.setText("Help on EZ Programming");
        EZMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EZMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(EZMenuItem);

        AboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/about.png"))); // NOI18N
        AboutMenuItem.setText("About");
        AboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(AboutMenuItem);

        MenuBar.add(helpMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void intButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intButtonActionPerformed
        isEditing = true;
        String x = JOptionPane.showInputDialog("Variable name: ");
        String y = JOptionPane.showInputDialog("Value: ");        
        addLine("Integer " + x + " = " + y);                       
    }//GEN-LAST:event_intButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        DefaultTableModel fc = (DefaultTableModel) flowchart.getModel();        
        int x[] = flowchart.getSelectedRows();
        for(int i=x.length-1;i>=0;i--){
            fc.removeRow(x[i]);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void runProgramItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runProgramItemActionPerformed
        String[] codeLine = new String[flowchart.getRowCount()];
        int c = 0x2c2;
        int d = 0x00A0;
        for(int x=0;x<flowchart.getRowCount();x++){
            String y = (String) flowchart.getValueAt(x, 0);
            y = y.replaceAll("\\<.*?>", "");
            codeLine[x] = y.replaceAll(Character.toString((char) c), "<");
            codeLine[x] = codeLine[x].replaceAll(Character.toString((char) d), "");
        }
        System.out.println("line count: " + flowchart.getRowCount());
        Compiler com = new Compiler();
        com.compile(codeLine);
        RunProgram rp = new RunProgram();
        rp.setVisible(true);
        rp.run();        
    }//GEN-LAST:event_runProgramItemActionPerformed

    private void ifButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ifButtonActionPerformed
        isEditing = true;
        String ifStatement = "If ";        
        //do{
            String a = JOptionPane.showInputDialog("Input first operand:"
                    + "\nPossible input: Integers, Phrase, Variables (Use $)");          
            ifStatement += a;
            int b = Integer.parseInt(JOptionPane.showInputDialog("Input logical comparator:"
                    + "\n1. == (equals)"
                    + "\n2. != (not equals)" 
                    + "\n3. >  (greater than)"
                    + "\n4. <  (less than)"
                    + "\n5. >= (greater than or equals)"
                    + "\n6. <= (less than or equals)"));
            switch(b){
                case 1:     ifStatement += " == ";      break;         
                case 2:     ifStatement += " != ";      break;
                case 3:     ifStatement += " > ";       break;
                case 4:     ifStatement += " < ";       break;
                case 5:     ifStatement += " >= ";      break;
                case 6:     ifStatement += " <= ";      break;
            }
            a = JOptionPane.showInputDialog("Input second operand:"
                    + "\nPossible input: Integers, Phrase, Variables (Use $)");          
            ifStatement += a;
            /*b = Integer.parseInt(JOptionPane.showInputDialog("Add another condition?\n1. Yes\n2. No"));
            if(b == 2){
                break;
            }
            else{
                b = Integer.parseInt(JOptionPane.showInputDialog("Split condition with?\n1. And\n2. Or"));
                switch(b){
                    case 1:     ifStatement += " AND ";     break;
                    case 2:     ifStatement += " OR ";      break;
                }
            }
        }while(true);*/        
        System.out.println(ifStatement);
        addLine(ifStatement);        
    }//GEN-LAST:event_ifButtonActionPerformed

    private void endifButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endifButtonActionPerformed
        addLine("Endif");        
    }//GEN-LAST:event_endifButtonActionPerformed

    private void elseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elseButtonActionPerformed
        addLine("Else");
    }//GEN-LAST:event_elseButtonActionPerformed

    private void phraseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phraseButtonActionPerformed
        isEditing = true;
        String x = JOptionPane.showInputDialog("Variable name: ");
        String y = JOptionPane.showInputDialog("Value: ");                
        addLine("Phrase " + x + " = " + y );                       
    }//GEN-LAST:event_phraseButtonActionPerformed

    private void newProgramItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProgramItemActionPerformed
        new IDE();
        currentFile = "";
        this.setTitle("EZ IDE - New Program");
        DefaultTableModel fc = (DefaultTableModel) flowchart.getModel();
        for(int x=flowchart.getRowCount()-1;x>=0;x--){
            fc.removeRow(x);
        }
    }//GEN-LAST:event_newProgramItemActionPerformed

    private void saveProgramItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveProgramItemActionPerformed
        try{
            String[] codeLine = new String[flowchart.getRowCount()];
            int c = 0x00A0;
            for(int x=0;x<flowchart.getRowCount();x++){
                String y = (String) flowchart.getValueAt(x, 0);
                codeLine[x] = y.replaceAll("\\<.*?>", "");
                codeLine[x] = codeLine[x].replaceAll(Character.toString((char) c), "");
            }
            String fileExt = ".ez";
            if(currentFile.length() > 0){
                if(currentFile.contains(fileExt)){
                    fileExt = "";
                }
                this.setTitle("EZ IDE - " + currentFile);
                try (PrintWriter writer = new PrintWriter("Programs\\" + currentFile + fileExt, "UTF-8")) {
                    for (String codeLine1 : codeLine) {
                        writer.println(codeLine1);
                    } 
                    JOptionPane.showMessageDialog(this, "File Saved!");
                }
            }
            else{
                JFileChooser choose = new JFileChooser(System.getProperty("user.dir") + "\\Programs\\");
                choose.setDialogTitle("Save");
                int selection = choose.showSaveDialog(flowchart);
                if(selection == JFileChooser.APPROVE_OPTION){
                    currentFile = choose.getSelectedFile().getName();
                    if(currentFile.contains(fileExt)){
                        fileExt = "";
                    }
                    this.setTitle("EZ IDE - " + currentFile);
                    try (PrintWriter writer = new PrintWriter("Programs\\" + currentFile + fileExt, "UTF-8")) {
                        for (String codeLine1 : codeLine) {
                            writer.println(codeLine1);
                        } 
                        JOptionPane.showMessageDialog(this, "File Saved!");
                    }
                }
            }
        }catch(IOException e){

        }catch(Exception e){
            System.out.println(e);
        }      
      
    }//GEN-LAST:event_saveProgramItemActionPerformed

    private void openProgramItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openProgramItemActionPerformed
        insertRB.setSelected(true);        
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir") + "\\Programs\\");       
        DefaultTableModel fc = (DefaultTableModel) flowchart.getModel();
        File file = new File("");
        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();        
        }
        else{}        
        currentFile = file.toString();
        String cf = "";
        for(int x=currentFile.length()-4;x>=0;x--){
            char a = currentFile.charAt(x);
            if(a == '\\'){
                break;
            }
            cf += a;
        }
        String cf1 = "";
        for(int x=cf.length()-1;x>=0;x--){
            char a = cf.charAt(x);
            cf1 += a;
        }    
        currentFile = cf1;
        this.setTitle("EZ IDE - " + currentFile);
        String[] codeLine = new String[1];
        try{
            LineNumberReader lnr = new LineNumberReader(new FileReader(file));
            lnr.skip(Long.MAX_VALUE);
            codeLine = new String[lnr.getLineNumber()+1];
            lnr.close();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            int x = 0;
            do{                
                codeLine[x] = line;
                line = br.readLine();
                x++;
            }while(line != null);
        }catch (FileNotFoundException ex){
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }        
        for(int x=flowchart.getRowCount()-1;x>=0;x--){
            fc.removeRow(x);
        }        
        for(int x=0;x<codeLine.length-1;x++) {
            addLine(codeLine[x]);
        }
    }//GEN-LAST:event_openProgramItemActionPerformed

    private void insertAboveRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertAboveRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertAboveRBActionPerformed

    private void functionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_functionButtonActionPerformed
        isEditing = true;
        String x = JOptionPane.showInputDialog("Function name: ");
        if(x.equals("main")){
            addLine("Function " + x);
            return;
        }
        String y;
        int a = JOptionPane.showConfirmDialog(this, "Does this Function takes Paramenters?", "Function definition", JOptionPane.YES_NO_OPTION);
        if(a == JOptionPane.YES_OPTION){
            y = " receives ";
            a = Integer.parseInt(JOptionPane.showInputDialog("How many parameters?"));
            for(int i=0;i<a;i++){
                int b = Integer.parseInt(JOptionPane.showInputDialog("Enter data type for parameter #" + (i+1)
                        + "\n1. Integer\n2. Phrase\n3. Decimal"));
                switch(b){
                    case 1:
                        y += "Integer ";
                        break;
                    case 2:
                        y += "Phrase ";
                        break;
                    case 3:
                        y += "Decimal ";
                    }
                y += JOptionPane.showInputDialog("Enter parameter #" + (i+1));
                if(i < a - 1){
                    y += ", ";
                }
            }
            addLine("Function " + x + y);
        }
        else{
            addLine("Function " + x);
        }        
    }//GEN-LAST:event_functionButtonActionPerformed

    private void cutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutItemActionPerformed
        DefaultTableModel fc = (DefaultTableModel) flowchart.getModel();        
        clipBoard = new String[flowchart.getSelectedRows().length];
        int [] sel = flowchart.getSelectedRows();
        int c = 0x00A0;
        for(int i=0;i<sel.length;i++){
            clipBoard[i] = (String) flowchart.getValueAt(sel[i], 0);
            clipBoard[i] = clipBoard[i].replaceAll("\\<.*?>", "");
            clipBoard[i] = clipBoard[i].replaceAll(Character.toString((char) c), "");
        }        
        for(int i=sel.length-1;i>=0;i--){
            fc.removeRow(sel[i]);
        }
    }//GEN-LAST:event_cutItemActionPerformed

    private void pasteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteItemActionPerformed
        for (String x : clipBoard) {
            addLine(x);
        }
    }//GEN-LAST:event_pasteItemActionPerformed

    private void copyItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyItemActionPerformed
        clipBoard = new String[flowchart.getSelectedRows().length];
        int [] sel = flowchart.getSelectedRows();
        int c = 0x00A0;
        for(int i=0;i<sel.length;i++){
            clipBoard[i] = (String) flowchart.getValueAt(sel[i], 0);
            clipBoard[i] = clipBoard[i].replaceAll("\\<.*?>", "");
            clipBoard[i] = clipBoard[i].replaceAll(Character.toString((char) c), "");
        }
    }//GEN-LAST:event_copyItemActionPerformed

    private void endfuncButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endfuncButtonActionPerformed
        addLine("Endfunc");
    }//GEN-LAST:event_endfuncButtonActionPerformed

    private void callButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callButtonActionPerformed
        isEditing = true;
        String x = JOptionPane.showInputDialog("Function name: ");        
        String y = "";
        int a = JOptionPane.showConfirmDialog(this, "Does this Call takes Arguments?", "Call", JOptionPane.YES_NO_OPTION);
        if(a == JOptionPane.YES_OPTION){
            y += " sends ";
            a = Integer.parseInt(JOptionPane.showInputDialog("How many arguments?"));
            for(int i=0;i<a;i++){
                y += JOptionPane.showInputDialog("Enter argument #" + (i+1));
                if(i < a - 1){
                    y += ", ";
                }
            }            
        }
        a = JOptionPane.showConfirmDialog(this, "Will function '" + x + "' be returning any value?", "Call", JOptionPane.YES_NO_OPTION);
        if(a == JOptionPane.YES_OPTION){
            y += " receives " + JOptionPane.showInputDialog("Store to: (use a variable)");
        }        
        addLine("Call " + x + y);
    }//GEN-LAST:event_callButtonActionPerformed

    private void forButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forButtonActionPerformed
        isEditing = true;
        String x = JOptionPane.showInputDialog("Input identifier to use in loop: ");        
        String y = JOptionPane.showInputDialog("Input initial value for " + x +": (Use $ to use a variable)");        
        String z = JOptionPane.showInputDialog("Input limit: (Use $ to use a variable)");        
        String zz = JOptionPane.showInputDialog("Input step: (Use $ to use a variable)");        
        addLine("For " + x + " = " + y + " to " + z + " step " + zz);
    }//GEN-LAST:event_forButtonActionPerformed

    private void endforButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endforButtonActionPerformed
        addLine("Endfor");
    }//GEN-LAST:event_endforButtonActionPerformed

    private void AboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutMenuItemActionPerformed
        // TODO add your handling code here:
        About abt = new About();
        abt.setVisible(true);

    }//GEN-LAST:event_AboutMenuItemActionPerformed

    private void commentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentButtonActionPerformed
        isEditing = true;
        addLine("Comment: " + JOptionPane.showInputDialog("Input comment:"));
    }//GEN-LAST:event_commentButtonActionPerformed

    private void EZMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EZMenuItemActionPerformed
        // TODO add your handling code here:
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
    }//GEN-LAST:event_EZMenuItemActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        isEditing = true;
        String x = JOptionPane.showInputDialog("First number: (put '$' before the variable that you want to use)");
        String y = JOptionPane.showInputDialog("Second number: (put '$' before the variable that you want to use)");
        String z = JOptionPane.showInputDialog("Store to: ");
        addLine("Add " + x + " + " + y + " to " + z);
    }//GEN-LAST:event_addButtonActionPerformed

    private void subButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subButtonActionPerformed
        isEditing = true;
        String x = JOptionPane.showInputDialog("First number: (put '$' before the variable that you want to use)");
        String y = JOptionPane.showInputDialog("Second number: (put '$' before the variable that you want to use)");
        String z = JOptionPane.showInputDialog("Store to: ");
        addLine("Sub " + x + " - " + y + " to " + z);
    }//GEN-LAST:event_subButtonActionPerformed

    private void mulButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mulButtonActionPerformed
        isEditing = true;
        String x = JOptionPane.showInputDialog("First number: (put '$' before the variable that you want to use)");
        String y = JOptionPane.showInputDialog("Second number: (put '$' before the variable that you want to use)");
        String z = JOptionPane.showInputDialog("Store to: ");
        addLine("Mul " + x + " * " + y + " to " + z);
    }//GEN-LAST:event_mulButtonActionPerformed

    private void divButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divButtonActionPerformed
        isEditing = true;
        String x = JOptionPane.showInputDialog("First number: (put '$' before the variable that you want to use)");
        String y = JOptionPane.showInputDialog("Second number: (put '$' before the variable that you want to use)");
        String z = JOptionPane.showInputDialog("Store to: ");
        addLine("Div " + x + " / " + y + " to " + z);
    }//GEN-LAST:event_divButtonActionPerformed

    private void powButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powButtonActionPerformed
        isEditing = true;
        String x = JOptionPane.showInputDialog("First number: (put '$' before the variable that you want to use)");
        String y = JOptionPane.showInputDialog("Second number: (put '$' before the variable that you want to use)");
        String z = JOptionPane.showInputDialog("Store to: ");
        addLine("Pow " + x + " ^ " + y + " to " + z);
    }//GEN-LAST:event_powButtonActionPerformed

    private void getButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getButtonActionPerformed
        isEditing = true;
        String x = JOptionPane.showInputDialog("Enter variable name to be scanned");
        addLine("Get " + x);
    }//GEN-LAST:event_getButtonActionPerformed

    private void sayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sayButtonActionPerformed
        isEditing = true;
        String x = JOptionPane.showInputDialog("Say: (put '$' before the variable that you want to print)");
        addLine("Say " + x);
    }//GEN-LAST:event_sayButtonActionPerformed

    private void incrementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incrementButtonActionPerformed
        isEditing = true;
        String z = JOptionPane.showInputDialog("Variable to be incremented: ");
        addLine("Inc " + z);
    }//GEN-LAST:event_incrementButtonActionPerformed

    private void decrementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decrementButtonActionPerformed
        isEditing = true;    
        String z = JOptionPane.showInputDialog("Variable to be decremented: ");
        addLine("Dec " + z);
    }//GEN-LAST:event_decrementButtonActionPerformed

    private void moveUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveUpButtonActionPerformed
        DefaultTableModel fc = (DefaultTableModel) flowchart.getModel();
        int row = flowchart.getSelectedRow();
        int c = 0x00A0;
        String text = (String) flowchart.getValueAt(row, 0);
        text = text.replaceAll(Character.toString((char) c), "");
        Object[] txt = {text};
        if(flowchart.getSelectedRow() > 0){
            fc.removeRow(row);
            fc.insertRow(row - 1, txt);
            flowchart.setRowSelectionInterval(row-1, row-1);
        }
    }//GEN-LAST:event_moveUpButtonActionPerformed

    private void moveDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveDownButtonActionPerformed
        DefaultTableModel fc = (DefaultTableModel) flowchart.getModel();
        int row = flowchart.getSelectedRow();
        int c = 0x00A0;
        String text = (String) flowchart.getValueAt(row, 0);
        text = text.replaceAll(Character.toString((char) c), "");
        Object[] txt = {text};
        if(flowchart.getSelectedRow() < flowchart.getRowCount() - 1){
            fc.removeRow(row);
            fc.insertRow(row + 1, txt);
            flowchart.setRowSelectionInterval(row + 1, row + 1);
        }
    }//GEN-LAST:event_moveDownButtonActionPerformed

    private void floatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floatButtonActionPerformed
        
        isEditing = true;
        String x = JOptionPane.showInputDialog("Variable name: ");
        String y = JOptionPane.showInputDialog("Value: ");
        addLine("Decimal " + x + " = " + y);
    }//GEN-LAST:event_floatButtonActionPerformed

    private void linebreakButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linebreakButtonActionPerformed
        addLine("LineBreak");
    }//GEN-LAST:event_linebreakButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Return a value? (use '$' to use a variable)", "Return", JOptionPane.YES_NO_OPTION);
        if(a == JOptionPane.YES_OPTION){
            addLine("Return " + JOptionPane.showInputDialog("Input return value"));
        }
        else
            addLine("Return");
    }//GEN-LAST:event_returnButtonActionPerformed

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignButtonActionPerformed
        String x = JOptionPane.showInputDialog("Input Variable to assign value to");
        String y = JOptionPane.showInputDialog("Input Value");
        addLine("Assign " + y + " to " + x);
    }//GEN-LAST:event_assignButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
     System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    public void addLine(String line){
        DefaultTableModel fc = (DefaultTableModel) flowchart.getModel();
        int c = 0x2c2;
        line = line.replaceAll("<",Character.toString((char) c));
        line = addColor(line);        
        Object[] row = {line};            
        if(editRB.isSelected()){           
            fc.setValueAt(line ,flowchart.getSelectedRow(), 0);
        }
        if(insertRB.isSelected()){
            fc.addRow(row);
        }
        if(insertAboveRB.isSelected()){
            fc.insertRow(flowchart.getSelectedRow(), row);
        }
        if(insertBelowRB.isSelected()){
            fc.insertRow(flowchart.getSelectedRow()+1, row);            
        }
        isEditing = false;
    }
    
    private static String currentCom = ""; // para sa mga functions na nakakapag-unindent like endif endfor else endfunc
    
    public String addColor(String line){
        String[] lineR = line.split(" ");                
        switch(lineR[0]){
            case "Say":                
                line = "<html>" + indent() + "<font color=\"red\">" + lineR[0] + "</font><i color=\"orange\"> " + line.substring(4) +"</i>";
                break;
            case "Get":                
                line = "<html>" + indent() + "<font color=\"red\">" + lineR[0] + "</font><font color=\"green\"> " + line.substring(4) +"</font>";
                break;
            case "Integer":
                line = "<html>" + indent() + "<font color=\"blue\">" + lineR[0] + "</font><font color=\"green\"> " + lineR[1] + "</font>"
                        + "<font color=\"black\"> = " + lineR[3] +"</font>";
                break;
            case "Decimal":
                line = "<html>" + indent() + "<font color=\"blue\">" + lineR[0] + "</font><font color=\"green\"> " + lineR[1] + "</font>"
                        + "<font color=\"black\"> = " + lineR[3] +"</font>";
                break;
            case "Phrase":
                line = "<html>" + indent() + "<font color=\"blue\">" + lineR[0] + "</font><font color=\"green\"> " + lineR[1] + "</font>"
                        + "<font color=\"black\"> = " + line.substring(line.indexOf("=")+1) +"</font>";
                break;
            case "If":                
                line = "<html>" + indent() + "<font color=\"blue\">" + lineR[0] + "</font><font color=\"green\"> " + lineR[1] + "</font><font color=\"black\"> "
                        + lineR[2] + "</font><font color=\"green\"> " + lineR[3] + "</font>";
                break;
            case "Else":
                currentCom = "Else";
                line = "<html>" + indent() + "<font color=\"blue\">Else</font>";
                break;
            case "Endif":
                currentCom = "Endif";
                line = "<html>" + indent() + "<font color=\"blue\">Endif</font>";
                break;
            case "Add":
                line = "<html>" + indent() + "<font color=\"purple\">" +  lineR[0] + "</font><font color=\"black\"> " + lineR[1] + " + " 
                        + lineR[3] +" to</font><font color=\"green\"> " + lineR[5] + "</font>";
                break;
            case "Sub":
                line = "<html>" + indent() + "<font color=\"purple\">" + lineR[0] + "</font><font color=\"black\"> " + lineR[1] + " - " 
                        + lineR[3] +" to</font><font color=\"green\"> " + lineR[5] + "</font>";
                break;
            case "Mul":
                line = "<html>" + indent() + "<font color=\"purple\">" + lineR[0] + "</font><font color=\"black\"> " + lineR[1] + " * " 
                        + lineR[3] +" to</font><font color=\"green\"> " + lineR[5] + "</font>";
                break;
            case "Div":
                line = "<html>" + indent() + "<font color=\"purple\">" + lineR[0] + "</font><font color=\"black\"> " + lineR[1] + " / " 
                        + lineR[3] +" to</font><font color=\"green\"> " + lineR[5] + "</font>";
                break;
            case "Function":                
                line = "<html>" + indent() + "<font color=\"blue\">" + lineR[0] + "</font><b> " + line.substring(9) + "</b>";
                break;
            case "Endfunc":
                currentCom = "Endfunc";
                line = "<html>" + indent() + "<font color=\"blue\">Endfunc</font>";
                break;
            case "Call":
                line = "<html>" + indent() + "<font color=\"blue\">" + lineR[0] + "</font><b> " + line.substring(5) + "</b>";
                break;
            case "For":                
                line = "<html>" + indent() + "<font color=\"blue\">" + lineR[0] + "</font><font color=\"green\"> " + lineR[1] + "</font> = "
                        + lineR[3] + " to <fnt color=\"green\">" + lineR[5] + "</font> step " + lineR[7];
                break;
            case "Endfor":
                currentCom = "Endfor";
                line = "<html>" + indent() + "<font color=\"blue\">Endfor</font>";
                break;
            case "Comment:":
                line = "<html>" + indent() + "<font color=\"blue\">Comment: </font><font color = \"gray\">" + line.substring(9) + "</font>";
                break;
            case "Pow":
                line = "<html>" + indent() + "<font color=\"purple\">" + lineR[0] + "</font><font color=\"black\"> " + lineR[1] + " ^ " 
                        + lineR[3] +" to</font><font color=\"green\"> " + lineR[5] + "</font>"; 
                break;
            case "Inc":
                line = "<html>" + indent() + "<font color=\"purple\">" + lineR[0] + " </font><font color = \"green\">" + line.substring(4) + "</font>";
                break;   
            case "Dec":
                line = "<html>" + indent() + "<font color=\"purple\">" + lineR[0] + " </font><font color = \"green\">" + line.substring(4) + "</font>";
                break;    
            case "Sqrt":                
                line = "<html>" + indent() + "<font color=\"purple\">" + lineR[0] + "</font><font color=\"black\"> of "
                        + lineR[2] + " to </font><font color=\"green\">" + lineR[4] + "</font>";
                break;
            case "LineBreak":
                line = "<html>" + indent() + "<font color=\"red\">" + lineR[0] + " </font>";
                break; 
            case "Return":
                line = "<html>" + indent() + "<font color=\"blue\">" + lineR[0] + "</font><font> " + lineR[1] + "</font>";
                break;
            case "Assign":
                line = "<html>" + indent() + "<font color=\"blue\">" + lineR[0] + "</font><font> " + lineR[1] + "</font> to <font color =\"green\">" + lineR[3] + "</font>";
                break;
        }        
        return line + "</html>";
    }
    
    public String indent(){    
        String indentSize = "";        
        try{
            Stack<String> indention = new Stack();        
            Stack ififif = new Stack();
            int line = 0;
            String lastCom = "";
            if(editRB.isSelected()){           
                line =  flowchart.getSelectedRow();
            }
            if(insertRB.isSelected()){
                line = flowchart.getRowCount();
            }
            if(insertAboveRB.isSelected()){
                line =  flowchart.getSelectedRow();
            }
            if(insertBelowRB.isSelected()){
                line =  flowchart.getSelectedRow() + 1;
            }        
            for(int x=0;x<line;x++){
                int c = 0X00A0;
                String y = (String) flowchart.getValueAt(x, 0);                                    
                y = y.replaceAll("\\<.*?>", "");            
                for(int z=0;z<y.length();z++){
                    if(y.charAt(z) != (char) c){
                        y = y.substring(z);
                        break;
                    }
                }
                String[] command = y.split(" ");
                String p = Character.toString((char) c);
                p += p + p + p + p + p + p + p;              
                if(lastCom.equals("Endif")){
                    indention.pop();                 
                    lastCom = "";
                }
                switch(command[0]){
                    case "Function":    indention.push(p);  break;
                    case "For":         indention.push(p);  break;
                    case "If":          
                        ififif.push(0);
                        indention.push(p);  
                        break;
                    case "Else":        
                        if(currentCom.equals("Else")){}
                        else{
                            if(lastCom.equals("Else")){
                                indention.pop();
                                lastCom = "";
                            }
                            else{
                                indention.push(p);  
                            }
                        }
                        break;                    
                    case "Endfunc":     indention.removeAllElements();  break;
                    case "Endfor":      indention.pop();    break;
                    case "Endif":    
                        ififif.pop();
                        if(currentCom.equals("Endif")){                        
                            indention.pop();
                        }                    
                        indention.pop();
                        break;
                }
                if(command[0].equals("Else") || command[0].equals("Endif")){
                    if(lastCom.equals("Endif")){
                        indention.pop();                 
                    }
                    lastCom = command[0];
                }
            }        
            if(currentCom.equals("Else") || lastCom.equals("Else") || currentCom.equals("Endfor")){
                indention.pop();            
            }       
            if(currentCom.equals("Endif") && !ififif.isEmpty()){
                indention.pop();            
            }
            if(currentCom.equals("Endfunc")){
                indention.removeAllElements();
            }
            while(!indention.isEmpty()){
                indentSize += indention.pop();
            }   
            currentCom = "";
        }catch(Exception e){
            
        }
        return indentSize;
    }
    
    public void update(){//this ethod is called every 10 seconds
        int rb = 1;//radiobutton        
        int[] sr = flowchart.getSelectedRows();//selected rows
        if(editRB.isSelected()){           
            rb = 0;            
        }
        if(insertRB.isSelected()){
            rb = 1;
        }
        if(insertAboveRB.isSelected()){
            rb = 2;
        }
        if(insertBelowRB.isSelected()){
            rb = 3;
        }
        insertRB.setSelected(true);
        DefaultTableModel fc = (DefaultTableModel) flowchart.getModel();
        int sc = scroll.getVerticalScrollBar().getValue();
        int y = flowchart.getRowCount();        
        String[] codeLine = new String[y];
        for(int x=0;x<y;x++){//get all codes
            codeLine[x] = (String) flowchart.getValueAt(x, 0);
            int c = 0x00A0;
            codeLine[x] = codeLine[x].replaceAll("\\<.*?>", "");
            codeLine[x] = codeLine[x].replaceAll(Character.toString((char) c), "");                        
        }
        for(int x=y-1;x>=0;x--){//delete all lines
            fc.removeRow(x);
        }
        for(int x=0;x<y;x++){//restore deleted lines
            addLine(codeLine[x]);
        }
        flowchart.setRowSelectionInterval(sr[0], sr[sr.length - 1]);
        if(rb == 0){
            editRB.setSelected(true);
        }
        if(rb == 1){
            insertRB.setSelected(true);
        }
        if(rb == 2){
            insertAboveRB.setSelected(true);
        }
        if(rb == 3){
            insertBelowRB.setSelected(true);
        }
        scroll.getViewport().setViewPosition(new Point(0, sc));
    }
    public void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("6.png")));
    }
    
    public static void main(String args[]) {
        Loading load = new Loading();
        load.setVisible(true);
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        try{
            Thread.sleep(4500);
        }
        catch(Exception e){}
        
        IDE ide = new IDE();
        load.setVisible(false);
        ide.setVisible(true);
        
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                DefaultTableModel ln = (DefaultTableModel) ide.lineNumber.getModel();
                ln.setRowCount(ide.flowchart.getRowCount());
                for(int i=0;i<ln.getRowCount();i++){
                    ln.setValueAt(i + 1, i, 0);
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
        
        while(true){
            try{
                Thread.sleep(2500);                
                if(!isEditing){                    
                    ide.update();
                }
                
            }catch(Exception e){
                
            }
        }
        /*ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable(){
           @Override 
           public void run(){               
               ide.update();
           }
        }, 0, 2, TimeUnit.SECONDS);*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutMenuItem;
    private javax.swing.JMenuItem EZMenuItem;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton addButton;
    private javax.swing.JButton assignButton;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel builtInsPanel;
    private javax.swing.JScrollPane builtInsScroll;
    private javax.swing.JButton callButton;
    private javax.swing.JPanel commandPanel;
    private javax.swing.JButton commentButton;
    private javax.swing.JMenuItem copyItem;
    private javax.swing.JMenuItem cutItem;
    private javax.swing.JButton decrementButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton divButton;
    private javax.swing.JMenu editMenu;
    private javax.swing.JRadioButton editRB;
    private javax.swing.JButton elseButton;
    private javax.swing.JButton endforButton;
    private javax.swing.JButton endfuncButton;
    private javax.swing.JButton endifButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton floatButton;
    private javax.swing.JTable flowchart;
    private javax.swing.JButton forButton;
    private javax.swing.JButton functionButton;
    private javax.swing.JButton getButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton ifButton;
    private javax.swing.JPanel importableFunctionPanel;
    private javax.swing.JButton incrementButton;
    private javax.swing.JRadioButton insertAboveRB;
    private javax.swing.JRadioButton insertBelowRB;
    private javax.swing.JRadioButton insertRB;
    private javax.swing.JButton intButton;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable lineNumber;
    private javax.swing.JButton linebreakButton;
    private javax.swing.JPanel mathPanel;
    private javax.swing.JButton moveDownButton;
    private javax.swing.JButton moveUpButton;
    private javax.swing.JButton mulButton;
    private javax.swing.JMenuItem newProgramItem;
    private javax.swing.JMenuItem openProgramItem;
    private javax.swing.JMenuItem pasteItem;
    private javax.swing.JButton phraseButton;
    private javax.swing.JButton powButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JMenu runMenu;
    private javax.swing.JMenuItem runProgramItem;
    private javax.swing.JMenuItem saveProgramItem;
    private javax.swing.JButton sayButton;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPanel standardPanel;
    private javax.swing.JButton subButton;
    // End of variables declaration//GEN-END:variables
}
