package com.example.Ecole_gestion.services;

public interface MailService {

    void sendSimpleMail(String to,String from,String subject,String body);
}
