package com.uai.app.ui;

import com.uai.app.dominio.Libro;
import com.uai.app.dominio.enums.Tittles;
import com.uai.app.exceptions.LibroNotFoundException;
import com.uai.app.logic.SearchManager;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;


public class BuscarLibroUI extends UAIJFrame {
    private JPanel BuscarLibro;
    private JLabel Encabezado;
    private JButton buscarLibroButton;
    private JTextField Cuadrotextobuscarlibro;
    private JTextField sedetit;
    private JButton buscarLibroButton1;
    private JPanel mainTableConatiner2;
    private JPanel mainTableConatiner3;
    private JPanel mainTableConatiner4;
    private JTextField sectit;
    private JPanel mainTableConatiner5;
    private JButton buscarLibroButton2;

    private JPanel mainPanel;
    private JPanel mainTableConatiner;
    private JTextArea textArea1;

    public BuscarLibroUI(String title) {
        super(title);
        this.setMainPanel(BuscarLibro);
        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String tit = Cuadrotextobuscarlibro.getText();
                SearchManager.getInstance().buscarlibroportitulo(Tittles.TITULO, tit);

                String[] titles = {"titulo", "autor", "estante_numero", "estante_seccion", "piso", "edificio", "sede"};
                //obtengo los libros en una matriz
                HashSet<Libro> finbook = SearchManager.getInstance().buscarlibroportitulo(Tittles.TITULO, tit);
                if (finbook.size() == 0){
                    JFrame error= new JFrame();
                    JOptionPane.showMessageDialog(error,"¡No se encontro el libro!");
                    try {
                        throw new LibroNotFoundException();
                    } catch (LibroNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    dispose();

                }
                else{
                    String[][] dataTabla = new String[finbook.size()][7];
                    int cont = 0;

                    for(Libro p : finbook) {
                        dataTabla[cont] = p.getDataToCsv();
                        cont++;
                    }
                    TableModel tableModel = new DefaultTableModel(dataTabla, titles);
                    JTable table = new JTable(tableModel);
                    mainTableConatiner3.setLayout(new BorderLayout());
                    mainTableConatiner3.add(new JScrollPane(table), BorderLayout.CENTER);

                    mainTableConatiner3.add(table.getTableHeader(), BorderLayout.NORTH);

                    mainTableConatiner3.setVisible(true);
                    mainTableConatiner3.setSize(400,400);
                }

            }

        });

        buscarLibroButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sedet = sedetit.getText();
                SearchManager.getInstance().buscarlibroportitulo(Tittles.SEDE, sedet);
                String[] titles = {"titulo", "autor", "estante_numero", "estante_seccion", "piso", "edificio", "sede"};
                //obtengo los libros en una matriz
                HashSet<Libro> finsede = SearchManager.getInstance().buscarlibroportitulo(Tittles.SEDE, sedet);
                if (finsede.size() == 0){
                    JFrame error= new JFrame();
                    JOptionPane.showMessageDialog(error,"¡No se encontro la sede!");
                    try {
                        throw new LibroNotFoundException();
                    } catch (LibroNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    dispose();

                }
                else {
                    String[][] dataTabla = new String[finsede.size()][7];
                    int cont = 0;
                    for (Libro p : finsede) {
                        dataTabla[cont] = p.getDataToCsv();
                        cont++;
                    }
                    TableModel tableModel = new DefaultTableModel(dataTabla, titles);
                    JTable table = new JTable(tableModel);
                    mainTableConatiner4.setLayout(new BorderLayout());
                    mainTableConatiner4.add(new JScrollPane(table), BorderLayout.CENTER);

                    mainTableConatiner4.add(table.getTableHeader(), BorderLayout.NORTH);

                    mainTableConatiner4.setVisible(true);
                    mainTableConatiner4.setSize(400, 400);
                }

            }
        });

        buscarLibroButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sec = sectit.getText();
                SearchManager.getInstance().buscarlibroportitulo(Tittles.ESTANTE_SECCION, sec);
                String[] titles = {"titulo", "autor", "estante_numero", "estante_seccion", "piso", "edificio", "sede"};
                //obtengo los libros en una matriz
                HashSet<Libro> finsec = SearchManager.getInstance().buscarlibroportitulo(Tittles.ESTANTE_SECCION, sec);
                if (finsec.size() == 0){
                    JFrame error= new JFrame();
                    JOptionPane.showMessageDialog(error,"¡No se encontro la seccion!");
                    try {
                        throw new LibroNotFoundException();
                    } catch (LibroNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    dispose();

                }
                else {
                    String[][] dataTabla = new String[finsec.size()][7];
                    int cont = 0;
                    for (Libro p : finsec) {
                        dataTabla[cont] = p.getDataToCsv();
                        cont++;
                    }
                    TableModel tableModel = new DefaultTableModel(dataTabla, titles);
                    JTable table = new JTable(tableModel);
                    mainTableConatiner5.setLayout(new BorderLayout());
                    mainTableConatiner5.add(new JScrollPane(table), BorderLayout.CENTER);

                    mainTableConatiner5.add(table.getTableHeader(), BorderLayout.NORTH);

                    mainTableConatiner5.setVisible(true);
                    mainTableConatiner5.setSize(400, 400);
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
