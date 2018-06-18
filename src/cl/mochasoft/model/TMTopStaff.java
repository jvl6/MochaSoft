package cl.mochasoft.model;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Jorge A
 */
public class TMTopStaff implements TableModel {

    private List<CursorTopStaff> personal;

    public TMTopStaff(List<CursorTopStaff> personal) {
        this.personal = personal;
    }

    @Override
    public int getRowCount() {
        return personal.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Nombre";
            case 1:
                return "Cantidad de Juegos";
            default:
                return "Vacio";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CursorTopStaff sta = personal.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return sta.getNombre();
            case 1:
                return sta.getCantJuegos();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }

}
