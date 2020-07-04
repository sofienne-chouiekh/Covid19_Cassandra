/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isetj.guicassandra.dao;
//importer les classes necessaires
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

/**
 *
 * @author MSellami
 */
public class CassandraConnector {
//definir les variables necessaires pour la connexion par defaut
    private static String Node = "127.0.0.1";
    private static Integer Port = 9042;
    private static String User;
    private static String Password;
	//definir les variables Cluster et Session pour la connexion au CLuster Cassandra
    private static Cluster cluster;

    private static Session session;
	//definir une variable contenant le CQL script pour la creation de la bases KeySpace;
    private static String CQLShema
            = "CREATE KEYSPACE IF NOT EXISTS Covid19DB "
            + "WITH replication = {'class':'SimpleStrategy','replication_factor':1};"
            + "CREATE TABLE IF NOT EXISTS Covid19DB.City("
            + "  IDCity uuid PRIMARY KEY,"
            + "  CityName text,"
            + "  Longitude double,"
            + "  latitude double,"
            + "  population int"
            + ");";
	//définir une fonction statique pour etablir une connection  et d"ouvrir une session au cluster
    public static void connect(String Node, Integer Port, String User, String Password) {
        Cluster.Builder b = Cluster.builder().addContactPoint(Node);
        if (Port != null) {
            b.withPort(Port);
        }
        //if (User != null & Password != null) {
        // b.withCredentials(User.trim(), Password.trim());
        // }

        cluster = b.build();

        session = cluster.connect();
    }
///definir une fonction retournant la session en cours
    public static Session getSession() {
        return session;
    }
//definir une fonction de fermeture de la session en cours
    public static void close() {
        session.close();
        cluster.close();
    }
//definir une fonction de creation du schema de la base pas a pas
    public static void createKeyspace(
            String keyspaceName, String replicationStrategy, int replicationFactor) {
         
        
        StringBuilder sb
                = new StringBuilder("DROP KEYSPACE IF EXISTS  ").append(keyspaceName).append(" ;");
        //Execution de la requete
        session.execute(sb.toString());
       
        sb
                = new StringBuilder("CREATE KEYSPACE IF NOT EXISTS ")
                        .append(keyspaceName).append(" WITH replication = {")
                        .append("'class':'").append(replicationStrategy)
                        .append("','replication_factor':").append(replicationFactor)
                        .append("}; \n");
        //Choiser la base à utiliser
        session.execute(sb.toString());
        sb = new StringBuilder(" Use ")
                .append(keyspaceName)
                .append(" ;");
        session.execute(sb.toString());
        //creation de la table City
        sb = new StringBuilder(" CREATE TABLE IF NOT EXISTS ")
                .append("City").append("(")
                .append("IDCity int PRIMARY KEY, ")
                .append("CityName text,")
                .append("Longitude double,")
                .append("latitude double,")
                .append("population double);");
        String query = sb.toString();
        //Executer la requete
        session.execute(query);

    }
//definir une fonction de creation d'un table
    public static void createTable(String query) {
        session.execute(query);
    }
//definir une fonction de modifier d'une table
    public static void alterTable(String TableName, String columnName, String columnType) {
        StringBuilder sb = new StringBuilder("ALTER TABLE ")
                .append(TableName).append(" ADD ")
                .append(columnName).append(" ")
                .append(columnType).append(";");

        String query = sb.toString();
        session.execute(query);
    }
//definir une fonction d'executer une requete cql et de retouner le resulta a partir  d'une table
    public static ResultSet ExecuteQuery(String Query) {

        return session.execute(Query);
    }
}
