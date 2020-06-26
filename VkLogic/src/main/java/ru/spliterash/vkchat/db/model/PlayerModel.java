package ru.spliterash.vkchat.db.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import ru.spliterash.vkchat.db.dao.PlayerDao;

import java.util.UUID;

@DatabaseTable(tableName = "players", daoClass = PlayerDao.class)
public class PlayerModel {
    @DatabaseField(id = true, index = true, canBeNull = false, unique = true, dataType = DataType.UUID_NATIVE)
    private UUID uuid;
    @DatabaseField(canBeNull = false)
    private int vk;
}
