package persistence;

import java.sql.SQLException;

/**
 *
 * @author benni
 */
public interface ILaborantMapper {
    public boolean einfuegenTestergebnis(String id, boolean ergebnis) throws SQLException;
    public boolean aendernTestergebnis(String id, boolean ergebnis ) throws SQLException;
}
