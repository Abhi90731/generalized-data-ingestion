CREATE TABLE IF NOT EXISTS logs (
  timestamp DateTime,
  level String,
  message String,
  metadata String
) ENGINE = MergeTree()
ORDER BY timestamp;