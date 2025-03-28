package com.example.Ecole_gestion.dto;

import java.util.Date;

public record ErrorMessage(int status,
                           String msg,
                           String error,
                           Date timestamp) {
}
