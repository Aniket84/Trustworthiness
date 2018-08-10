/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TruthFinder;

/**
 *
 * @author MANALI
 */
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//import javax.lang.model.element.Element;
//import javax.lang.model.util.Elements;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jsoup.Jsoup;
//import javax.swing.text.Document;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rcm.awt.TabPanel;
import websphinx.*;
import websphinx.workbench.*;

public class MainPage extends javax.swing.JFrame implements CrawlListener {

    File file;
    StringBuilder str = new StringBuilder(" ");
    File fout = new File("G:\\Work_Space\\MyFinalProject\\out.txt");
    BufferedReader in;
    Crawler crawler;
    String currentFilename = "";
   

   
    WebGraph graph;
    WebOutline outline;
    EventLog logger;
    Panel simplePanel;
    Panel buttonpanel;
    CrawlerEditor2 crawlerEditor2;
    ActionEditor2 actionEditor2;
    SimpleCrawlerEditor2 simpleCrawlerEditor2;
    boolean advancedMode = false;

    public MainPage() {
        makeDefaultCrawler();
        return;

    }

    void init() {
        initComponents();
        jLabel4.setText(" ");
        BackgroundPanel.setVisible(false);
        WebPagePanel.setVisible(true);
        ShowDataPanel.setVisible(false);
        ComparisionPanel.setVisible(false);
        web1.setVisible(true);
        web2.setVisible(true);
//                WorkBenchCrawl w= new WorkBenchCrawl();
//            web2.add(w.makeFrame());

//        crawler = new Crawler();
//
//        Browser browser = Context.getBrowser();
//
//     
//       
//simplePanel = makeSimplePanel();
////        
//        crawlTab.add(simplePanel);
//          crawlTab.setTitleAt(0,"Truth Finder Web Crawler");
//          
//        Component cmp1 = add(vizPane25l = new WorkbenchVizPanel25(this));
//
//     jTabbedPane1.add(cmp1);
//        graph = new WebGraph();
//        graph.setBackground(Color.white);
//        if (browser != null) {
//            graph.addLinkViewListener(browser);
//        }
//        vizPane25l.addTabPanel("Graph", true, graph);
//
//       
//        outline = new WebOutline();
//        outline.setBackground(Color.white);
//        if (browser != null) {
//            outline.addLinkViewListener(browser);
//        }
//        vizPane25l.addTabPanel("Outline", true, outline);
//
//        logger = new EventLog();

        setCrawler(crawler);
    }

    

    public void setCrawler(Crawler _crawler) {
        if (crawler != _crawler) {
            if (crawler != null) {
                clear();
                disconnectVisualization(crawler, this, false);
                disconnectVisualization(crawler, graph, true);
                disconnectVisualization(crawler, outline, true);

            }

            connectVisualization(_crawler, this, false);
            connectVisualization(_crawler, graph, true);
            connectVisualization(_crawler, outline, true);

        }

        crawler = _crawler;


        // set configuration


  //      simpleCrawlerEditor.setCrawler(crawler);


    }

    public Crawler getCrawler() {
        return crawler;
    }

    public void start() {
        configureCrawler();

        if (crawler.getState() == CrawlEvent.STOPPED) {
            crawler.clear();
        }

        Thread thread = new Thread(crawler, crawler.getName());
        thread.setDaemon(true);
        thread.start();

    }

    public void stop() {
        crawler.stop();
    }

    public void pause() {
        crawler.pause();
    }

    public void clear() {
        crawler.clear();
    }

    protected void finalize() {
        // FIX: dispose of frames
    }

    void configureCrawler() {

       // simpleCrawlerEditor.getCrawler();
    }

    public void refresh() {
      //  graph.updateClosure(crawler.getCrawledRoots());
       // outline.updateClosure(crawler.getCrawledRoots());
    }

    void connectVisualization(Crawler crawler, Object viz, boolean linksToo) {
        if (viz instanceof CrawlListener) {
            crawler.addCrawlListener((CrawlListener) viz);
        }
        if (linksToo && viz instanceof LinkListener) {
            crawler.addLinkListener((LinkListener) viz);
        }
    }

