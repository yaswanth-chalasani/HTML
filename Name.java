package yashu;

public class Name {
 private String fname;
 public String getFname() {
	 return fname;
 }
 public void setFname(String Fname) {
	 this.fname=fname;
 }
 public String getLname() {
	 return lname;
 }
 public void setLname(String Lname) {
	 this.lname=lname;
 }
 private String lname;
 Name(String f,String l){
	 fname=f;lname=l;
 }
 public Name() {
	 
 }
}
