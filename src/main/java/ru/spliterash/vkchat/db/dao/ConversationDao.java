package ru.spliterash.vkchat.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import ru.spliterash.vkchat.db.model.ConversationModel;

import java.sql.SQLException;

public class ConversationDao extends BaseDaoImpl<ConversationModel, Integer> {
    public ConversationDao(ConnectionSource connectionSource, Class<ConversationModel> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}
