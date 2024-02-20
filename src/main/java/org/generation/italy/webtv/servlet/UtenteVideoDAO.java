package org.generation.italy.webtv.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.generation.italy.webtv.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtenteVideoDAO {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM video";
    private static final String SELECT_BY_KEYWORD_QUERY = "SELECT * FROM video WHERE titolo LIKE ? OR tag LIKE ?";

    @Autowired
    private DatasourceProperties datasourceProperties;

    public List<Video> getAllVideos() {
        List<Video> videos = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Video video = createVideoFromResultSet(resultSet);
                videos.add(video);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videos;
    }

    public List<Video> getVideosByKeyword(String keyword) {
        List<Video> videos = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_KEYWORD_QUERY)) {
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setString(2, "%" + keyword + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Video video = createVideoFromResultSet(resultSet);
                    videos.add(video);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videos;
    }

    private Video createVideoFromResultSet(ResultSet resultSet) throws SQLException {
        int idVideo = resultSet.getInt("id_video");
        String titolo = resultSet.getString("titolo");
        int minutaggioTotaleVideo = resultSet.getInt("minutaggio_totale_video");
        boolean approvazione = resultSet.getBoolean("approvazione");
        String categoria = resultSet.getString("categoria");
        String tag = resultSet.getString("tag");
        String url = resultSet.getString("url");
        return new Video(idVideo, minutaggioTotaleVideo, categoria, tag, approvazione, titolo, url);
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName(datasourceProperties.getDriver_class_name());
            connection = DriverManager.getConnection(
                    datasourceProperties.getUrl(),
                    datasourceProperties.getUsername(),
                    datasourceProperties.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Error loading database driver");
        }
        return connection;
    }
}
