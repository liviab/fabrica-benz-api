package br.com.fabrica.benz.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fabrica.benz.model.Usuario;

public class UsuarioForm {

	@NotEmpty @NotNull
    private	String firstname;
	@NotEmpty @NotNull
	private String lastname;
	@NotEmpty @NotNull
	private String email;
	private LocalDate birthday;
	@NotEmpty @NotNull
	private String login;
	@NotEmpty @NotNull
	private String password;
	@NotEmpty @NotNull @Length(min = 10, max = 11)
	private String phone;

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Usuario converter(){
		return new Usuario(firstname, lastname, email, birthday, login, password, phone);
	}
}
