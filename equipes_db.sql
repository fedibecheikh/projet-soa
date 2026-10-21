-- ============================================================
--  Base de données : equipes_db
--  Compatible avec les entités Spring Boot JPA
-- ============================================================

CREATE DATABASE IF NOT EXISTS equipes_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE equipes_db;

-- ------------------------------------------------------------
--  Table : ligue
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ligue (
  id_ligue BIGINT NOT NULL AUTO_INCREMENT,
  nom_ligue VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_ligue)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ------------------------------------------------------------
--  Table : equipe
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS equipe (
  id_equipe     BIGINT NOT NULL AUTO_INCREMENT,
  nom_equipe    VARCHAR(100) NOT NULL,
  points_equipe DOUBLE,
  date_creation DATE,
  ligue_id_ligue BIGINT,
  PRIMARY KEY (id_equipe),
  CONSTRAINT fk_equipe_ligue
    FOREIGN KEY (ligue_id_ligue) REFERENCES ligue (id_ligue)
    ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ------------------------------------------------------------
--  Données : Ligues
-- ------------------------------------------------------------
INSERT INTO ligue (nom_ligue) VALUES
  ('Ligue 1 - France'),
  ('Premier League - Angleterre'),
  ('La Liga - Espagne'),
  ('Serie A - Italie'),
  ('Bundesliga - Allemagne');

-- ------------------------------------------------------------
--  Données : Équipes
-- ------------------------------------------------------------
INSERT INTO equipe (nom_equipe, points_equipe, date_creation, ligue_id_ligue) VALUES
  ('Paris Saint-Germain',  78, '1970-08-12', 1),
  ('Olympique de Marseille', 65, '1899-08-31', 1),
  ('Olympique Lyonnais',   60, '1950-03-03', 1),
  ('Manchester City',      91, '1880-05-01', 2),
  ('Liverpool FC',         82, '1892-06-03', 2),
  ('Arsenal FC',           75, '1886-10-01', 2),
  ('Real Madrid',          95, '1902-03-06', 3),
  ('FC Barcelona',         88, '1899-11-29', 3),
  ('Atletico Madrid',      72, '1903-04-26', 3),
  ('Juventus FC',          70, '1897-11-01', 4),
  ('AC Milan',             68, '1899-12-16', 4),
  ('Inter Milan',          85, '1908-03-09', 4),
  ('Bayern Munich',        90, '1900-02-27', 5),
  ('Borussia Dortmund',    75, '1909-12-19', 5);

-- ------------------------------------------------------------
--  Vérification
-- ------------------------------------------------------------
SELECT 'Ligues insérées :' AS info, COUNT(*) AS nb FROM ligue;
SELECT 'Équipes insérées :' AS info, COUNT(*) AS nb FROM equipe;
