/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.LayoutManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;

/**
 *
 * @author jeanym
 */
public class ShowMovie extends javax.swing.JFrame {

    /**
     * Creates new form ShowMovie
     */
	private Movie m;
	private String title;
	private BigDecimal movieId;
	ArrayList<BigDecimal> listIDCrewmember;
	DefaultListModel<String> countrylistmodel = new DefaultListModel<>();
	DefaultListModel<String> writerlistmodel = new DefaultListModel<>();
	DefaultListModel<String> genreListModel = new DefaultListModel<>();
	DefaultTableModel actorTableModel = new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Actor", "Character"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
    private SearchMovies sm;
    private Session session;
    private Systemuser thisLogin;
    public ShowMovie() {
        initComponents();
    }
    public ShowMovie(SearchMovies movieList,Session s, BigDecimal movieId, Systemuser Login) {
        this.session =s;
        this.sm = movieList;
        this.movieId = movieId;
        this.thisLogin = Login;
    	initComponents();
    	FillUpForm("",movieId);
    	this.setVisible(true);
        //new ShowMovie().setVisible(true);
    }
    public ShowMovie(Session s,String title, BigDecimal movieId) {
        this.session =s;
        this.title = title;
        this.movieId = movieId;
    	initComponents();
    	FillUpForm(title,movieId);
    	this.setVisible(true);
        //this.sm = movieList;
        //new ShowMovie().setVisible(true);
    }
    
