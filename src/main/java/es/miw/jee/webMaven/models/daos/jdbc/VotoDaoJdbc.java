package es.miw.jee.webMaven.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.miw.jee.webMaven.models.daos.VotoDao;
import es.miw.jee.webMaven.models.entities.Voto;
import es.miw.jee.webMaven.models.utils.Estudios;

public class VotoDaoJdbc extends GenericDaoJdbc<Voto, Integer> implements VotoDao{

	 private Logger log = LogManager.getLogger(VotoDaoJdbc.class);

	    private Voto create(ResultSet resultSet) {
	        try {
	            if (resultSet != null && resultSet.next()) {
	                return new Voto(resultSet.getInt(Voto.VALORACION),
	                		Estudios.values()[resultSet.getInt(Voto.NIVELESTUDIOS)],
	                        resultSet.getString(Voto.IP)
	                        );
	            }
	        } catch (SQLException e) {
	            log.error("read: " + e.getMessage());
	        }
	        return null;
	    }

	
	
	private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL, %s VARCHAR(255), "
            + "%s INT, %s INT, PRIMARY KEY (%s))";

    public static String sqlToCreateTable() {
        return String.format(SQL_CREATE_TABLE, Voto.TABLE, Voto.ID, Voto.IP,Voto.NIVELESTUDIOS, Voto.VALORACION, Voto.ID);
    }
	
	
    private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s) VALUES (%d,'%s','%s')";

    private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s='%s' WHERE ID=%d";
    
    
	@Override
	public void create(Voto entity) {
		this.updateSql(String.format(SQL_INSERT, Voto.TABLE, Voto.IP, Voto.NIVELESTUDIOS, Voto.VALORACION, entity.getIp(), entity.getNivelEstudios(), entity.getValoracion()));
		
	}

	@Override
	public Voto read(Integer id) {
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Voto.TABLE, id));
        return this.create(resultSet);
	}

	@Override
	public void update(Voto entity) {
		this.updateSql(String.format(SQL_UPDATE, Voto.TABLE, Voto.IP, entity.getIp(),
                Voto.NIVELESTUDIOS, entity.getNivelEstudios(), Voto.VALORACION, entity.getValoracion()));
		
	}

	@Override
	public void deleteById(Integer id) {
		this.updateSql(String.format(SQL_DELETE_ID, Voto.TABLE, id));
		
	}

	@Override
	public List<Voto> findAll() {
		List<Voto> list = new ArrayList<Voto>();
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL, Voto.TABLE));
        Voto category = this.create(resultSet);
        while (category != null) {
            list.add(category);
            category = this.create(resultSet);
        }
        return list;
	}

}
