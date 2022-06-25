package com.sofka.bugsmanagement.collections;

public enum ProjectStatus {
    CREATED, // creado: se refiere a una línea base sin actividad,
    ACTIVE, // activo: en operación, cancelado: ha finalizado su proceso por algún problema,
    PAUSED, // pausado: será activado en un futuro,
    FINISHED // culminado: el proyecto terminó exitosamente
}
