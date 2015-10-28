PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE "Hermes.Ninios" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "nombre" TEXT NOT NULL,
    "apellido" TEXT NOT NULL
);
CREATE TABLE "Hermes.Contextos" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "nombre" TEXT NOT NULL,
    "descripcion" TEXT
);
CREATE TABLE "Hermes.Categorias" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "nombre" TEXT NOT NULL
);
CREATE TABLE "Hermes.Categorias.Contextos" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "idContexto" INTEGER NOT NULL,
    "idCategoria" INTEGER NOT NULL
);
CREATE TABLE "Hermes.Etiquetas" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "nombre" TEXT NOT NULL,
    "descripcion" TEXT DEFAULT ('Sin descripción'),
    "idTerapeuta" INTEGER NOT NULL DEFAULT (0)
);

CREATE TABLE "Hermes.Notificaciones" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "idCategoria" INTEGER,
    "idContexto" INTEGER,
    "idNinio" INTEGER,
    "idMensaje" TEXT,
    "fecha" TEXT,
    "fechaEnviado" TEXT,
    "fechaRecibido" TEXT
);

CREATE TABLE "Hermes.Mensajes" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "nombre" TEXT,
    "descripcion" TEXT,
    "imagen" TEXT
);

CREATE TABLE "Hermes.Notificaciones.Etiquetas" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "idNotificacion" INTEGER NOT NULL,
    "idEtiqueta" INTEGER NOT NULL
);
COMMIT;