    void disconnectVisualization(Crawler crawler, Object viz, boolean linksToo) {
        if (viz instanceof CrawlListener) {
            crawler.removeCrawlListener((CrawlListener) viz);
        }
        if (linksToo && viz instanceof LinkListener) {
            crawler.removeLinkListener((LinkListener) viz);
        }
    }

    void showVisualization(Object viz) {
        if (viz == graph) {
            graph.start();
        }
    }

    void hideVisualization(Object viz) {
        if (viz == graph) {
            graph.stop();
        }
    }

    private Panel makeSimplePanel() {
        return simpleCrawlerEditor2 = new SimpleCrawlerEditor2();
    }

    private static Crawler makeDefaultCrawler() {
        Crawler c = new Crawler();
        c.setDomain(Crawler.SUBTREE);
        return c;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        db = new javax.swing.JFileChooser();
        titlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sidePanel = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        WebPagePanel = new javax.swing.JPanel();
        web1 = new javax.swing.JPanel();
        web2 = new javax.swing.JPanel();
        BackgroundPanel = new javax.swing.JPanel();
        ShowDataPanel = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        OpenDataPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        ComparisionPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTabDataGene = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titlePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(109, 11, 255));
        jLabel1.setText("Truth Discovery with Multiple Conflicting Information Providers on the Web ");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(titlePanelLayout.createSequentialGroup()
                    .addGap(0, 166, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 166, Short.MAX_VALUE)))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
            .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(titlePanelLayout.createSequentialGroup()
                    .addGap(0, 9, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 9, Short.MAX_VALUE)))
        );

        sidePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton11.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(109, 11, 255));
        jButton11.setText("Webpage Processig");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(109, 11, 255));
        jButton14.setText("Show Data");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(109, 11, 255));
        jButton9.setText("TruthFinder");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(109, 11, 255));
        jButton8.setText("Clear");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(109, 11, 255));
        jButton12.setText("Exit");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jButton11)
                .addGap(18, 18, 18)
                .addComponent(jButton14)
                .addGap(29, 29, 29)
                .addComponent(jButton9)
                .addGap(30, 30, 30)
                .addComponent(jButton8)
                .addGap(36, 36, 36)
                .addComponent(jButton12)
                .addContainerGap(214, Short.MAX_VALUE))
        );

        WebPagePanel.setBackground(new java.awt.Color(255, 255, 255));
        WebPagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        web2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout web2Layout = new javax.swing.GroupLayout(web2);
        web2.setLayout(web2Layout);
        web2Layout.setHorizontalGroup(
            web2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1003, Short.MAX_VALUE)
        );
        web2Layout.setVerticalGroup(
            web2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout web1Layout = new javax.swing.GroupLayout(web1);
        web1.setLayout(web1Layout);
        web1Layout.setHorizontalGroup(
            web1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(web2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        web1Layout.setVerticalGroup(
            web1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(web2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout WebPagePanelLayout = new javax.swing.GroupLayout(WebPagePanel);
        WebPagePanel.setLayout(WebPagePanelLayout);
        WebPagePanelLayout.setHorizontalGroup(
            WebPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(web1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        WebPagePanelLayout.setVerticalGroup(
            WebPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(web1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        BackgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        BackgroundPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BackgroundPanel.setLayout(null);

        ShowDataPanel.setBackground(new java.awt.Color(255, 255, 255));
        ShowDataPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton15.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(109, 11, 255));
        jButton15.setText("Open Data");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton16.setForeground(new java.awt.Color(109, 11, 255));
        jButton16.setText("Retrive Data");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout OpenDataPanelLayout = new javax.swing.GroupLayout(OpenDataPanel);
        OpenDataPanel.setLayout(OpenDataPanelLayout);
        OpenDataPanelLayout.setHorizontalGroup(
            OpenDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(OpenDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(OpenDataPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        OpenDataPanelLayout.setVerticalGroup(
            OpenDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
            .addGroup(OpenDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(OpenDataPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout ShowDataPanelLayout = new javax.swing.GroupLayout(ShowDataPanel);
        ShowDataPanel.setLayout(ShowDataPanelLayout);
        ShowDataPanelLayout.setHorizontalGroup(
            ShowDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShowDataPanelLayout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addGap(96, 96, 96)
                .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(261, 261, 261))
            .addGroup(ShowDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OpenDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ShowDataPanelLayout.setVerticalGroup(
            ShowDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShowDataPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(ShowDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton16))
                .addGap(18, 18, 18)
                .addComponent(OpenDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        ComparisionPanel.setBackground(new java.awt.Color(255, 255, 255));
        ComparisionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Overall Trustworthiness :");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Trustworthiness of Book Name by TruthFinder");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel2)
                .addContainerGap(323, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabDataGene.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr No.", "Book Name", "Auther Name", "Trustworthiness"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTabDataGene.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTabDataGene.setFillsViewportHeight(true);
        jScrollPane6.setViewportView(jTabDataGene);

        jLabel4.setText("Overall Trustworthiness :");

        javax.swing.GroupLayout ComparisionPanelLayout = new javax.swing.GroupLayout(ComparisionPanel);
        ComparisionPanel.setLayout(ComparisionPanelLayout);
        ComparisionPanelLayout.setHorizontalGroup(
            ComparisionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComparisionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ComparisionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addGap(21, 21, 21))
            .addGroup(ComparisionPanelLayout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        ComparisionPanelLayout.setVerticalGroup(
            ComparisionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComparisionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(ComparisionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1027, Short.MAX_VALUE))
            .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(240, Short.MAX_VALUE)
                    .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(240, 240, 240)
                    .addComponent(WebPagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(239, 239, 239)
                    .addComponent(ShowDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(241, 241, 241)
                    .addComponent(ComparisionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(WebPagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(ShowDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(ComparisionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        BackgroundPanel.setVisible(false);
        //WebPagePanel.resize(100, 100);
        WebPagePanel.setVisible(true);
        ShowDataPanel.setVisible(false);
        ComparisionPanel.setVisible(false); 
        web1.setVisible(true);
        web1.resize(930, 490);
        web2.resize(930,490);
        web2.setVisible(true);
        WorkBenchCrawl w= new WorkBenchCrawl();
            web2.add(w.makeFrame());
            refresh();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        web1.setVisible(false);
        web2.setVisible(false);

        BackgroundPanel.setVisible(false);
        WebPagePanel.setVisible(false);
        ShowDataPanel.setVisible(true);
        ComparisionPanel.setVisible(false);
   }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        BackgroundPanel.setVisible(false);
        WebPagePanel.setVisible(false);
        ShowDataPanel.setVisible(false);
        web1.setVisible(false);
        web2.setVisible(false);
        ComparisionPanel.setVisible(true);
        try {
            in = new BufferedReader(new FileReader("C:\\Users\\Asus\\Desktop\\out.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        int linecount = jTextArea1.getLineCount();
        String line, book, srno, auth;

        int i;
        i = 1;
        DefaultTableModel edtm = (DefaultTableModel) jTabDataGene.getModel();

        int rowcount = edtm.getRowCount();
        for (int j = rowcount - 1; j > 0; j--) {
            edtm.removeRow(j);
        }
        try {
            while ((line = in.readLine()) != null) {
//               
                srno = line;
//                    
                book = in.readLine();
//                     
                auth = in.readLine();
                Object[] row = {i, book, auth};
                edtm.addRow(row);
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        //     jTabDataGene.setSelectionMode(1);
        jTabDataGene.setColumnSelectionAllowed(true);
        jTabDataGene.setRowSelectionAllowed(true);

        int nocol = edtm.getRowCount();
        double f = 0, total = 0, overall = 0, temp;
        int j;
        String Bname, auther;
        String Bname2, auther2;
        int stat;
        double trust;

        for (i = 0; i < nocol; i++) {
            f = 0;
            total = 0;
            Bname = (String) edtm.getValueAt(i, 1);
//            stat = (Integer) edtm.getValueAt(i, 6);
//
//            edtm.setValueAt(1, i, 6);
            auther = (String) edtm.getValueAt(i, 2);
            for (j = 0; j < nocol; j++) {
                Bname2 = (String) edtm.getValueAt(j, 1);
                auther2 = (String) edtm.getValueAt(j, 2);
                if (Bname.trim().compareToIgnoreCase(Bname2.trim()) == 0 && auther.trim().compareToIgnoreCase(auther2.trim()) == 0) {
                    f = f + 1;
                    total = total + 1;
                    // edtm.setValueAt(1, i, 6);

                } else if (Bname.trim().compareToIgnoreCase(Bname2.trim()) == 0 && auther.trim().compareToIgnoreCase(auther2.trim()) != 0) {

                    total = total + 1;
                    // edtm.setValueAt(1, i, 6);
                }

            }

            trust = (1 - f / total)*100;

            edtm.setValueAt(trust, i, 3);
        }
            temp=0;
        for (i = 0; i < nocol; i++) {
            temp = (Double) edtm.getValueAt(i, 3);
            overall = overall + temp;
        }

        overall = (overall / nocol);
      //  overall=overall;
        String str1 = Double.toString(overall);
        jLabel4.setText(str1);
        fout.deleteOnExit();
        

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        BackgroundPanel.setVisible(true);
        WebPagePanel.setVisible(false);
        ShowDataPanel.setVisible(false);
        ComparisionPanel.setVisible(false);
        web1.setVisible(false);
        web2.setVisible(false);

        // TODO add your handling code here:
  }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        System.exit(0);      // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
//        OpenDataPanel.setVisible(true);
//        RetrieveDataPanel.setVisible(false);
        // TODO add your handling code here:

        FileFilter ft = new FileNameExtensionFilter("Text Files", "txt", "html");
        db.addChoosableFileFilter(ft);

        int returnVal = (int) db.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = db.getSelectedFile();
            String file_name = file.toString();
            try {
                // What to do with the file, e.g. display it in a TextArea
                jTextArea1.read(new FileReader(file.getAbsolutePath()), null);
            } catch (IOException ex) {
                System.out.println("problem accessing file" + file.getAbsolutePath());
            }
//                JOptionPane.showMessageDialog(FormObjects.this, file_name);
        }


    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String html;
        html = jTextArea1.getText();
        Document doc = (Document) Jsoup.parse(html);
        // jTextArea1.setText(Jsoup.parse(html));
//        Element table = (Element) doc.select("table").first();
//         Iterator iterator = doc.select("td").iterator();
//        while(iterator.hasNext()){
//            System.out.println("text : "+iterator.next()); //kolom -1
//            System.out.println("text : "+iterator.next()); //kolom -2
//           // table.
        jTextArea1.setText(null);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fout);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        //doc = Jsoup.connect(params[0]).get();
        Element tableElement = doc.select("table").first();

        Elements tableRows = tableElement.select("tr");
        for (Element row : tableRows) {
            Elements cells = row.select("td");
            if (cells.size() > 0) {
                //  System.out.println(cells.get(0).text()+"; "+cells.get(1).text()+"; "+cells.get(2).text()+"; ");
                jTextArea1.append(cells.get(0).text() + "  " + cells.get(1).text() + "  " + cells.get(2).text() + " \n ");
                str.append(cells.get(0).text() + "\n " + cells.get(1).text() + " \n " + cells.get(2).text() + " \n ");
                try {
                    bw.write(cells.get(0).text());
                    bw.newLine();
                    bw.write(cells.get(1).text());
                    bw.newLine();
                    bw.write(cells.get(2).text());
                    bw.newLine();
                } catch (IOException ex) {
                    Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        MainPage mp = new MainPage();
        mp.setVisible(true);
        mp.init();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JPanel ComparisionPanel;
    private javax.swing.JPanel OpenDataPanel;
    private javax.swing.JPanel ShowDataPanel;
    private javax.swing.JPanel WebPagePanel;
    private javax.swing.JFileChooser db;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTabDataGene;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel web1;
    private javax.swing.JPanel web2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void started(CrawlEvent ce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void stopped(CrawlEvent ce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cleared(CrawlEvent ce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void timedOut(CrawlEvent ce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void paused(CrawlEvent ce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
