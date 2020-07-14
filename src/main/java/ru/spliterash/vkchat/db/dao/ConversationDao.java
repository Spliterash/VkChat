package ru.spliterash.vkchat.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import ru.spliterash.vkchat.db.Database;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ConversationDao extends BaseDaoImpl<ConversationModel, Integer> {
    public ConversationDao(ConnectionSource connectionSource, Class<ConversationModel> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<ConversationModel> findByOwner(UUID player) throws SQLException {
        return queryBuilder()
                .where()
                .eq(ConversationModel.OWNER_NAME, player)
                .query();
    }

    @Override
    public int delete(ConversationModel data) throws SQLException {
        int result = super.delete(data);
        if (result > 0) {
            PlayerConversationDao dao = Database.getDao(PlayerConversationModel.class);
            List<PlayerConversationModel> delete = dao.findByConversation(data.getId());
            dao.delete(delete);

            PlayerDao pDao = Database.getDao(PlayerModel.class);
            UpdateBuilder<PlayerModel, UUID> builder = pDao.updateBuilder();
            builder
                    .where()
                    .eq(PlayerModel.SELECTED_NAME, data.getId());
            builder.updateColumnValue(PlayerModel.SELECTED_NAME, null);

        }
        return result;
    }
}
