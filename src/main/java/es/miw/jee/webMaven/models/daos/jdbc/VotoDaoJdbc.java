package es.miw.jee.webMaven.models.daos.jdbc;

import java.util.List;

import es.miw.jee.webMaven.models.daos.VotoDao;
import es.miw.jee.webMaven.models.entities.Voto;

public class VotoDaoJdbc extends GenericDaoJdbc<Voto, Integer> implements VotoDao{

	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Voto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Voto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
