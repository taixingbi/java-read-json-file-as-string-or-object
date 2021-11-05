package hello.model;

public class User {
  String id;
  String name;
  String email;

  public User(String id, String name, String email) {
    this.id= id;
    this.name= name;
    this.email= email;
  }
  public String getId(){
    return id;
  }
  public String getName(){
    return name;
  }
  public String getGmail(){
    return email;
  }
}