    public void rentMovie(BigDecimal userId, BigDecimal movieId) {
    	MovieRentBroker movieRentBroker = new MovieRentBroker(session, userId, movieId);
    	int reantResult = movieRentBroker.insertRent();
    	if(reantResult == -1) {
	            JOptionPane.showMessageDialog(this, "No subscription for this user.");
	            }
    	else if  (reantResult == -2) {
	            JOptionPane.showMessageDialog(this, "This user has reached the maximum number of movies he can rent.");
	            }
    	else if  (reantResult == -3) {
	            JOptionPane.showMessageDialog(this, "This movie is not avaible for renting.");
	            }
    	else if  (reantResult == 0) {}
       

    	//titleLabel.setText("Title");
    }    
    public void FillUpForm(String title, BigDecimal movieId) {
    	MovieDetailBroker movieDetailBroker = new MovieDetailBroker(session);
    	m = movieDetailBroker.GetMovieFromID(movieId);
    	System.out.println("Title :" + m.getTitle());
        titleLabel.setText(m.getTitle());
        directorLabel.setText(m.getCrewmember().getFirstname() + " " +m.getCrewmember().getLastname());
        yearLabel.setText(m.getReleaseyear().toPlainString());
        langLabel.setText(m.getLanguage());
        lengthLabel.setText(m.getLength().toPlainString());
        Iterator iMovieActor = m.getMovieactors().iterator();
        //Iterator iMovieActorId = m.getMovieactors_1().iterator();
        listIDCrewmember = new  ArrayList<BigDecimal>();
        while(iMovieActor.hasNext())
        {
            Movieactor movieActor = (Movieactor) iMovieActor.next();
            //MovieactorId movieActorId = (MovieactorId) iMovieActorId.next();
            Crewmember cm = movieActor.getCrewmember();
            Object[]  rowData = {cm.getFirstname() + " " +cm.getLastname(), movieActor.getId().getCharacter()};
            actorTableModel.addRow(rowData);
            listIDCrewmember.add(movieActor.getCrewmember().getCrewmemberid());
        }
        Iterator iCountry = m.getCountries().iterator();
        while(iCountry.hasNext())
        {
            Country country = (Country) iCountry.next();
           countrylistmodel.addElement(country.getName());
        }
        Iterator iWriter = m.getScriptwriters().iterator();
        while(iWriter.hasNext())
        {
            Scriptwriter scriptwriter = (Scriptwriter) iWriter.next();
            writerlistmodel.addElement(scriptwriter.getFirstname());
        }
        Iterator iGenre = m.getGenres().iterator();
        while(iGenre.hasNext())
        {
            Genre genre = (Genre) iGenre.next();
            genreListModel.addElement(genre.getName());
        }
        synopsisTextArea.setText(m.getSynopsis().getDescription());
       

    	//titleLabel.setText("Title");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        countryList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        synopsisTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        directorLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        genreList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        writerList = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        rentButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        actorTable = new javax.swing.JTable();
        jLabelLang = new javax.swing.JLabel();
        langLabel = new javax.swing.JLabel();
        jLabelLength = new javax.swing.JLabel();
        lengthLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        countryList.setModel(countrylistmodel);
        jScrollPane1.setViewportView(countryList);

        synopsisTextArea.setEditable(false);
        synopsisTextArea.setColumns(20);
        synopsisTextArea.setRows(5);
        jScrollPane2.setViewportView(synopsisTextArea);

        jLabel1.setText("Director");

        directorLabel.setForeground(new java.awt.Color(0, 0, 255));
        directorLabel.setText("jLabel2");
        directorLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                directorLabelMouseClicked(evt);
            }
        });

        jLabel3.setText("Title");

        jLabel4.setText("Synopsis");

        returnButton.setText("Back");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        genreList.setModel(genreListModel);
        jScrollPane3.setViewportView(genreList);

        jLabel5.setText("Genre");

        jLabel6.setText("Country of filming");

        //FillUpForm(title,movieId);

        writerList.setModel(writerlistmodel);
        jScrollPane4.setViewportView(writerList);

        jLabel8.setText("ScriptWriter");

        jLabel9.setText("Release Year");

        //yearLabel.setText("jLabel2");

        rentButton.setLabel("Rent Movie");
        rentButton.addActionListener(new java.awt.event.ActionListener() {
        	  public void actionPerformed(java.awt.event.ActionEvent evt) {
        	   rentButtonActionPerformed(evt);
        	  }
        	 });
        actorTable.setModel(actorTableModel);
        actorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actorTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(actorTable);

        jLabelLang.setText("Language");

        langLabel.setText("jLabel7");

        jLabelLength.setText("Length");

        lengthLabel.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(returnButton, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabelLang)
                                    .addComponent(jLabelLength))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(directorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)	
		                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
		                                    .addComponent(langLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
		                                    .addComponent(lengthLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                                    .addComponent(yearLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(rentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(returnButton)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(directorLabel))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(yearLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLang)
                            .addComponent(langLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLength)
                            .addComponent(lengthLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(rentButton)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        rentButton.getAccessibleContext().setAccessibleName("Rent Movie");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
       if(sm == null ) {           
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new SearchMovies(session, thisLogin);
                }
            });
        }else
            sm.setVisible(true);
       this.setVisible(false);
       this.dispose();
    }//GEN-LAST:event_returnButtonActionPerformed

    private void actorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actorTableMouseClicked
        // TODO add your handling code here:
             
        if (evt.getClickCount() == 2) {
           JTable target = (JTable)evt.getSource();
           int row = target.getSelectedRow();
           BigDecimal id = listIDCrewmember.get(row);
           new CrewMemberView(session,id).setVisible(true);
        }
    }//GEN-LAST:event_actorTableMouseClicked

    private void rentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directorLabelMouseClicked
        // TODO add your handling code here:r
    	rentMovie( thisLogin.getSystemuserid(),m.getMovieid());
    }
    private void directorLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_directorLabelMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
           new CrewMemberView(session,m.getCrewmember().getCrewmemberid()).setVisible(true);
        }
    }//GEN-LAST:event_directorLabelMouseClicked
    
    /**
     * @param args the command line arguments
     */
    /*public static void init(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowMovie().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> countryList;
    private javax.swing.JLabel directorLabel;
    private javax.swing.JList<String> genreList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelLang;
    private javax.swing.JLabel jLabelLength;
    private javax.swing.JLabel langLabel;
    private javax.swing.JLabel lengthLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable actorTable;
    private javax.swing.JTextArea synopsisTextArea;
    private javax.swing.JButton rentButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JList<String> writerList;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
