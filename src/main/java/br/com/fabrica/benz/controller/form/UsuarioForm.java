package br.com.fabrica.benz.controller.form;

import java.time.LocalDate;

import br.com.fabrica.benz.model.Usuario;

public class UsuarioForm {

    private	String firstname;
	private String lastname;
	private String email;
	private LocalDate birthday;
	private String login;
	private String password;
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
