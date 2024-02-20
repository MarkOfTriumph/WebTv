//package org.generation.italy.webtv.servlet;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//
///**
// * @author Angelo Pasquarelli
// *
// * Imlpementazione della connessione JDBC con uso del pattern singleton.
// * (per evitare di aprire troppe connessioni verso il database,
// *  una operazione che richiede un certo tempo ed uso di risorse)
// *
// * Una classe singleton � una classe che pu� essere istanziata solo indirettamente ed una sola volta.
// * Ci� significa che alla classe corrisponde un solo oggetto (istanza)
// *
// * E' possible avere questo risutlato rendendo il metodo costruttore della classe privato
// * e, sopratttuto, l'attributo static 'jdbcConnectionSingletonInstance' che rappresenta l'istanza della classe 'JdbcConnection'.
// *
// * Attravero il metodo readJdbcConnectionInstance, qualora la classe non sia stata istanziata (vedi istruzione 'if (jdbcConnectionSingletonInstance==null)'),
// * viene effettuata l'auto-istanza della classe (la classe istanzia se stessa). Avviene, di conseguenza, l'apertura della connessione verso il database
// * e la valorizzazione dell'attributo 'dbConnection' di tipo classe 'java.sql.Connection'.
// *
// */
//
//public class JdbcConnection {
//
//    private Connection dbConnection;
//
//    private static JdbcConnection jdbcConnectionSingletonInstance = null;
//
//    private JdbcConnection() {} // costruttore
//
//    public
//    static
//    JdbcConnection readJdbcConnectionInstance(String _driverName
//    										, String _driverClassPath
//    										, String _serverName
//    										, String _serverPort
//    										, String _databaseName
//			                                , String _username
//			                                , String _password)
//	{
//
//        if (jdbcConnectionSingletonInstance==null) {
//
//        	jdbcConnectionSingletonInstance = new JdbcConnection();				//auto-istanziazione della classe
//
//            String jdbcUrl = 													//formatta la stringa jdbcUrl inserendo i valori al posto dei parametri tra {}
//        		String.format("jdbc:%s://%s:%s/%s"
//        					, _driverName
//        					, _serverName
//        					, _serverPort
//        					, _databaseName);
//
//            try {
//                Class.forName(_driverClassPath);								//verifica la presenza della classe principale del driver JDBC (vedi import via pom.xml esezione del progetto eclipse denominata 'Maven Dependencies')
//                jdbcConnectionSingletonInstance.dbConnection
//                        = DriverManager.getConnection(jdbcUrl,
//                                                    _username,
//                                                    _password);
//
//            } catch (Exception exception) {										//eccezione catturata per mancata connessione al database
//
//            }
//        }
//
//        return jdbcConnectionSingletonInstance;
//    }
//
//
//	public Connection getDbConnection() {
//		return this.dbConnection;
//	}
//
//	/** Test per verfifica implementazione connection jdbc con pattern singleton:
//     * le connessioni fanno riferimento allo stesso oggetto dbConnection di tipo Connection**/
//    public static void main(String[] args) {
//
//			JdbcConnection jdbcConnection1 = JdbcConnection.readJdbcConnectionInstance("mariadb", "org.mariadb.jdbc.Driver", "localhost", "3306", "banca", "root", "");
//	    	JdbcConnection jdbcConnection2 = JdbcConnection.readJdbcConnectionInstance("mariadb", "org.mariadb.jdbc.Driver", "localhost", "3306", "banca", "root", "");
//	    	JdbcConnection jdbcConnection3 = JdbcConnection.readJdbcConnectionInstance("mariadb", "org.mariadb.jdbc.Driver", "localhost", "3306", "banca", "root", "");
//	    	JdbcConnection jdbcConnection4 = JdbcConnection.readJdbcConnectionInstance("mariadb", "org.mariadb.jdbc.Driver", "localhost", "3306", "banca", "root", "");
//	    	JdbcConnection jdbcConnection5 = JdbcConnection.readJdbcConnectionInstance("mariadb", "org.mariadb.jdbc.Driver", "localhost", "3306", "banca", "root", "");
//	    	JdbcConnection jdbcConnection6 = JdbcConnection.readJdbcConnectionInstance("mariadb", "org.mariadb.jdbc.Driver", "localhost", "3306", "banca", "root", "");
//
//	        System.out.println(jdbcConnection1);
//	        System.out.println(jdbcConnection2);
//	        System.out.println(jdbcConnection3);
//	        System.out.println(jdbcConnection4);
//	        System.out.println(jdbcConnection5);
//	        System.out.println(jdbcConnection6);
//
//	}
//
//    }
//

