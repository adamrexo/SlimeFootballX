package eu.rexo.slimefootball.utils;

import java.sql.*;

import eu.rexo.slimefootball.utils.*;

public class dbManager {
    public void createTable() {
        try(Statement statement = database.getStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS STATS " +
                    "(id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(16) NOT NULL, " +
                    "uuid VARCHAR(64) NOT NULL, " +
                    "goly INT NOT NULL DEFAULT 0," +
                    "hry INT NOT NULL DEFAULT 0," +
                    "punch INT NOT NULL DEFAULT 0)");
        } catch(SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void pridatGol(String jmeno, String uuid, int goly) {
        try (Statement statement = database.getStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM stats WHERE uuid='" + uuid + "'");

            if (!resultSet.next()) {
                statement.executeUpdate("INSERT INTO stats (name, uuid, goly) VALUES " +
                        "('" + jmeno + "', '" + uuid + "', " + goly + ")");
            } else {
                int aktualniGoly = resultSet.getInt("goly");
                int noveGoly = aktualniGoly + goly;
                statement.executeUpdate("UPDATE stats SET goly=" + noveGoly + " WHERE name='" + uuid + "'");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public int ziskatGoly(String nick) {
        int goly = 0;
        try (Statement statement = database.getStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT goly FROM stats WHERE name='" + nick + "'");
            if (resultSet.next()) {
                goly = resultSet.getInt("goly");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return goly;
    }

    public void pridatHry(String jmeno, String uuid, int hry) {
        try (Statement statement = database.getStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM stats WHERE uuid='" + uuid + "'");

            if (!resultSet.next()) {
                statement.executeUpdate("INSERT INTO stats (name, uuid, hry) VALUES " +
                        "('" + jmeno + "', '" + uuid + "', " + hry + ")");
            } else {
                int aktualniHry = resultSet.getInt("hry");
                int noveHry = aktualniHry + hry;
                statement.executeUpdate("UPDATE stats SET hry=" + noveHry + " WHERE uuid='" + uuid + "'");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public int ziskatHry(String nick) {
        int hry = 0;
        try (Statement statement = database.getStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT hry FROM stats WHERE name='" + nick + "'");
            if (resultSet.next()) {
                hry = resultSet.getInt("hry");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return hry;
    }

    public void pridatPunche(String jmeno, String uuid, int pocetPunchu) {
        try (Statement statement = database.getStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM stats WHERE uuid='" + uuid + "'");

            if (!resultSet.next()) {
                statement.executeUpdate("INSERT INTO stats (name, uuid, punch) VALUES " +
                        "('" + jmeno + "', '" + uuid + "', " + pocetPunchu + ")");
            } else {
                int aktualniPunch = resultSet.getInt("punch");
                int novePunche = aktualniPunch + pocetPunchu;
                statement.executeUpdate("UPDATE stats SET punch=" + novePunche + " WHERE uuid='" + uuid + "'");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public int ziskatPunche(String nick) {
        int punche = 0;
        try (Statement statement = database.getStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT punch FROM stats WHERE name='" + nick + "'");
            if (resultSet.next()) {
                punche = resultSet.getInt("punch");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return punche;
    }

}