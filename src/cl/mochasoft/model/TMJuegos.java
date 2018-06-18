package cl.mochasoft.model;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Jorge A
 */
public class TMJuegos implements TableModel {

    private List<Juego> juegos;

    public TMJuegos(List<Juego> juegos) {
        this.juegos = juegos;
    }

    @Override
    public int getRowCount() {
        return juegos.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Título";
            case 2:
                return "Género";
            case 3:
                return "Año";
            case 4:
                return "Plataforma";
            case 5:
                return "Engine";
            case 6:
                return "Unidades";
            case 7:
                return "Versión";
            default:
                return "null";
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
        Juego gam = juegos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return gam.getId();
            case 1:
                return gam.getTitulo();
            case 2:
                return gam.getFk_genero();
            case 3:
                return gam.getAnio_release();
            case 4:
                return gam.getFk_plataforma();
            case 5:
                return gam.getFk_engine();
            case 6:
                return gam.getUnidades();
            case 7:
                return gam.getVersion();
            default:
                return "null";
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
