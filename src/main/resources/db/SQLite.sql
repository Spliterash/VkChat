PRAGMA foreign_keys = OFF;
CREATE TABLE IF NOT EXISTS players
(
    "uuid"                  varchar(64) NOT NULL,
    "vk"                    integer     NOT NULL,
    "nickname"              varchar(64) NOT NULL,
    "selected_conversation" integer,
    PRIMARY KEY ("uuid"),
    FOREIGN KEY ([selected_conversation]) REFERENCES conversations (id) on delete set null
);
CREATE TABLE IF NOT EXISTS conversations
(
    "id"          integer     NOT NULL,
    "owner"       varchar(64) NOT NULL,
    "title"       varchar(256),
    "invite_link" varchar(128),
    PRIMARY KEY ("id"),
    FOREIGN KEY ([owner]) REFERENCES players (uuid) on delete cascade
);
CREATE TABLE IF NOT EXISTS conversation_members
(
    "player"       varchar(64) NOT NULL,
    "conversation" integer     NOT NULL,
    PRIMARY KEY ("player", "conversation"),
    FOREIGN KEY ([conversation]) REFERENCES conversations (id) on delete cascade,
    FOREIGN KEY ([player]) REFERENCES players (uuid) on delete cascade
);
-- Почему то эта херня не работает
PRAGMA foreign_keys = ON;
