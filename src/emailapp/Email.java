package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private int mailboxCapacity = 500;
	private int defaultPasswordLenght = 10;
	private String alternateEmail;
	private String companySuffix = "dsxcompany.com";
	
	//Конструктор получения фамилии и имени
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

		
		this.department = setDepartment();

		
		this.password = randomPassword(defaultPasswordLenght);
		System.out.println("Ваш пароль - это: " + this.password);
		
		//Генерация email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

		
	}
	
	//Обратитесь в департамент!!!
	private String setDepartment() {
		System.out.print("New worker:" + firstName + " .Введите отдел\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {return "sales";}
		else if(depChoice == 2) {return "dev";}
		else if (depChoice == 3) {return "acct";}
		else {return "";}
	}
	
	//Генератор случайного пароля
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHJKLMNOPRSTUWXZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random()* passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Установить емкость почтового ящика
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//Установить альтернативный email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Смена  пароля
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailinboxCapacity() {return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
	

}
