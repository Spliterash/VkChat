package ru.spliterash.vkchat.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import ru.spliterash.vkchat.db.model.ConversationModel;

import java.sql.SQLException;

public class ConversationDao extends BaseDaoImpl<ConversationModel, Integer> {
    protected ConversationDao(ConnectionSource source) throws SQLException {
        super(source,ConversationModel.class);
    }
}
