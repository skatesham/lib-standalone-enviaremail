package com.sham.springboot.enviadoremail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class EnviadoremailApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnviadoremailApplication.class, args);
	}

	@Service
	public class EmailService {
		public void enviar(String nome, String emailConvidado) {
			try {
				Email email = new SimpleEmail();
				email.setHostName("smtp.googlemail.com");
				email.setSmtpPort(465);
				email.setAuthenticator(new DefaultAuthenticator("java.mail.sender.gsw@gmail.com", "javamailsender"));
				email.setSSLOnConnect(true);

				email.setFrom("email");
				email.setSubject("Você foi convidado pelo ListaVIP");
				email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
				email.addTo(emailConvidado);
				email.send();

			} catch (EmailException e) {
				e.printStackTrace();
			}
		}
	}

}
