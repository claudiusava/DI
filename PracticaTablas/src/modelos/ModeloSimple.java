package modelos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import utils.Persona;

public class ModeloSimple extends AbstractTableModel{

    private ArrayList<Persona> personas;
    private String [] columnas;
    private Class[] tipos = {Integer.class, String.class, String.class, Integer.class};

    public ModeloSimple(ArrayList personas) {
        this.personas = personas;
        this.columnas = new String[]{"Clave", "Nombre", "Apellidos", "Edad"};
    }
    
     @Override
    public int getRowCount() {
        return personas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return personas.get(rowIndex).getClave();
            case 1:
                return personas.get(rowIndex).getNombre();
            case 2:
                return personas.get(rowIndex).getApellidos();
            case 3:
                return personas.get(rowIndex).getEdad();
            default:
                return null;
        }
    }
    
    public void borrarPersona(int index){
        personas.remove(index);
        fireTableDataChanged();
    }

    public Persona personaSeleccionada(int index){
        return personas.get(index);
    }

    public Persona[] personasSeleccionadasMultiple(int[] seleccion){

        Persona[] personas = new Persona[seleccion.length];

        for (int i=0;i<personas.length;i++){
            personas[i]=this.personas.get(i);
        }
        return personas;
    }
    
    public void borrarPersonaDNI(int clave){
        for (Persona p:personas) {
           if (p.getClave().equals(clave)){
               personas.remove(p);
           }
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tipos[columnIndex];
    }
}