package com.uai.app.ui;

import com.uai.app.dominio.Libro;
import com.uai.app.exceptions.LibroNotFoundException;
import com.uai.app.logic.DataManager;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class EliminarLibroUI extends UAIJFrame {
    private JPanel BuscarLibro;
    private JButton buscarButton;
    private JTextField Cuadrotextobuscarlibro;
    private JButton eliminarButtom;
    private JLabel Encabezado;
    private JPanel mainTableConatiner3;


    public EliminarLibroUI(String title) {
        super(title);
        this.setMainPanel(BuscarLibro);
        int probando=0;



        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tit = Cuadrotextobuscarlibro.getText();

                HashSet<Libro> data = DataManager.getInstance().getData();
                String[][] dataTabla = new String[data.size()][7];
                int existencia=0;
                int contador=0;


                for (Libro p: data){
                    if (p.getTitulo().equals(tit)){
                        existencia++;
                        dataTabla[contador] = p.getDataToCsv();

                        String[] titles = {"titulo", "autor", "estante_numero", "estante_seccion", "piso", "edificio", "sede"};
                        TableModel tableModel = new DefaultTableModel(dataTabla, titles);
                        JTable table = new JTable(tableModel);
                        mainTableConatiner3.setLayout(new BorderLayout());
                        mainTableConatiner3.add(new JScrollPane(table), BorderLayout.CENTER);
                        mainTableConatiner3.add(table.getTableHeader(), BorderLayout.NORTH);
                        mainTableConatiner3.setVisible(true);
                        mainTableConatiner3.setSize(400,400);
                        break;
                    }
                    contador++;
                }
                if (existencia==0){
                    JFrame error= new JFrame();
                    try {
                        throw new LibroNotFoundException();
                    } catch (LibroNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(error,"¡No se encontro el libro!");
                }
                //existencia se utiliza para saber si se encuentra el libro, 0 si no existe, 1 si existe

            }
        });


        eliminarButtom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tit = Cuadrotextobuscarlibro.getText();
                HashSet<Libro> data = DataManager.getInstance().getData();
                int existencia=0;
                for (Libro p: data){
                    if (p.getTitulo().equals(tit)){
                        existencia++;
                        break;
                    }
                }
                if (existencia==0){
                    JFrame error= new JFrame();
                    try {
                        throw new LibroNotFoundException();
                    } catch (LibroNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(error,"¡No se encontro el libro!");
                }
                if (existencia==1){
                    for (Libro p:data){
                        if (p.getTitulo().equals(tit)){
                            data.remove(p);
                            JFrame success= new JFrame();
                            JOptionPane.showMessageDialog(success,"¡Libro eliminado!");
                            dispose();
                            break;

                        }
                    }
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
