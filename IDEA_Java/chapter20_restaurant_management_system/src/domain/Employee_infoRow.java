package domain;


import java.sql.Date;

public class Employee_infoRow {
    private String name;
    private String niNumber;
    private Date birthday;
    private Date hiredate;
    private Date quitdate;
    private String emp_tel;
    private String emp_address;
    private String emp_mail;
    private boolean ifManager;

    public Employee_infoRow() {
    }

    public boolean isIfManager() {
        return ifManager;
    }

    public void setIfManager(boolean ifManager) {
        this.ifManager = ifManager;
    }

    public Employee_infoRow(String name, String niNumber, Date birthday, Date hiredate, Date quitdate, String emp_tel, String emp_address, String emp_mail, boolean ifManager) {
        this.name = name;
        this.niNumber = niNumber;
        this.birthday = birthday;
        this.hiredate = hiredate;
        this.quitdate = quitdate;
        this.emp_tel = emp_tel;
        this.emp_address = emp_address;
        this.emp_mail = emp_mail;
        this.ifManager = ifManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNiNumber() {
        return niNumber;
    }

    public void setNiNumber(String niNumber) {
        this.niNumber = niNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getQuitdate() {
        return quitdate;
    }

    public void setQuitdate(Date quitdate) {
        this.quitdate = quitdate;
    }

    public String getEmp_tel() {
        return emp_tel;
    }

    public void setEmp_tel(String emp_tel) {
        this.emp_tel = emp_tel;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public void setEmp_address(String emp_address) {
        this.emp_address = emp_address;
    }

    public String getEmp_mail() {
        return emp_mail;
    }

    public void setEmp_mail(String emp_mail) {
        this.emp_mail = emp_mail;
    }


    @Override
    public String toString() {
        return name + "\t" + niNumber + "\t" + birthday +
                "\t" + hiredate +
                "\t" + quitdate +
                "\t" + emp_tel + "\t" +
                "\t" + emp_address + "\t" + emp_mail +
                "\t" + ifManager;
    }
}
